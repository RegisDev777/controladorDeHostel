package cadastroDePessoas;

public class Hospede {
	
       private String nome;
       private String rg;      
       private String email;
       private String celular;
       private int numeroQuarto;
     
       
       
      public Hospede(String nomeHospede, String rgHospede, String emailHospede, String celularHospede,int numeroQuarto) {
          this.nome = nomeHospede;
          this.rg = rgHospede;
          this.email = emailHospede;
          this.celular = celularHospede;
          this.numeroQuarto = numeroQuarto;   
	}


	/**
       * GETTERS E SETTERS DADOS
       * ONDE PSSO MODIFICAR NOMES ETC...
       */   
      public String getNome() {
		return nome;
	}
      public void setNome(String nome) {
		this.nome = nome;
	}
         
      
      public String getRg() {
		return rg;
	  }
      public void setRg(String rg) {
		this.rg = rg;
	}

      public String getCelular() {
		return celular;
	}
      
      public void setCelular(String celular) {
		this.celular = celular;
	}

      public String getEmail() {
		return email;
	  }
      public void setEmail(String email) {
		this.email = email;
	  }
      
  
      public int getNumeroQuarto() {
		return numeroQuarto;
	}
     public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
      
}
