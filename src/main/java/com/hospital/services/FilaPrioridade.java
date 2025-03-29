package com.hospital.services;

import com.hospital.models.Paciente;

import java.time.format.DateTimeFormatter;
import java.util.PriorityQueue;
import java.util.Comparator;

public class FilaPrioridade {
    private final PriorityQueue<Paciente> fila;

    public FilaPrioridade() {
        this.fila = new PriorityQueue<>(Comparator
                .comparingInt((Paciente p) -> p.getClassificacaoRisco().getNivel())
                .thenComparing(Paciente::getDataCadastro));
    }

    public void adicionarPaciente(Paciente paciente) {
        fila.add(paciente);
        System.out.println("Paciente adicionado à fila: " + paciente.getNome());
    }

    public Paciente atenderPaciente() {
        Paciente pacienteAtendido = fila.poll();
        return pacienteAtendido;
    }

    public void exibirFila() {
        if (fila.isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("\n======= Fila de Pacientes =======");
            System.out.printf("%-10s %-20s %-15s %-25s\n", "Prioridade", "Nome", "Classificação", "Data de Cadastro");
            System.out.println("--------------------------------------------------");
            fila.forEach(paciente -> System.out.printf(
                    "%-10d %-20s %-15s %-25s\n",
                    paciente.getClassificacaoRisco().getNivel(),
                    paciente.getNome(),
                    paciente.getClassificacaoRisco().name(),
                    paciente.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
            ));
            System.out.println("==================================");
        }
    }

    public boolean isVazia() {
        return fila.isEmpty();
    }

    public int getTamanhoFila() {
        return fila.size();
    }

    public void limparFila() {
        fila.clear();
        System.out.println("Fila de pacientes limpa.");
    }
}