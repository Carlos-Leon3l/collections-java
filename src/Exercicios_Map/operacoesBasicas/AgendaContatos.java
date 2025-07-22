package Exercicios_Map.operacoesBasicas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AgendaContatos {
    //
    private Map<String, Integer> agendaContatoMap;

    public AgendaContatos() {
        this.agendaContatoMap = new HashMap<>();
    }

    public void adicionarContato(String nome, Integer telefone){
        this.agendaContatoMap.put(nome, telefone);
    }
    public void removerContato(String nome){
        if(!agendaContatoMap.isEmpty()){
            agendaContatoMap.remove(nome);
        }
    }
    public void exibirContatos(){
        System.out.println(agendaContatoMap);
    }
    public Integer pesquisaContato(String nome){
        Integer numerocontato = null;
        if(!agendaContatoMap.isEmpty()){
            numerocontato = agendaContatoMap.get(nome);
        }
        return numerocontato;
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        AgendaContatos agendaContatos = new AgendaContatos();

        // Adicionando contatos iniciais para o teste
        System.out.println("Adicionando contatos iniciais...");
        agendaContatos.adicionarContato("Camila", 123456);
        agendaContatos.adicionarContato("João", 5665);
        agendaContatos.adicionarContato("Carlos", 1111111);
        agendaContatos.adicionarContato("Ana", 654987);
        agendaContatos.adicionarContato("Maria", 1111111);
        agendaContatos.adicionarContato("Camila", 44444); //Irá atualizar o número da Camila

        while (true) {
            // Exibe o menu de opções de teste
            System.out.println("\n===== MENU DE TESTES - AGENDA =====");
            System.out.println("1: Adicionar 'Pedro'");
            System.out.println("2: Remover 'Maria'");
            System.out.println("3: Pesquisar 'João'");
            System.out.println("4: Exibir Todos os Contatos");
            System.out.println("5: Sair");
            System.out.print("Escolha uma opção de teste: ");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("-> Testando Adição...");
                agendaContatos.adicionarContato("Pedro", 999888);
                System.out.println("Ação concluída. Use a opção 4 para ver o resultado.");

            } else if (opcao == 2) {
                System.out.println("-> Testando Remoção...");
                agendaContatos.removerContato("Maria");
                System.out.println("Ação concluída. Use a opção 4 para ver o resultado.");

            } else if (opcao == 3) {
                System.out.println("-> Testando Pesquisa...");
                Integer numero = agendaContatos.pesquisaContato("João");
                if (numero != null) {
                    System.out.println("Resultado da pesquisa por 'João': " + numero);
                } else {
                    System.out.println("Contato 'João' não encontrado.");
                }

            } else if (opcao == 4) {
                System.out.println("-> Testando Exibição...");
                agendaContatos.exibirContatos();

            } else if (opcao == 5) {
                System.out.println("Encerrando testes...");
                break; 

            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}
