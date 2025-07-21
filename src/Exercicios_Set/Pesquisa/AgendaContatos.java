package Exercicios_Set.Pesquisa;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AgendaContatos {
    
    private Set<Contato> contatosSet;

    public AgendaContatos() {
        this.contatosSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero){
        this.contatosSet.add(new Contato(nome, numero));
    }
    public void exibirContatos(){
        System.out.println(this.contatosSet);
    }
    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatoPorNome = new HashSet<>();
        for(Contato i : contatosSet){
            if(i.getNome().startsWith(nome)){
                contatoPorNome.add(i);
            }
        }
        return contatoPorNome;
    }
    public Contato atualizarNumeroContato(String nome, int novoNumero){
        Contato contatoAtualizado = null;

        for (Contato c : contatosSet) {
            if(c.getNome().equalsIgnoreCase(nome)){
                c.setNumero(novoNumero);
                contatoAtualizado = c;
                break;
            }
        }
        return contatoAtualizado;
    }

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        var opcao = -1;

        while (true) {
            System.out.println("1- adicionar contato");
            System.out.println("2- Exibir Contatos");
            System.out.println("3- Pesquisar por nome");
            System.out.println("4- Atualizar numero de Contato");

            opcao = scanner.nextInt();

            if(opcao == 1){
                agendaContatos.adicionarContato("João", 123456789);
                agendaContatos.adicionarContato("Maria", 987654321);
                agendaContatos.adicionarContato("Maria Fernandes", 55555555);
                agendaContatos.adicionarContato("Ana", 88889999);
                agendaContatos.adicionarContato("Fernando", 77778888);
                agendaContatos.adicionarContato("Carolina", 55555555);
            }
            else if(opcao == 2){
                agendaContatos.exibirContatos();
            }
            else if(opcao == 3){
                System.out.println(agendaContatos.pesquisarPorNome("Maria"));
            }
            else if(opcao == 4){
                Contato contatoAtualizado = agendaContatos.atualizarNumeroContato("Carolina", 44443333);
                System.out.println("Contato atualizado: " + contatoAtualizado);

                System.out.println("Contatos na agenda após atualização:");
                agendaContatos.exibirContatos();
            }
    
        }
    }

}
