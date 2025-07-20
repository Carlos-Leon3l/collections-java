package Exercicios_Set.Ordenacao.ListaTarefas;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ListaTarefas {

    private Set<Tarefa> tarefasSet;
    
    public ListaTarefas() {
        this.tarefasSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        this.tarefasSet.add(new Tarefa(descricao, false)) ;
    }
    public void removerTarefa(String descricao) {
        Tarefa descricaoRemovida = null;
        for (Tarefa t : tarefasSet) {
            if(t.getDescricao() == descricao){
                descricaoRemovida = t;
                break;
            }   
        }
        tarefasSet.remove(descricaoRemovida);
        System.out.println("Tarefa Removida");
    }
    public void exibirTarefas() {
        System.out.println(this.tarefasSet);
    }
    public void contarTarefas() {
        tarefasSet.size();
    }
    public void obterTarefasConcluidas() {
        for (Tarefa t : tarefasSet) {
            if(t.isConcluido()){
                System.out.println(t.getDescricao());
            }
        }
    }
    public void obterTarefasPendentes() {
        for (Tarefa t : tarefasSet) {
            if(!t.isConcluido()){
                System.out.println(t.getDescricao());
            }
        }
    }
    public void marcarTarefaConcluida(String descricao) {
        for (Tarefa t : tarefasSet) {
            if(t.getDescricao() == descricao){
                if(!t.isConcluido()){
                    t.setConcluido(true);
                } else {
                    System.out.println("Ja esta concluida");
                }
            }
            break;
        }
    }
    public void marcarTarefaPendente(String descricao) {
        for (Tarefa t : tarefasSet) {
            if(t.getDescricao() == descricao){
                if(t.isConcluido()){
                    t.setConcluido(false);
                } else {
                    System.out.println("Ja esta pendente");
                }
            }
            break;
        }
    }
    public void limparListaTarefas() {
        tarefasSet.removeAll(tarefasSet);
    }

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        ListaTarefas listaTarefas = new ListaTarefas();
        int opcao = -1;
        while (true) {
        
        System.out.println("1- Adicionar Tarefa ");
        System.out.println("2- Remover Tarefa ");
        System.out.println("3- Exibir Tarefa ");
        System.out.println("4- Contar Tarefa ");
        System.out.println("5- Obter tarefa concluidas");
        System.out.println("6- Obter Tarefa pendente");
        System.out.println("7- Marcar Tarefa concluida");
        System.out.println("8- Marcar Tarefa pendente");
        System.out.println("9- Limpar todas as tarefas");
        System.out.println("10- Sair");

        opcao = scanner.nextInt();

            if(opcao == 1){
                listaTarefas.adicionarTarefa("Treinar");
                listaTarefas.adicionarTarefa("Estudar");
                listaTarefas.adicionarTarefa("Cantar");
                listaTarefas.adicionarTarefa("Trabalhar");
            }
            else if(opcao == 2){
                listaTarefas.removerTarefa("Treinar");
            }
            else if(opcao == 3){
                listaTarefas.exibirTarefas();
            }
            else if(opcao == 4){
                listaTarefas.contarTarefas();
                
            }
            else if(opcao == 5){
                listaTarefas.obterTarefasConcluidas();
                
            }
            else if(opcao == 6){
                listaTarefas.obterTarefasPendentes();
            }
            else if(opcao == 7){
                listaTarefas.marcarTarefaConcluida("Cantar");
            }
            else if(opcao == 8){
                listaTarefas.marcarTarefaPendente("Cantar");
            }
            else if(opcao == 9){
                listaTarefas.limparListaTarefas();
            }
            else if(opcao == 10){
                System.exit(opcao);
            }

        }
    }
}

// adicionarTarefa(String descricao): Adiciona uma nova tarefa ao Set.
// removerTarefa(String descricao): Remove uma tarefa do Set de acordo com a descrição, se estiver presente.
// exibirTarefas(): Exibe todas as tarefas da lista de tarefas.
// contarTarefas(): Conta o número total de tarefas na lista de tarefas.
// obterTarefasConcluidas(): Retorna um Set com as tarefas concluídas.
// obterTarefasPendentes(): Retorna um Set com as tarefas pendentes.
// marcarTarefaConcluida(String descricao): Marca uma tarefa como concluída de acordo com a descrição.
// marcarTarefaPendente(String descricao): Marca uma tarefa como pendente de acordo com a descrição.
// limparListaTarefas(): Remove todas as tarefas da lista de tarefas.
