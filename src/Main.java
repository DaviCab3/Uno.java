
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Jogo meuJogo = new Jogo();

        System.out.println("************************************");
        System.out.println("* BEM-VINDO AO SUPER UNO      *");
        System.out.println("************************************");

        // 1. Configuração dos Jogadores
        int qtdJogadores = 0;
        while (qtdJogadores < 2) {
            System.out.println("\nQuantos jogadores participarão? (Mínimo 2, Máximo 10):");
            qtdJogadores = leitor.nextInt();

            if (qtdJogadores < 2 || qtdJogadores > 10) {
                System.out.println("Número inválido! O UNO precisa de 2 a 10 pessoas.");
                qtdJogadores = 0; // Reseta para continuar no loop
            }
        }

        // Limpar o buffer do scanner
        leitor.nextLine();

        // 2. Cadastro de Nomes
        for (int i = 1; i <= qtdJogadores; i++) {
            System.out.print("Digite o nome do Jogador " + i + ": ");
            String nome = leitor.nextLine();
            meuJogo.adicionarJogador(nome);
        }

        System.out.println("\n--- TUDO PRONTO! ---");
        System.out.println("Preparando o baralho e distribuindo as cartas...");

        // 3. Início do Jogo

        meuJogo.comecar();

        leitor.close();
    }
}
