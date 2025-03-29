package com.hospital.utils;

public class ValidacaoUtils {

    public static boolean validarNome(String nome) {
        return nome != null && nome.trim().length() >= 3;
    }

    public static boolean validarCPF(String cpf) {
        return validarNumeroComTamanhoEspecifico(cpf, 11);
    }

    public static boolean validarTelefone(String telefone) {
        return validarNumeroComTamanhoEspecifico(telefone, 11);
    }

    public static boolean validarEndereco(String endereco) {
        return validarTamanhoString(endereco, 5, 200);
    }

    public static boolean validarSintomas(String sintomas) {
        return validarTamanhoString(sintomas, 3, 500);
    }

    public static boolean validarFebre(String resposta) {
        if (resposta == null) {
            return false;
        }
        String respostaNormalizada = resposta.toLowerCase().trim();
        return respostaNormalizada.equals("s") || respostaNormalizada.equals("sim") ||
                respostaNormalizada.equals("n") || respostaNormalizada.equals("não") ||
                respostaNormalizada.equals("nao");
    }

    private static boolean validarNumeroComTamanhoEspecifico(
            String numero,
            int tamanho) {
        if (numero == null) {
            return false;
        }
        String numeroLimpo = numero.replaceAll("[^0-9]", "");
        return numeroLimpo.length() == tamanho;
    }

    private static boolean validarTamanhoString(
            String texto,
            int minimo,
            int maximo) {
        return texto != null && texto.trim().length() >= minimo && texto.trim().length() <= maximo;
    }
}