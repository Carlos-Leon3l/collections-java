package Exercicios_Set.Ordenacao.ListaTarefas;

public class Tarefa {
    
    private String descricao;
    private boolean concluido;

    
    @Override
    public String toString() {
        return "Tarefa {descricao=" + descricao + ", concluido=" + concluido + "}";
    }
    public Tarefa(String descricao, boolean concluido) {
        this.descricao = descricao;
        this.concluido = concluido;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public boolean isConcluido() {
        return concluido;
    }
    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
    
}
