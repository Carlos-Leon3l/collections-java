package Exercicios_Set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> convidadoSet;
    private static Scanner scanner = new Scanner(System.in);

    public ConjuntoConvidados() {
        this.convidadoSet = new HashSet<>();
    }
    public void adicionarConvidado(String nome, int codigoConvite){
        convidadoSet.add(new Convidado(nome, codigoConvite));

    }
    public void removerconvidado(int codigoConvite){
        Convidado convidadoParaRemover = null;

        for(Convidado i : convidadoSet){
            if(i.getCodigoConvite() == codigoConvite){
                convidadoParaRemover = i;
                break;
            }
        }
        convidadoSet.remove(convidadoParaRemover);

    }
    public int qtdConvidados(){
        return convidadoSet.size();
    }
    public void exibirConvidados(){
        System.out.println(convidadoSet);
    }

    public static void main(String[] args) {
    
        System.out.println("Palavras únicas");

        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();
        int option = -1;
        while (true) {
            System.out.println("1- Adicionar palavras ");
            System.out.println("2- Remover palavra ");
            System.out.println("3- Verificar quantidade de convidados ");
            System.out.println("4- Exibir convidados ");
            System.out.println("5- Sair");

            option = scanner.nextInt();

            if(option == 1){
                conjuntoConvidados.adicionarConvidado("Carlos", 123);
                conjuntoConvidados.adicionarConvidado("Mario", 234);
                conjuntoConvidados.adicionarConvidado("Joao", 456);
                conjuntoConvidados.adicionarConvidado("Tina", 789);
            }
            if(option == 2){
                conjuntoConvidados.removerconvidado(123);
            }
            if(option == 3){
                conjuntoConvidados.qtdConvidados();
            }
            if(option == 4){
                conjuntoConvidados.exibirConvidados();
            }
            if(option == 5){
                System.exit(5);
            }
        }
    }
}
