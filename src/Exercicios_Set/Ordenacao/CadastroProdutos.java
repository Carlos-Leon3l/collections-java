package Exercicios_Set.Ordenacao;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    
    private Set<Produto> produtosSet;

    public CadastroProdutos() {
        this.produtosSet = new HashSet<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade){
        this.produtosSet.add(new Produto(cod, nome, preco, quantidade));
    }

    public Set<Produto> produtoPorNome(){
        //TreeSet deixa o set organizado
        Set<Produto> produtoPorNomeOrdenado = new TreeSet<>(produtosSet);
        return produtoPorNomeOrdenado;
    }

    public Set<Produto> exibirProdutosPorPreco(){
        Set<Produto> produtoPorPreco = new TreeSet<>(new CompararPorPreco());
        produtoPorPreco.addAll(produtosSet);
        return produtoPorPreco;
    }
    
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        CadastroProdutos cadastroProdutos = new CadastroProdutos();
        var opcao = -1;
    // Adicionando produtos ao cadastro
        while (true) {
            opcao = scanner.nextInt();
            
            if(opcao == 1){
                cadastroProdutos.adicionarProduto(1L, "Smartphone", 1000d, 10);
                cadastroProdutos.adicionarProduto(2L, "Notebook", 1500d, 5);
                cadastroProdutos.adicionarProduto(1L, "Mouse", 30d, 20);
                cadastroProdutos.adicionarProduto(4L, "Teclado", 50d, 15);
            }
            else if(opcao == 2){
                System.out.println(cadastroProdutos.produtosSet);
            }
            else if(opcao == 3){
                System.out.println(cadastroProdutos.produtoPorNome());
            }
            else if(opcao == 4){
                System.out.println(cadastroProdutos.exibirProdutosPorPreco());
            } 
            else if(opcao == 5){
                System.exit(5);
            }
        }
    }
}
