package src.main.java.com.hospital.services;


import src.main.java.com.hospital.models.Paciente;

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
        if (pacienteAtendido != null) {
            System.out.println("Paciente atendido: " + pacienteAtendido.getNome());
        } else {
            System.out.println("Nenhum paciente na fila para atender.");
        }
        return pacienteAtendido;
    }

    public void exibirFila() {
        if (fila.isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("Fila de pacientes:");
            fila.forEach(paciente -> System.out.println(
                    paciente.getClassificacaoRisco() + " - " + paciente.getNome() + " (Cadastrado em: " + paciente.getDataCadastro() + ")"
            ));
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