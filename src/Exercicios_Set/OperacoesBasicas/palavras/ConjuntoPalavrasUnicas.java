package Exercicios_Set.OperacoesBasicas.palavras;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class ConjuntoPalavrasUnicas {
    private static Scanner scanner = new Scanner(System.in);

    private String palavra;

    private Set<String> palavrasUnicaSet;

    @Override
    public String toString() {
        return "ConjuntoPalavrasUnicas {palavra= " + palavra + "}";
    }

    public String getPalavra() {
        return palavra;
    }

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicaSet = new HashSet<>();
    }

    public ConjuntoPalavrasUnicas(String palavra) {
        this.palavra = palavra;
    }

    
    public void adicionarPalavra(String palavra){
        palavrasUnicaSet.add(palavra);
    }
    public void removerPalavra(String palavra){
        // String palavraRemovida = palavra;
        // palavrasUnicaSet.removeIf((palavraEncontrada) -> palavra.equalsIgnoreCase(palavraRemovida));

        // System.out.println("Foi removido a palavra: "+ palavraEncontrada);
        String palavraRemovida = null;
        for (String i : palavrasUnicaSet) {
            if( i == palavra){
                palavraRemovida = i;
                break;
            }
        }
        palavrasUnicaSet.remove(palavraRemovida);
    }
    public void verificarPalavra(String palavra){
        String palavranaLista = null;
        for (String i : palavrasUnicaSet) {
            if( i == palavra){
                palavranaLista = i;
                break;
            }
        }
        System.out.println("A palavra "+ palavranaLista + " esta na lista ");
    }
    public void exibirPalavrasUnicas(){
        System.out.println(this.palavrasUnicaSet);
    }


    public static void main(String[] args) {
        System.out.println("Palavras únicas");

        ConjuntoPalavrasUnicas conjuntoPalavrasUnicas = new ConjuntoPalavrasUnicas();
        int option = -1;
        while (true) {
            System.out.println("1- Adicionar palavras ");
            System.out.println("2- Remover palavra ");
            System.out.println("3- Verificar palavra ");
            System.out.println("4- Exibir palavras ");
            System.out.println("5- Sair");

            option = scanner.nextInt();

            if(option == 1){
                conjuntoPalavrasUnicas.adicionarPalavra("Agua");
                conjuntoPalavrasUnicas.adicionarPalavra("Barco");
                conjuntoPalavrasUnicas.adicionarPalavra("Costa");
                conjuntoPalavrasUnicas.adicionarPalavra("Drenagem");

            }
            else if(option == 2){
                conjuntoPalavrasUnicas.removerPalavra("Barco");
            }
            else if(option == 3){
                conjuntoPalavrasUnicas.verificarPalavra("Costa");
            }
            else if(option == 4){
                conjuntoPalavrasUnicas.exibirPalavrasUnicas();
            }
            else if(option == 5){
                System.exit(5);
            }
        }

    }
}
