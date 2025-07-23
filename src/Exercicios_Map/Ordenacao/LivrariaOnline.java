package Exercicios_Map.Ordenacao;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LivrariaOnline {
    
    private Map<String, Livro> livrariaMap;


    public LivrariaOnline() {
        this.livrariaMap = new HashMap<>();
    }


    public void adicionarLivro(String link, Livro livro){
        livrariaMap.put(link, livro);
    }

    public void exibirLivros(){
        System.out.println(this.livrariaMap);
    }

    public void removerLivro(String titulo){
        livrariaMap.remove(titulo);
    }
    
    public void exibirLivrosOrdenadosPorPreco(){
        List<Map.Entry<String, Livro>> livrosParaOrdenarPorPreco = new ArrayList<>(livrariaMap.entrySet());    
        
        livrosParaOrdenarPorPreco.sort(Comparator.comparingDouble(entry -> entry.getValue().getPreco()));

        for (Map.Entry<String, Livro> entry : livrosParaOrdenarPorPreco) {
            Livro livro = entry.getValue();
            System.out.println(livro.getPreco() + " - " + livro.getTitulo() +  " - " + livro.getAutor() + " Link: " + entry.getKey());
        }
        
    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor){
        Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrariaMap.entrySet()) {  
            Livro livro = entry.getValue();
            if(livro.getAutor() == autor){
                livrosPorAutor.put(entry.getKey(), livro);
            }
        }
        return livrosPorAutor;
    }
    public Livro obterLivroMaisCaro(){
        Livro getValorMaisCaro = null;
        double maiorValor = Double.MIN_VALUE;
        if(!livrariaMap.isEmpty()){  
            for(Livro p : livrariaMap.values()){
                if(p.getPreco() > maiorValor){
                    getValorMaisCaro = p;
                    maiorValor = p.getPreco();
                }
            }
        }
        return getValorMaisCaro;
    }
    public Livro exibirLivroMaisBarato(){
        Livro getValorMaisBarato = null;
        double menorValor = Double.MAX_VALUE;
        if(!livrariaMap.isEmpty()){  
            for(Livro p : livrariaMap.values()){
                if(p.getPreco() < menorValor){
                    getValorMaisBarato = p;
                    menorValor = p.getPreco();
                }
            }
        }
        return getValorMaisBarato;
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        while (true) {
            System.out.println("1: Exibir livros ordenados por preço");
            System.out.println("2: Exibir livros ordenados por autor");
            System.out.println("3: Pesquisar livros de 'Josh Malerman'");
            System.out.println("4: Obter livro mais caro");
            System.out.println("5: Obter livro mais barato");
            System.out.println("6: Remover o livro '1984'");
            System.out.println("7: Adicionar Livros");
            System.out.println("8: Sair");
            System.out.print("Escolha uma opção de teste: ");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("-> Testando ordenação por preço...");
                livrariaOnline.exibirLivrosOrdenadosPorPreco();

            } else if (opcao == 2) {
                System.out.println("-> Testando ordenação por autor...");
                System.out.println(livrariaOnline.pesquisarLivrosPorAutor("Josh Malerman"));

            } else if (opcao == 3) {
                System.out.println("-> Testando pesquisa por autor...");
                Map<String, Livro> livrosDoAutor = livrariaOnline.pesquisarLivrosPorAutor("Josh Malerman");
                System.out.println("Livros de Josh Malerman: " + livrosDoAutor);

            } else if (opcao == 4) {
                System.out.println("-> Testando obtenção do livro mais caro...");
                System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

            } else if (opcao == 5) {
                System.out.println("-> Testando obtenção do livro mais barato...");
                System.out.println("Livro mais barato: " + livrariaOnline.exibirLivroMaisBarato());

            } else if (opcao == 6) {
                System.out.println("-> Testando remoção de livro...");
                livrariaOnline.removerLivro("1984");
                System.out.println("Estado atual da livraria (após remoção):");
                livrariaOnline.exibirLivros();
            
            } else if (opcao == 7){
                System.out.println("-> Adicionando Livros ...");
                        // Adiciona os livros à livraria online
                livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", new Livro("1984", "George Orwell", 50d));
                livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", new Livro("A Revolução dos Bichos", "George Orwell", 7.05d));
                livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", new Livro("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
                livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", new Livro("Malorie", "Josh Malerman", 5d));
                livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", new Livro("E Não Sobrou Nenhum", "Agatha Christie", 50d));
                livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", new Livro("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));
            } else if (opcao == 8) {
                System.out.println("Encerrando programa...");
                break;
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }
}
