package com.hospital.controllers;

import com.hospital.models.EClassificacaoRisco;
import com.hospital.models.Paciente;
import com.hospital.services.FilaPrioridade;
import com.hospital.utils.ConsoleColors;

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
        System.out.println(
                ConsoleColors.CYAN + "\n===== Sistema de Triagem de Pacientes =====" + ConsoleColors.RESET);
        System.out.println("1. Adicionar Paciente");
        System.out.println("2. Atender Paciente");
        System.out.println("3. Exibir Fila");
        System.out.println("4. Sair");
        System.out.println(ConsoleColors.CYAN + "==========================================" + ConsoleColors.RESET);
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
        String              nome               = lerNome();
        String              cpf                = lerCPF();
        String              telefone           = lerTelefone();
        String              endereco           = lerEndereco();
        String              sintomas           = lerSintomas();
        boolean             febre              = lerFebre();
        EClassificacaoRisco classificacaoRisco = obterClassificacaoRisco();

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
    }

    private static String lerNome() {
        System.out.print("Digite o nome do paciente: ");
        return scanner.nextLine();
    }

    private static String lerCPF() {
        System.out.print("Digite o CPF do paciente: ");
        return scanner.nextLine();
    }

    private static String lerTelefone() {
        System.out.print("Digite o telefone do paciente: ");
        return scanner.nextLine();
    }

    private static String lerEndereco() {
        System.out.print("Digite o endereço do paciente: ");
        return scanner.nextLine();
    }

    private static String lerSintomas() {
        System.out.print("Digite os sintomas do paciente: ");
        return scanner.nextLine();
    }

    private static boolean lerFebre() {
        while (true) {
            System.out.print("O paciente tem febre? (s/n): ");
            String resposta = scanner.nextLine().trim().toLowerCase();
            if (resposta.equals("s")) {
                return true;
            } else if (resposta.equals("n")) {
                return false;
            } else {
                System.out.println("Entrada inválida. Por favor, digite 's' para sim ou 'n' para não.");
            }
        }
    }

    private static EClassificacaoRisco obterClassificacaoRisco() {
        while (true) {
            System.out.println(ConsoleColors.CYAN + "Selecione a classificação de risco:" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.RED + "1. VERMELHO (Emergência)" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.ORANGE + "2. LARANJA (Muito Urgente)" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "3. AMARELO (Urgente)" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + "4. VERDE (Pouco Urgente)" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE + "5. AZUL (Não Urgente)" + ConsoleColors.RESET);
            System.out.print(
                    ConsoleColors.CYAN + "Digite o número da classificação de risco: " + ConsoleColors.RESET);

            try {
                int risco = scanner.nextInt();
                scanner.nextLine();

                switch (risco) {
                    case 1:
                        System.out.println(
                                ConsoleColors.RED + "Classificação VERMELHO selecionada." + ConsoleColors.RESET);
                        return EClassificacaoRisco.VERMELHO;
                    case 2:
                        System.out.println(
                                ConsoleColors.ORANGE + "Classificação LARANJA selecionada." + ConsoleColors.RESET);
                        return EClassificacaoRisco.LARANJA;
                    case 3:
                        System.out.println(
                                ConsoleColors.YELLOW + "Classificação AMARELO selecionada." + ConsoleColors.RESET);
                        return EClassificacaoRisco.AMARELO;
                    case 4:
                        System.out.println(
                                ConsoleColors.GREEN + "Classificação VERDE selecionada." + ConsoleColors.RESET);
                        return EClassificacaoRisco.VERDE;
                    case 5:
                        System.out.println(
                                ConsoleColors.BLUE + "Classificação AZUL selecionada." + ConsoleColors.RESET);
                        return EClassificacaoRisco.AZUL;
                    default:
                        System.out.println(
                                ConsoleColors.RED + "Classificação de risco inválida. Tente novamente." + ConsoleColors.RESET);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(
                        ConsoleColors.RED + "Entrada inválida. Digite um número entre 1 e 5." + ConsoleColors.RESET);
                scanner.next();
                scanner.nextLine();
            }
        }
    }

    private static void atenderPaciente() {
        Paciente pacienteAtendido = filaPrioridade.atenderPaciente();
        if (pacienteAtendido != null) {
            System.out.println("Paciente atendido: \n" + pacienteAtendido);
        } else {
            System.out.println("Não há pacientes na fila.");
        }
    }

    private static void exibirFila() {
        filaPrioridade.exibirFila();
    }
}