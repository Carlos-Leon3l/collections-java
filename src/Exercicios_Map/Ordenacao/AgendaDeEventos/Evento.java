package Exercicios_Map.Ordenacao.AgendaDeEventos;

import java.time.LocalDate;

public class Evento {
    
    private LocalDate data;
    private String nome;
    private String atracao;

    
    public LocalDate getData() {
        return data;
    }


    public String getNome() {
        return nome;
    }


    public String getAtracao() {
        return atracao;
    }


    public Evento(LocalDate data, String nome, String atracao) {
        this.data = data;
        this.nome = nome;
        this.atracao = atracao;
    }


}
