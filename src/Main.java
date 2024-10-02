import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double saldoInicial = 0.00;

    //==================================================================================\\
        System.out.println("***********************************");
        System.out.println("Bem-vindo ao Johny Bank!\nDigite seu nome ou apelido:");
        String nomeCliente = scanner.nextLine();
        String msgBoasVindas = """
                \nÉ um prazer te ter conosco, %s!\n
                Por favor, escolha o tipo de sua conta:
                1 - Conta Poupança
                2 - Conta Corrente
                3 - Conta Salário\n
                """.formatted(nomeCliente);

        System.out.println(msgBoasVindas);

        String tipoDeConta = "Não definida.";
        Boolean escolhaValida = false;

        do {
            int escolhaDeConta = scanner.nextInt();
            switch (escolhaDeConta) {
                case 1:
                    tipoDeConta = "Conta Poupança";
                    escolhaValida = true;
                    break;
                case 2:
                    tipoDeConta = "Conta Corrente";
                    escolhaValida = true;
                    break;
                case 3:
                    tipoDeConta = "Conta Salário";
                    escolhaValida = true;
                    break;
                default:
                    System.out.println("Digite uma escolha válida.");
                    escolhaValida = false;
                    break;
            }
        }  while (!escolhaValida);

        System.out.println("Tudo pronto por aqui!");

        String msgDaHomePage = """
                ***********************************
                Bem-vindo, %s!
                Tipo de conta: %s
                Saldo: %.2f
                ***********************************
                
                Operações:
                
                1 - Consultar Saldo
                2 - Depósito
                3 - Transferência
                4 - Sair
                """.formatted(nomeCliente, tipoDeConta, saldoInicial);
        System.out.println(msgDaHomePage);
        int tipoDeOperacao = scanner.nextInt();

        do {
            switch (tipoDeOperacao) {
                case 1:
                    System.out.println("Seu saldo atual é de: " + saldoInicial);
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Quanto deseja depositar?");
                    int valorDepositado = scanner.nextInt();
                    saldoInicial += valorDepositado;
                    break;
                case 3:
                    System.out.println("Quanto deseja transferir?");
                    int valorTransferido = scanner.nextInt();
                    saldoInicial -= valorTransferido;
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Escolha inválida!");
                    break;
            }
            System.out.println(msgDaHomePage);
            tipoDeOperacao = scanner.nextInt();
        } while (tipoDeOperacao != 4);
    }
}