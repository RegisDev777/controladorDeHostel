package cadastroDePessoas;

import java.util.List;

public class pesquisaHospede {
	

	public void pesquisarPorNome(String nome, List<Hospede> hospedes) {
	    System.out.println("Nomes encontrados que correspondem a pesquisa:");
	    boolean encontrado = false;

	    for (Hospede hospede : hospedes) {
	        if (hospede.getNome().toLowerCase().contains(nome.toLowerCase())) {
	            System.out.print("Nome: " + hospede.getNome());
	            if (hospede.getNumeroQuarto() > 0) {
	                System.out.println(" Numero do quarto: " + hospede.getNumeroQuarto());
	            } else {
	                System.out.println("O hóspede não está associado a um quarto.");
	            }
	            encontrado = true;
	        }
	    }
	    if (!encontrado) {
	        System.out.println("Nenhum hospede encontrado com o nome que contem: " + nome);
	    }
	    System.out.println("======================================================");
	    System.out.println();
	}

}