package com.hospital.models;

public enum EClassificacaoRisco {
    VERMELHO(1, "Necessitam de atendimento imediato. CASOS DE EMERGÊNCIA"),
    LARANJA(2, "Necessitam de atendimento praticamente imediato. CASOS MUITO URGENTES"),
    AMARELO(3, "Necessitam de atendimento rápido, mas podem aguardar. CASOS DE URGÊNCIA"),
    VERDE(4, "Podem aguardar atendimento ou serem encaminhados. CASOS POUCO URGENTES"),
    AZUL(5, "Podem aguardar ou serem encaminhados. CASOS NÃO URGENTES");

    private final int nivel;
    private final String descricao;

    EClassificacaoRisco(
            int nivel,
            String descricao) {
        this.nivel = nivel;
        this.descricao = descricao;
    }

    public int getNivel() {
        return nivel;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "EClassificacaoRisco{" +
                "nivel=" + nivel +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
