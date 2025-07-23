package Exercicios_Map.Ordenacao.AgendaDeEventos;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AgendaEventos {
    
    private Map<LocalDate, Evento> eventoMap;

    public AgendaEventos() {
        this.eventoMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao){
        Evento evento = new Evento(nome, atracao);
        eventoMap.put(data, evento);
    }

    public void exibirAgendaDeEventos(){
        Map<LocalDate, Evento> eventroTreeMap = new TreeMap<>(eventoMap);
        
        System.out.println(eventroTreeMap);
    }

    public void obterProximoEvento(){
        LocalDate dataAtual = LocalDate.now();
        eventoMap.get(dataAtual);
        for(Map.Entry<LocalDate, Evento> entry : eventoMap.entrySet()){
            
            if(entry.getKey() == dataAtual || entry.getKey().isAfter(dataAtual)){
                System.out.println("O proximo evento " + entry.getValue() + " Acontecera na data: " + entry.getKey());
                break;
            }
        }
    }

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        AgendaEventos agendaEventos = new AgendaEventos();

        while (true) {
            System.out.println("1: Adicionar novo evento");
            System.out.println("2: Exibir agenda completa");
            System.out.println("3: Exibir próximo evento");
            System.out.println("4: Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            if (opcao == 1) {
                // Adiciona os eventos iniciais
                agendaEventos.adicionarEvento(LocalDate.of(2022, Month.JULY, 15), "Conferência de Tecnologia", "Palestrante renomado");
                agendaEventos.adicionarEvento(LocalDate.of(2022, 7, 9), "Workshop de Programação", "Aula prática de desenvolvimento");
                agendaEventos.adicionarEvento(LocalDate.of(2000, 1, 10), "Lançamento de Software", "Demonstração da nova versão");
                // Adicionando um evento futuro para testar o 'obterProximoEvento'
                agendaEventos.adicionarEvento(LocalDate.of(2025, Month.SEPTEMBER, 20), "Seminário de IA", "Discussão sobre IA avançada");
            } else if (opcao == 2) {
                agendaEventos.exibirAgendaDeEventos();
            } else if (opcao == 3) {
                agendaEventos.obterProximoEvento();
            } else if (opcao == 4) {
                System.out.println("Encerrando...");
                break;
            } else {
                System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
