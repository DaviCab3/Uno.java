import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {

    private Baralho baralho;
    private List<Jogador> players;
    private int indiceAtual;
    private int direcao;
    private Scanner scanner;
    private Carta cartaTopo;

    public Jogo() {
        this.players = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.indiceAtual = 0;
        this.direcao = 1;
    }

    public void adicionarJogador(String nome) {
        players.add(new Jogador(nome));
    }

    public void comecar() {
        if (players.size() < 2) {
            System.out.println("Adicione pelo menos 2 jogadores!");
            return;
        }

        System.out.println("Escolha o baralho: 1-Uno oficial, 2- Convencional");
        int opcao = scanner.nextInt();

        // Polimorfismo: Baralho aceita qualquer subclasse
        if (opcao == 1) {

            this.baralho = new BaralhoOficial(new ArrayList<>());
        } else {
            this.baralho = new BaralhoConvencional(new ArrayList<>());
        }

        baralho.montarBaralho();
        baralho.embaralhar();

        // Distribui as cartas usando  método adicionarCarta
        for (Jogador j : players) {
            for (int k = 0; k < 7; k++) {
                j.adicionarCarta(baralho.comprar());
            }
        }

        this.cartaTopo = baralho.comprar();

        System.out.println("\n--- Jogo Iniciado! ---");
        loopPrincipal();
    }

    public void avancarVez() {
        indiceAtual = (indiceAtual + direcao + players.size()) % players.size();
    }

    public void inverterDirecao() {
        this.direcao *= -1;
    }

    public void loopPrincipal() {
        boolean jogoRolando = true;

        while (jogoRolando) {
            Jogador jogadorDaVez = players.get(indiceAtual);
            System.out.println("\n==================================");
            System.out.println("CARTA NA MESA: " + cartaTopo);
            System.out.println("VEZ DE: " + jogadorDaVez.getNome());

            // Usando  método mostrarMao()
            jogadorDaVez.mostrarMao();

            System.out.println("Escolha o NÚMERO da carta para jogar ou -1 para COMPRAR:");
            int escolha = scanner.nextInt();

            if (escolha == -1) {
                Carta comprada = baralho.comprar();
                if (comprada != null) {
                    jogadorDaVez.adicionarCarta(comprada);
                    System.out.println("Você comprou: " + comprada);
                }
                avancarVez();
            } else {
                // Usando  método verCarta() para validar antes de remover
                Carta escolhida = jogadorDaVez.verCarta(escolha);

                if (escolhida != null && escolhida.podeSerJogadasobre(this.cartaTopo)) {
                    // Se for válida,  o jogarCarta() que remove da mão
                    this.cartaTopo = jogadorDaVez.jogarCarta(escolha);

                    // Aplicar efeito (Polimorfismo)
                    if (this.cartaTopo instanceof CartaPular) {
                        avancarVez(); // Pula o próximo!
                        System.out.println("O próximo jogador foi pulado!");
                    } else if (this.cartaTopo instanceof CartaInverte) {
                        inverterDirecao();
                    } else if (this.cartaTopo instanceof CartaD2) {
                        avancarVez();
                        Jogador proximo = players.get(indiceAtual);
                        proximo.adicionarCarta(baralho.comprar());
                        proximo.adicionarCarta(baralho.comprar());
                        System.out.println(">> EFEITO: " + proximo.getNome() + " comprou 2 e perdeu a vez!");
                        if (jogadorDaVez.temMaovazia()) {
                        System.out.println("\n" + jogadorDaVez.getNome() + " VENCEU O JOGO!");
                        jogoRolando = false;
                    } else {
                        avancarVez();
                    }
                } else {
                    System.out.println("Jogada inválida! Tente outra carta ou compre.");
                }
            }
        }
    }
}




