import java.util.Scanner;

class CartaoDeCredito {
    private int numero;
    private String nomeTitular;
    private String cpf;
    private double limite;
    private double saldo;

    // Construtor
    public CartaoDeCredito(int numero, String nomeTitular, String cpf, double limite) {
        this.setNumero(numero);
        this.setNomeTitular(nomeTitular);
        this.setCpf(cpf);
        this.setLimite(limite);
        this.setSaldo(0); 
    }

    // Getters e Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public double consultarLimite() {
        return getLimite();
    }

    public double consultarTotalFatura() {
        return getSaldo();
    }

    public double consultarSaldo() {
        return getSaldo();
    }

    
    public void realizarCompra(double valor) {
        if (valor <= getLimite()) {
            setLimite(getLimite() - valor);
            setSaldo(getSaldo() + valor);
            System.out.println("Compra de R$" + valor + " realizada com sucesso.");
        } else {
            System.out.println("Compra negada! Limite insuficiente.");
        }
    }

    
    public void alterarLimite(double novoLimite) {
        setLimite(novoLimite);
        System.out.println("Limite alterado para: R$" + novoLimite);
    }
}

public class Principal {
    private static CartaoDeCredito cartao;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        cartao = cadastrarCartao(scanner);

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Realizar Compra");
            System.out.println("2. Consultar Limite");
            System.out.println("3. Consultar Total da Fatura");
            System.out.println("4. Consultar Saldo");
            System.out.println("5. Alterar Limite");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor da compra: ");
                    double valor = scanner.nextDouble();
                    cartao.realizarCompra(valor);
                    break;
                case 2:
                    System.out.println("Limite disponível: R$" + cartao.consultarLimite());
                    break;
                case 3:
                    System.out.println("Total da fatura: R$" + cartao.consultarTotalFatura());
                    break;
                case 4:
                    System.out.println("Saldo: R$" + cartao.consultarSaldo());
                    break;
                case 5:
                    System.out.print("Digite o novo limite do cartão: ");
                    double novoLimite = scanner.nextDouble();
                    cartao.alterarLimite(novoLimite);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static CartaoDeCredito cadastrarCartao(Scanner scanner) {
        System.out.print("Digite o número do cartão: ");
        int numero = scanner.nextInt();
        System.out.print("Digite o nome do titular: ");
        scanner.nextLine(); 
        String nomeTitular = scanner.nextLine();
        System.out.print("Digite o CPF do titular: ");
        String cpf = scanner.next();
        System.out.print("Digite o limite do cartão: ");
        double limite = scanner.nextDouble();

        return new CartaoDeCredito(numero, nomeTitular, cpf, limite);
    }
}
