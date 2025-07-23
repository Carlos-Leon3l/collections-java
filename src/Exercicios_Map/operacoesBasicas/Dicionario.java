package Exercicios_Map.operacoesBasicas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dicionario {
    
    private Map<String, String> dicionarioMap;

    public Dicionario() {
        this.dicionarioMap = new HashMap<>();
    }

    public void adicionarPalavra(String nome, String definicao){
        dicionarioMap.put(nome, definicao);
    }

    public void removerPalavra(String palavra){
        if(!dicionarioMap.isEmpty()){
            dicionarioMap.remove(palavra);
        }
    }

    public void exibirPalavras(){
        System.out.println(dicionarioMap);
    }

    public String pesquisarPorPalavra(String palavra){
        String palavraPesquisada = null;

        if(!dicionarioMap.isEmpty()){
            palavraPesquisada = dicionarioMap.get(palavra);
        }
        
        return palavraPesquisada;
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Dicionario dicionario = new Dicionario();

        // Adicionando palavras iniciais, como na sua base
        System.out.println("Adicionando palavras iniciais...");
        dicionario.adicionarPalavra("java", "Linguagem de programação orientada a objetos.");
        dicionario.adicionarPalavra("typescript", "Superset da linguagem JavaScript que adiciona tipagem estática.");
        dicionario.adicionarPalavra("kotlin", "Linguagem moderna de programação para a JVM.");

        while (true) {
            // Exibe o menu de opções de teste
            System.out.println("1: Adicionar 'python'");
            System.out.println("2: Remover 'typescript'");
            System.out.println("3: Pesquisar 'java'");
            System.out.println("4: Exibir Todas as Palavras");
            System.out.println("5: Sair");
            System.out.print("Escolha uma opção de teste: ");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("-> Testando Adição...");
                dicionario.adicionarPalavra("python", "Linguagem de programação popular para ciência de dados.");
                System.out.println("Ação concluída.");

            } else if (opcao == 2) {
                System.out.println("-> Testando Remoção...");   
                dicionario.removerPalavra("typescript");
                System.out.println("Ação concluída.");

            } else if (opcao == 3) {
                System.out.println("-> Testando Pesquisa...");
                String definicao = dicionario.pesquisarPorPalavra("java");
                System.out.println("Resultado da pesquisa: " + definicao);

            } else if (opcao == 4) {
                System.out.println("-> Testando Exibição...");
                dicionario.exibirPalavras();

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
