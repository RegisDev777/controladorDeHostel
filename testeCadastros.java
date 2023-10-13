package cadastroDePessoas;

import java.util.List;
import java.util.Scanner;
import cadastroDePessoas.pesquisaHospede;



public class testeCadastros {
    public static void main(String[] args) throws ExceptionsCadastro {
        Cadastro cadastro = new Cadastro();
        pesquisaHospede pesquisaAi = new pesquisaHospede();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=================================");
            System.out.println("|         HOSTEL DA PAZ         |");
            System.out.println("=================================");
            System.out.println("| 1 - PESQUISA                  |");
            System.out.println("| 2 - RESERVAR QUARTOS          |");
            System.out.println("| 3 - QUARTOS DISPONIVEIS       |");
            System.out.println("| 4 - BAIXAS                    |");
            System.out.println("| 5 - SAIR                      |");
            System.out.println("=================================");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcao) {
                case 1:  
                	System.out.println("======================================================");
                	System.out.println("PESQUISA:");
                	  System.out.print("Digite o nome a ser pesquisado: ");
                      String nomePesquisa = scanner.nextLine();
                      pesquisaAi.pesquisarPorNome(nomePesquisa, Cadastro.getHospedesCadastrados());
                      break;
                      
                case 2:
                    try {
                        cadastro.reservaQuartos(scanner);
                    } catch (ExceptionsCadastro ex) {
                        System.out.println(ex.getMessage());
                    }
                    
                    break;

                case 3:
                	
                    System.out.println("=================================");
                    System.out.println("|       QUARTOS DISPONIVEIS     |");
                    System.out.println("=================================");
                    
                    for (Quarto quarto : cadastro.getQuartosDisponiveis()) {
                        System.out.println("Quarto " + quarto.getNumeroQuarto());
                        if (quarto.getHospede() == null) {
                            System.out.println("Status: Disponível");
                        } else {
                            System.out.println("Status: Ocupado");
                            System.out.println("Hóspede: " + quarto.getHospede().getNome());
                        }
                        System.out.println("---------------------------------");
                    }
                    
                    System.out.println("=================================");
                    System.out.println();
                    break;
                case 4:             	
                	    System.out.print("Digite o número do quarto para realizar a baixa: ");
                	    int numeroQuartoBaixa = scanner.nextInt();
                	    scanner.nextLine();  // Limpar o buffer do scanner
                	    cadastro.realizarBaixa(numeroQuartoBaixa);
                	    break;
                	    
                case 5:
                    System.out.println("Fechando....");
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        
        }
    }
}
	   
	   
	   
	   
	   
	   
	   
	   
	   
	 
