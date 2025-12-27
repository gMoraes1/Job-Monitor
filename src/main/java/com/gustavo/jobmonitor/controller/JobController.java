package com.gustavo.jobmonitor.controller;

import com.gustavo.jobmonitor.dto.JobRequestDTO;
import com.gustavo.jobmonitor.dto.JobResponseDTO;
import com.gustavo.jobmonitor.service.JobService;

import jakarta.validation.Valid;
import com.gustavo.jobmonitor.model.JobStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public JobResponseDTO criar(@Valid @RequestBody JobRequestDTO jobRequestDTO) {
        return jobService.criarJob(jobRequestDTO);
    }

    @GetMapping
    public Page<JobResponseDTO> listar(Pageable pageable) {
        return jobService.listarJobs(pageable);
    }

    @GetMapping("/status/{status}")
    public Page<JobResponseDTO> listarPorStatus(
            @PathVariable JobStatus status,
            Pageable pageable
    ) {
        return jobService.listarJobsPorStatus(status, pageable);
    }

    @PatchMapping("/{id}/status")
    public JobResponseDTO atualizarStatus(
            @PathVariable Long id,
            @RequestParam JobStatus status
    ) {
        return jobService.atualizarStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        jobService.deletar(id);
    }
}
