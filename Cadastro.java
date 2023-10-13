package cadastroDePessoas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastro {
    private static List<Hospede> hospedesCadastrados = new ArrayList<>();
    private List<Quarto> quartosDisponiveis = new ArrayList<>();
    
    
    public Cadastro() {
        // Inicializa os quartos disponíveis
        for (int i = 1; i <= 10; i++) {
            quartosDisponiveis.add(new Quarto(i));
        }
    }
    
    public List<Quarto> getQuartosDisponiveis() {
        return quartosDisponiveis;
    }
    
    public static List<Hospede> getHospedesCadastrados() {
        return hospedesCadastrados;
    }
   
    public void realizarBaixa(int numeroQuarto) {
        for (Quarto quarto : quartosDisponiveis) {
            if (quarto.getNumeroQuarto() == numeroQuarto && quarto.getHospede() != null) {
                quarto.removerHospede();
                System.out.println("Baixa realizada para o hóspede no quarto " + quarto.getNumeroQuarto() + ".");
                return;
            }
        }
        System.out.println();
    }

    public void reservaQuartos(Scanner scanner) throws ExceptionsCadastro {
        // Obtem informações do hóspede
        dadosDeCadastro dados = new dadosDeCadastro(null, null, null, null, null);
        String nomeHospede = dados.NomeDoHospede(scanner);
        String rgHospede = dados.RgDoHospede(scanner);
        String emailHospede = dados.emailDoHospede(scanner);
        String celularHospede = dados.celular(scanner);
        int quantidadeAcompanhantes = dados.Acompanhante(scanner);

        // Escolhe um quarto disponível
        Quarto quartoSelecionado = escolherQuarto();
        if (quartoSelecionado != null) {
            Hospede hospede = new Hospede(nomeHospede, rgHospede, emailHospede, celularHospede, quantidadeAcompanhantes);
            quartoSelecionado.adicionarHospede(hospede, quantidadeAcompanhantes);
            hospedesCadastrados.add(hospede);
            System.out.println();

            System.out.println();
            System.out.println("==========================================");
            System.out.println("|NOTA!" + "                                   |");
            System.out.println("|Reserva realizada com sucesso para:"  + "     |");
            System.out.println("|nomes:" + nomeHospede + "                   |");
            System.out.println("|rg:" + rgHospede + "                        |");
            System.out.println("|email:" + emailHospede  + "                   |");
            System.out.println("|celular:" + celularHospede + "                     |");
            System.out.println("|quarto:" + quartoSelecionado.getNumeroQuarto() + "                                |");
            System.out.println("==========================================");
            System.out.println();
            
        } else {
            System.out.println("Desculpe, não há quartos disponíveis.");
        }
    }

     
    
    private Quarto escolherQuarto() {
        for (Quarto quarto : quartosDisponiveis) {
            if (quarto.getHospede() == null) {
                return quarto;
            }
        }
        return null;
    }
    
}
