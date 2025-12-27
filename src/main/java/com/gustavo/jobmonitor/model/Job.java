package com.gustavo.jobmonitor.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private JobStatus status;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;

    public Job() {
        this.dataCriacao = LocalDateTime.now();
        this.status = JobStatus.PENDING;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public JobStatus getStatus() {
        return this.status;
    }

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return this.dataAtualizacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}

    