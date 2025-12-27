package com.gustavo.jobmonitor.dto;
import com.gustavo.jobmonitor.model.JobStatus;
import java.time.LocalDateTime;

public class JobResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
    private JobStatus status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }           

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }                   

    public JobStatus getStatus() {
        return status;
    }   

    public void setStatus(JobStatus status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }                       

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }   

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
