package com.gustavo.jobmonitor.controller;

import com.gustavo.jobmonitor.dto.JobRequestDTO;
import com.gustavo.jobmonitor.dto.JobResponseDTO;
import com.gustavo.jobmonitor.service.JobService;

import jakarta.validation.Valid;
import com.gustavo.jobmonitor.model.JobStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/jobs")
@Tag(name = "Jobs", description = "API para gerenciamento de jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @Operation(summary = "Criar um novo job")
    @PostMapping
    public JobResponseDTO criar(@Valid @RequestBody JobRequestDTO jobRequestDTO) {
        return jobService.criarJob(jobRequestDTO);
    }

    @Operation(summary = "Listar todos os jobs com paginação")
    @GetMapping
    public Page<JobResponseDTO> listar(Pageable pageable) {
        return jobService.listarJobs(pageable);
    }

    @Operation(summary = "Listar jobs por status")
    @GetMapping("/status/{status}")
    public Page<JobResponseDTO> listarPorStatus(
            @PathVariable JobStatus status,
            Pageable pageable
    ) {
        return jobService.listarJobsPorStatus(status, pageable);
    }

    @Operation(summary = "Atualizar o status de um job")
    @PatchMapping("/{id}/status")
    public JobResponseDTO atualizarStatus(
            @PathVariable Long id,
            @RequestParam JobStatus status
    ) {
        return jobService.atualizarStatus(id, status);
    }

    @Operation(summary = "Deletar um job por ID")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        jobService.deletar(id);
    }
}
