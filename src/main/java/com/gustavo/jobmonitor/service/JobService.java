package com.gustavo.jobmonitor.service;

import com.gustavo.jobmonitor.dto.JobRequestDTO;
import com.gustavo.jobmonitor.dto.JobResponseDTO;
import com.gustavo.jobmonitor.model.Job;
import com.gustavo.jobmonitor.repository.JobRepository;
import com.gustavo.jobmonitor.model.JobStatus;
import com.gustavo.jobmonitor.exception.ResourceNotFoundException;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;


    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    private JobResponseDTO toResponse(Job job) {
        JobResponseDTO dto = new JobResponseDTO();
        dto.setId(job.getId()); 
        dto.setNome(job.getNome());
        dto.setDescricao(job.getDescricao());   
        dto.setStatus(job.getStatus()); 
        dto.setDataCriacao(job.getDataCriacao());
        dto.setDataAtualizacao(job.getDataAtualizacao());   
        return dto; 
    }

    public JobResponseDTO criarJob(JobRequestDTO request) {
        Job job = new Job();
        job.setNome(request.getNome());
        job.setDescricao(request.getDescricao());   
        
        Job salvo = jobRepository.save(job);
        return toResponse(salvo);
    }

    public Page<JobResponseDTO> listarJobs(Pageable pageable) {
        return jobRepository.findAll(pageable)
                .map(this::toResponse);
    }

    public Page<JobResponseDTO> listarJobsPorStatus(JobStatus status, Pageable pageable) {
        return jobRepository.findByStatus(status, pageable)
                .map(this::toResponse);
    }

    public JobResponseDTO atualizarStatus(Long id, JobStatus status) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job nao encontrado com id: " + id ));
        job.setStatus(status);
        Job atualizado = jobRepository.save(job);
        return toResponse(atualizado);
    }

    public void deletar(Long id) {
        jobRepository.deleteById(id);
    }
}
