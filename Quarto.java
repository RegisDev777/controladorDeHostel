package cadastroDePessoas;

public class Quarto {
    private int numeroQuarto;
    private Hospede hospede;  // Hospede associado a este quarto
    private int quantidadeAcompanhantes;
    
    public Quarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }
    
    
    public void adicionarHospede(Hospede hospede, int quantidadeAcompanhantes) {
        this.hospede = hospede;
        this.hospede.setNumeroQuarto(this.numeroQuarto);  // Definindo o número do quarto no hospede
        this.quantidadeAcompanhantes = quantidadeAcompanhantes;
    }
    

    public void removerHospede() {
        this.hospede = null;
        this.quantidadeAcompanhantes = 0;
    }
    
    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }
    
    public int getQuantidadeAcompanhantes() {
		return quantidadeAcompanhantes;
	}
    public void setQuantidadeAcompanhantes(int quantidadeAcompanhantes) {
		this.quantidadeAcompanhantes = quantidadeAcompanhantes;
	}

    @Override
    public String toString() {
        return "Quarto{" +
                "numeroQuarto=" + numeroQuarto +
                ", hospede=" + hospede +
                '}';
    }
}
