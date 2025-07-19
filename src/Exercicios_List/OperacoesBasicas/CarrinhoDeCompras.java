package Exercicios_List.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarrinhoDeCompras {

    private List<Item> carrinho;

    public CarrinhoDeCompras() {
    this.carrinho = new ArrayList<>();
    }
    
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        int opcao = -1;
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();


        while (true) {  

            System.out.println("Bem vindo ao mercado, escolha uma opcao");
            
            System.out.println("1- Adicionar item ao carrinho");
            System.out.println("2- remover item do carrinho");
            System.out.println("3- calcular valor total");
            System.out.println("4- exibir Todos os items");
            System.out.println("5- Sair");

            opcao = scanner.nextInt();

            if( opcao == 1){
                carrinhoDeCompras.AdicionarProduto("morango", 10,3);
                carrinhoDeCompras.AdicionarProduto("jaca", 5,2);
                carrinhoDeCompras.AdicionarProduto("pessego", 2,10);
                carrinhoDeCompras.AdicionarProduto("chocolate", 5,2);
            }
            if(opcao == 2){
                carrinhoDeCompras.RemoverprodutodoCarrinho(); 
            }
            else if(opcao == 3){
                carrinhoDeCompras.CalcularValorTotal();
            }
             else if(opcao == 4){
                carrinhoDeCompras.ExibirItens();
            }
             else if(opcao == 5){
                System.exit(5);
            }
        }
            
    }

    public void RemoverprodutodoCarrinho() {
            
        System.out.println("Digite o nome do produto a ser removido");
        String removerproduto = scanner.next();

        if(carrinho.isEmpty()){
            System.out.println("carrinho esta vazio");
        }
        carrinho.removeIf(item -> item.getNome().equalsIgnoreCase(removerproduto));
        System.out.println("Produto removido");
        
    }   

    public void AdicionarProduto(String nome, double preco, int quantidade){
        
        Item item = new Item(nome, preco, quantidade);
        this.carrinho.add(item);
    }

    public void CalcularValorTotal(){
        double valortotalCarrinho = 0;
        if(!carrinho.isEmpty()){

        for(Item i : carrinho){

            double valortotalProduto = i.getPreco() * i.getQuantidade();
            valortotalCarrinho += valortotalProduto;
        }
            System.out.println(valortotalCarrinho);;
        } else {
            throw new RuntimeException("Lista Vazia");
        }
    }
    
    public void ExibirItens(){
        if (!carrinho.isEmpty()) {
            System.out.println(this.carrinho);
        } else {
            System.out.println("A lista está vazia!");
        }
    }
    @Override
    public String toString() {
        return "Itens { "+ carrinho +"}, ";
    }
}
    
