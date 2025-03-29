package com.hospital.controllers;

import com.hospital.models.EClassificacaoRisco;
import com.hospital.models.Paciente;
import com.hospital.services.FilaPrioridade;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleController {
    private static final FilaPrioridade filaPrioridade = new FilaPrioridade();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            processarOpcao(opcao);
        }
        while (opcao != 4);
    }

    private static void exibirMenu() {
        System.out.println("\nSistema de Triagem de Pacientes");
        System.out.println("1. Adicionar Paciente");
        System.out.println("2. Atender Paciente");
        System.out.println("3. Exibir Fila");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Opção inválida. Por favor, digite um número entre 1 e 4.");
            scanner.next();
            return 0;
        }
    }

    private static void processarOpcao(int opcao) {
        scanner.nextLine();
        switch (opcao) {
            case 1:
                adicionarPaciente();
                break;
            case 2:
                atenderPaciente();
                break;
            case 3:
                exibirFila();
                break;
            case 4:
                System.out.println("Saindo do sistema...");
                break;
            default:
                System.out.println("Opção inválida. Por favor, digite um número entre 1 e 4.");
        }
    }

    private static void adicionarPaciente() {
        System.out.print("Digite o nome do paciente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF do paciente: ");
        String cpf = scanner.nextLine();

        System.out.print("Digite o telefone do paciente: ");
        String telefone = scanner.nextLine();

        System.out.print("Digite o endereço do paciente: ");
        String endereco = scanner.nextLine();

        System.out.print("Digite os sintomas do paciente: ");
        String sintomas = scanner.nextLine();

        System.out.print("O paciente tem febre? (true/false): ");
        boolean febre = lerBoolean();

        EClassificacaoRisco classificacaoRisco = obterClassificacaoRisco();

        if (classificacaoRisco != null) {
            Paciente paciente = new Paciente(
                    classificacaoRisco,
                    febre,
                    sintomas,
                    endereco,
                    telefone,
                    cpf,
                    nome
            );
            filaPrioridade.adicionarPaciente(paciente);
            System.out.println("Paciente " + nome + " adicionado à fila com sucesso.");
        } else {
            System.out.println("Não foi possível adicionar o paciente. Classificação de risco inválida.");
        }
    }

    private static boolean lerBoolean() {
        while (true) {
            try {
                boolean valor = scanner.nextBoolean();
                scanner.nextLine();
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite 'true' ou 'false'.");
                scanner.next();
            }
        }
    }

    private static EClassificacaoRisco obterClassificacaoRisco() {
        System.out.println("Selecione a classificação de risco:");
        System.out.println("1. VERMELHO (Emergência)");
        System.out.println("2. LARANJA (Muito Urgente)");
        System.out.println("3. AMARELO (Urgente)");
        System.out.println("4. VERDE (Pouco Urgente)");
        System.out.println("5. AZUL (Não Urgente)");
        System.out.print("Digite o número da classificação de risco: ");

        try {
            int risco = scanner.nextInt();
            scanner.nextLine();

            return switch (risco) {
                case 1 -> EClassificacaoRisco.VERMELHO;
                case 2 -> EClassificacaoRisco.LARANJA;
                case 3 -> EClassificacaoRisco.AMARELO;
                case 4 -> EClassificacaoRisco.VERDE;
                case 5 -> EClassificacaoRisco.AZUL;
                default -> {
                    System.out.println("Classificação de risco inválida.");
                    yield null;
                }
            };
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite um número entre 1 e 5.");
            scanner.next();
            return null;
        }
    }

    private static void atenderPaciente() {
        Paciente pacienteAtendido = filaPrioridade.atenderPaciente();
        if (pacienteAtendido != null) {
            System.out.println("Paciente atendido: " + pacienteAtendido);
        } else {
            System.out.println("Não há pacientes na fila.");
        }
    }

    private static void exibirFila() {
        filaPrioridade.exibirFila();
    }
}