package com.gustavo.jobmonitor.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para requisicao de criacao ou atualizacao de Job")
public class JobRequestDTO {

        @Schema(example = "Processar relatorios mensais")
        @NotBlank(message = "Nome nao pode ser vazio")
        @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")   
        private String nome;

        @Schema(example = "Job responsavel por processar os relatorios mensais de vendas")
        @NotBlank(message = "Descricao nao pode ser vazia")
        private String descricao;

        public String getNome() {
            return this.nome;
        }

        public String getDescricao() {
            return this.descricao;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }
}
