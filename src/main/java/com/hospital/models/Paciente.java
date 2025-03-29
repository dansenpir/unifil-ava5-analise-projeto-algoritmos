package com.hospital.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Paciente {
    private final UUID id;
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private String sintomas;
    private boolean febre;
    private EClassificacaoRisco classificacaoRisco;
    private final LocalDateTime dataCadastro;

    public Paciente(
            EClassificacaoRisco classificacaoRisco,
            boolean febre,
            String sintomas,
            String endereco,
            String telefone,
            String cpf,
            String nome) {
        this.id = UUID.randomUUID();
        this.dataCadastro = LocalDateTime.now();
        this.classificacaoRisco = classificacaoRisco;
        this.febre = febre;
        this.sintomas = sintomas;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        this.nome = nome;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public boolean isFebre() {
        return febre;
    }

    public void setFebre(boolean febre) {
        this.febre = febre;
    }

    public EClassificacaoRisco getClassificacaoRisco() {
        return classificacaoRisco;
    }

    public void setClassificacaoRisco(EClassificacaoRisco classificacaoRisco) {
        this.classificacaoRisco = classificacaoRisco;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                ", sintomas='" + sintomas + '\'' +
                ", febre=" + febre +
                ", classificacaoRisco=" + classificacaoRisco +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
