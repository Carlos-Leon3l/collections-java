package Exercicios_Map.Pesquisa.Produtos;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EstoqueProduto {
    
    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProduto() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(Long cod, String nome, int quantidade, double preco){

        estoqueProdutosMap.put(cod, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos(){
        System.out.println(estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque(){
        double valorTotalEstoque = 0d;
        if(!estoqueProdutosMap.isEmpty()){
            for (Produto p : estoqueProdutosMap.values()) {
                valorTotalEstoque += p.getQuantidade() * p.getPreco();
            }
        }
        return valorTotalEstoque;
        
    }

    public Produto obterProdutoMaisCaro(){
        Produto getValorMaisCaro = null;
        double maiorValor = Double.MIN_VALUE;
        if(!estoqueProdutosMap.isEmpty()){  
            for(Produto p : estoqueProdutosMap.values()){
                if(p.getPreco() > maiorValor){
                    getValorMaisCaro = p;
                    maiorValor = p.getPreco();
                }
            }
        }
        return getValorMaisCaro;
    }
    public Produto obterProdutoMaisBarato(){
        Produto getValorMaisBarato = null;
        double menorValor = Double.MAX_VALUE;
        if(!estoqueProdutosMap.isEmpty()){  
            for(Produto p : estoqueProdutosMap.values()){
                if(p.getPreco() < menorValor){
                    getValorMaisBarato = p;
                    menorValor = p.getPreco();
                }
            }
        }
        return getValorMaisBarato;
    }
    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque(){
        Produto produtoMaiorQuantidadeValorNoEstoque = null;
        double maiorValorTotalProdutoEstoque = 0d;
        if(!estoqueProdutosMap.isEmpty()){  
            for(Map.Entry<Long, Produto> entry : estoqueProdutosMap.entrySet()){
                double valorProdutoEmEstoque = entry.getValue().getPreco() * entry.getValue().getQuantidade();
                if(valorProdutoEmEstoque > maiorValorTotalProdutoEstoque){
                    maiorValorTotalProdutoEstoque = valorProdutoEmEstoque;
                    produtoMaiorQuantidadeValorNoEstoque =  entry.getValue();
                }
            }
        }
        return produtoMaiorQuantidadeValorNoEstoque;
    }
    
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        EstoqueProduto estoque = new EstoqueProduto();

        while (true) {
            System.out.println("1: Adicionar produtos iniciais");
            System.out.println("2: Exibir produtos");
            System.out.println("3: Calcular valor total do estoque");
            System.out.println("4: Exibir produto mais caro");
            System.out.println("5: Exibir produto mais barato");
            System.out.println("6: Exibir produto com maior valor total");
            System.out.println("7: Sair");
            System.out.print("Escolha uma opção de teste: ");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("-> Adicionando produtos iniciais...");
                estoque.adicionarProduto(1L, "Notebook", 1, 1500.0);
                estoque.adicionarProduto(2L, "Mouse", 5, 25.0);
                estoque.adicionarProduto(3L, "Monitor", 10, 400.0);
                estoque.adicionarProduto(4L, "Teclado", 2, 40.0);
                System.out.println("Produtos adicionados.");
               

            } else if (opcao == 2) {
                System.out.println("-> Testando Exibição...");
                estoque.exibirProdutos();

            } else if (opcao == 3) {
                System.out.println("-> Testando Cálculo do Valor Total...");
                System.out.println("Valor total do estoque: R$" + estoque.calcularValorTotalEstoque());

            } else if (opcao == 4) {
                System.out.println("-> Testando Obtenção do Produto Mais Caro...");
                System.out.println("Produto mais caro: " + estoque.obterProdutoMaisCaro());

            } else if (opcao == 5) {
                System.out.println("-> Testando Obtenção do Produto Mais Barato...");
                System.out.println("Produto mais barato: " + estoque.obterProdutoMaisBarato());

            } else if (opcao == 6) {
                System.out.println("-> Testando Obtenção do Produto com Maior Valor...");
                System.out.println("Produto com maior quantidade em valor no estoque: " + estoque.obterProdutoMaiorQuantidadeValorTotalNoEstoque());

            } else if (opcao == 7) {
                System.out.println("Encerrando testes...");
                break;

            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}
