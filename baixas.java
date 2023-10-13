package cadastroDePessoas;

public class baixas {
	
	public static void realizarBaixa(Quarto quarto) {
        if (quarto.getHospede() != null) {
            System.out.println("Baixa realizada para o hóspede no quarto " + quarto.getNumeroQuarto() + ".");
            quarto.removerHospede();
        } else {
            System.out.println("Quarto " + quarto.getNumeroQuarto() + " não está ocupado.");
        }
    }
}
