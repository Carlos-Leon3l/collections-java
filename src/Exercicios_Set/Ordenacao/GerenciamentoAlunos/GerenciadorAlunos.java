package Exercicios_Set.Ordenacao.GerenciamentoAlunos;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {

    private Set<Aluno> alunosSet;

    public GerenciadorAlunos() {
        this.alunosSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, Long matricula, double nota){
        this.alunosSet.add(new Aluno(nome, matricula, nota));
    }
    
    public void removerAlunoPorMatricula(long matricula){
        Aluno alunoremovido = null;

        for (Aluno a : alunosSet) {
            if(a.getMatricula() == matricula){
                alunoremovido = a;
                break;
            }
        }
        alunosSet.remove(alunoremovido);
    }

    public Set<Aluno> exibirAlunosPorNome(){
        Set<Aluno> alunoPorNomeOrdenado = new TreeSet<>(alunosSet);
        return alunoPorNomeOrdenado;
    }

    public Set<Aluno> exibirAlunosPorNota() {
        Set<Aluno> novoSetAlunosOrdenadoPorNota = new TreeSet<>(new AlunoPorNota());
        novoSetAlunosOrdenadoPorNota.addAll(alunosSet);
        return novoSetAlunosOrdenadoPorNota;
    }

    public void exibirAlunos() {
        System.out.println(this.alunosSet);
    }

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();
        int opcao = -1;

        while (true) {
            opcao = scanner.nextInt();
            if (opcao == 1) {
                gerenciadorAlunos.adicionarAluno("João", 123456L, 7.5);
                gerenciadorAlunos.adicionarAluno("Maria", 123457L, 9.0);
                gerenciadorAlunos.adicionarAluno("Carlos", 123458L, 5.0);
                gerenciadorAlunos.adicionarAluno("Ana", 123459L, 6.8);
            }
            else if(opcao == 2){
                System.out.println("Alunos no gerenciador:");
                System.out.println(gerenciadorAlunos.alunosSet);
            }
            else if(opcao == 3){
                gerenciadorAlunos.removerAlunoPorMatricula(000L);
                gerenciadorAlunos.removerAlunoPorMatricula(123457L);
                System.out.println(gerenciadorAlunos.alunosSet);

            }
            else if(opcao == 4){
                System.out.println(gerenciadorAlunos.exibirAlunosPorNome());
            }
            else if(opcao == 5){
                System.out.println(gerenciadorAlunos.exibirAlunosPorNota());
            }
        }
    }
}
