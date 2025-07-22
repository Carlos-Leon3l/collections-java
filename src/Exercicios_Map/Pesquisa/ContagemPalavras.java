package Exercicios_Map.Pesquisa;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContagemPalavras {
    private String palavra;
    private Integer contagem;

    public String getPalavra() {
        return palavra;
    }

    public Integer getContagem() {
        return contagem;
    }
    private Map<String, Integer> contagemMap;

    public ContagemPalavras() {
        this.contagemMap = new HashMap<>();
    }

    public void adicionarPalavras(String palavra, Integer contagem){
        this.contagemMap.put(palavra, contagem);
    }

    public void exibirContagemPalavras(){
        System.out.println(contagemMap);
    }

    public void removerPalavra(String Palavra){
        contagemMap.remove(Palavra);
    }

    public String encontrarPalavraMaisFrequente(){
        int maiorcontagem = 0;
        String palavraMaisRepetida = null;

        for (Map.Entry<String, Integer> entry : contagemMap.entrySet()) {
            int qtdVezesEncontrada = entry.getValue();
            if(qtdVezesEncontrada > maiorcontagem ){
                maiorcontagem = qtdVezesEncontrada;
                palavraMaisRepetida = entry.getKey();
            }
        }

        return palavraMaisRepetida;
    }

    @Override
    public String toString() {
        // Usa StringBuilder para construir a string de forma eficiente.
        StringBuilder sb = new StringBuilder();

        // Itera sobre cada entrada (par chave-valor) do mapa.
        for (Map.Entry<String, Integer> entry : contagemMap.entrySet()) {
            sb.append("Palavra: '")
                .append(entry.getKey()) // Adiciona a palavra (chave)
                .append("', Contagem: ")
                .append(entry.getValue()) // Adiciona a contagem (valor)
            .append("\n"); // Adiciona uma nova linha para o próximo item
        }
        // Retorna a string construída.
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContagemPalavras contagemLinguagens = new ContagemPalavras();

        // Adicionando as linguagens iniciais para o teste
        contagemLinguagens.adicionarPalavras("Java", 2);
        contagemLinguagens.adicionarPalavras("Python", 8);
        contagemLinguagens.adicionarPalavras("JavaScript", 1);
        contagemLinguagens.adicionarPalavras("C#", 6);

        while (true) {
            System.out.println("1: Adicionar 'Go' com contagem 10");
            System.out.println("2: Exibir contagem total de palavras");
            System.out.println("3: Encontrar palavra mais frequente");
            System.out.println("4: Remover a Palavra 'Go' ");
            System.out.println("5: Sair");
            System.out.print("Escolha uma opção de teste: ");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
                System.out.println("-> Testando Adição...");
                contagemLinguagens.adicionarPalavras("Go", 10);
                System.out.println("'Go' adicionado. Use a opção 4 para verificar.");

            } else if (opcao == 2) {
                System.out.println("-> Testando Exibição da Contagem...");
                contagemLinguagens.exibirContagemPalavras();

            } else if (opcao == 3) {
                System.out.println("-> Testando Busca pela Palavra Mais Frequente...");
                String linguagemMaisFrequente = contagemLinguagens.encontrarPalavraMaisFrequente();
                System.out.println("A linguagem mais frequente é: " + linguagemMaisFrequente);
                
            } else if (opcao == 4) {
                System.out.println("-> Removendo Palavra 'Go' ");
                contagemLinguagens.removerPalavra("Go");
                System.out.println("Palavra Removida ...");
            } else if (opcao == 5) {
                System.out.println("Encerrando programa...");
                break;

            } else {
                System.out.println("Opção inválida! Por favor, tente novamente.");
            }
        }

        scanner.close();
     
    }
    
}
