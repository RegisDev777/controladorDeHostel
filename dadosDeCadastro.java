package cadastroDePessoas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class dadosDeCadastro extends Hospede {

    private List<Hospede> hospedesCadastrados = new ArrayList<>();
   

    public dadosDeCadastro(String nome, String cpf, String rg, String email, String celular) throws ExceptionsCadastro {
        super(nome, cpf, rg, email, 0);
    }

    public boolean contemNumero(String texto) {
        for (char caractere : texto.toCharArray()) {
            if (Character.isDigit(caractere)) {
                return true;
            }
        }
        return false;
    }

    public String NomeDoHospede(Scanner scanner) throws ExceptionsCadastro {
    	System.out.println("=================================");
    	System.out.println("REGISTRA HOSPEDE:");
    	
        String nome = "";
        do {
            System.out.print("NOME:");
            nome = scanner.nextLine().trim();

            if (nome.isEmpty() && contemNumero(nome)) {
                throw new ExceptionsCadastro("ERRO!! NOME - Por favor insira o nome corretamente!");
            }
            if (nome.isEmpty()) {
                throw new ExceptionsCadastro("ERRO!! NOME - Não pode estar vazio");
            }
            if (contemNumero(nome)) {
                throw new ExceptionsCadastro("ERRO!! NOME - Não pode ter números");
            }
            if (nome.length() <= 7) {
                throw new ExceptionsCadastro("ERRO!! NOME - Por favor, digite nome completo");
            }

        } while (nome.isEmpty() && contemNumero(nome) || nome.isEmpty() || contemNumero(nome));

        return nome;
    }

    public String RgDoHospede(Scanner scanner) throws ExceptionsCadastro {
        String rg = "";
        do {
            System.out.print("RG:");
            rg = scanner.nextLine().trim();
            if (rg.length() != 13) {
                throw new ExceptionsCadastro("ERRO!! RG - deve conter 13 dígitos");
            }

        } while (rg.isEmpty());

        return rg;
    }

    public String emailDoHospede(Scanner scanner) throws ExceptionsCadastro {
        String email = "";
        boolean validEmail = false;

        do {
            System.out.print("EMAIL:");
            email = scanner.nextLine().trim();

            if (email.isEmpty()) {
                System.out.println("ERRO!! EMAIL - Não pode estar vazio");
                continue;
            }

            if (!email.contains("@") || !email.endsWith("@gmail.com")) {
                System.out.println("ERRO!! EMAIL - Por favor, adicione um e-mail válido (deve ser @gmail.com)");
                continue;
            }

            validEmail = true;

        } while (!validEmail);

        return email;
    }

    public String celular(Scanner scanner) throws ExceptionsCadastro {
        String celular = "";
        boolean validCelular = false;
        do {
            System.out.print("CELULAR:");
            celular = scanner.nextLine().trim();
            try {
                if (celular.length() == 11) {
                    validCelular = true;
                } else {
                    throw new ExceptionsCadastro("ERRO!! CELULAR - celular tem que ter 11 dígitos com dd (xx) - x - xxxxx-xxxx");
                }
            } catch (ExceptionsCadastro ex) {
                System.out.println(ex.getMessage());
            }
        } while (!validCelular);

        return celular;
    }
    
 
    
    public int Acompanhante(Scanner scanner) throws ExceptionsCadastro {
        int quantidadeDeAcompanhante = 0;

        do {
            System.out.print("QUANTIDADE DE ACOMPANHANTES: ");
             
            try {
                quantidadeDeAcompanhante = scanner.nextInt();

                if (quantidadeDeAcompanhante > 4) {
                    throw new ExceptionsCadastro("ERRO!! ACOMPANHANTE - no máximo 4 acompanhantes");
                }

            } catch (InputMismatchException ex) {
                System.out.println("ERRO!! ACOMPANHANTE - resposta deve ser um número inteiro");
                scanner.next();  // Limpa o buffer do scanner
            }

        } while (quantidadeDeAcompanhante > 4);
        System.out.println("=================================");
        return quantidadeDeAcompanhante;
    }

  
    
  

}