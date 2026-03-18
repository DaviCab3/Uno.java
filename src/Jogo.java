import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {

    private Baralho baralho;
    private List<Jogador> players;
    private int indiceAtual;
    private int direcao; // 1 para horário, -1 para anti-horário
    private Scanner scanner;
    private Carta cartaTopo;

    public Jogo() {
        this.players = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.indiceAtual = 0;
        this.direcao = 1;
    }

    public void adicionarJogador(String nome) {
        if (players.size() < 10) {
            players.add(new Jogador(nome));
        } else {
            System.out.println("Limite de 10 jogadores atingido.");
        }
    }

    public void comecar() {
        if (players.size() < 2) {
            System.out.println("Erro: Adicione pelo menos 2 jogadores!");
            return;
        }

        System.out.println("Escolha o baralho: 1-Uno Oficial, 2- Convencional (52 cartas)");
        int opcao = scanner.nextInt();

        if (opcao == 1) {
            this.baralho = new BaralhoOficial(new ArrayList<>());
        } else {
            this.baralho = new BaralhoConvencional(new ArrayList<>());
        }

        baralho.montarBaralho();
        baralho.embaralhar();

        for (Jogador j : players) {
            for (int k = 0; k < 7; k++) {
                j.adicionarCarta(baralho.comprar());
            }
        }

        // Regra: Primeira carta não pode ser preta/coringa
        this.cartaTopo = baralho.comprar();
        while (this.cartaTopo instanceof CartaCoringa || this.cartaTopo instanceof CartaD4) {
            this.cartaTopo = baralho.comprar();
        }

        System.out.println("\n--- JOGO INICIADO! ---");
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

            jogadorDaVez.mostrarMao();

            System.out.println("Escolha a carta ou -1 para COMPRAR:");
            int escolha = scanner.nextInt();

            if (escolha == -1) {
                Carta comprada = baralho.comprar();
                if (comprada != null) {
                    jogadorDaVez.adicionarCarta(comprada);
                    System.out.println("Comprou: " + comprada);
                }
                avancarVez();
            } else {
                Carta escolhida = jogadorDaVez.verCarta(escolha);

                if (escolhida != null && escolhida.podeSerJogadasobre(this.cartaTopo)) {
                    this.cartaTopo = jogadorDaVez.jogarCarta(escolha);
                    System.out.println("Cartas restantes: " + jogadorDaVez.getQuantidadeCartas());

                    // --- LÓGICA DE EFEITOS UNIFICADA (POLIMORFISMO + CASTING) ---

                    // 1. EFEITO PULAR (CartaPular OU Valete 'J')
                    if (this.cartaTopo instanceof CartaPular ||
                            (this.cartaTopo instanceof CartaConvencional && ((CartaConvencional) this.cartaTopo).getValor().equals("J"))) {
                        System.out.println(">> EFEITO: Próximo jogador pulado!");
                        avancarVez();
                    }

                    // 2. EFEITO INVERTER (CartaInverte OU Dama 'Q')
                    else if (this.cartaTopo instanceof CartaInverte ||
                            (this.cartaTopo instanceof CartaConvencional && ((CartaConvencional) this.cartaTopo).getValor().equals("Q"))) {
                        System.out.println(">> EFEITO: Sentido invertido!");
                        inverterDirecao();
                    }

                    // 3. EFEITO +2 (CartaD2 OU Rei 'K')
                    else if (this.cartaTopo instanceof CartaD2 ||
                            (this.cartaTopo instanceof CartaConvencional && ((CartaConvencional) this.cartaTopo).getValor().equals("K"))) {
                        avancarVez();
                        Jogador alvo = players.get(indiceAtual);
                        alvo.adicionarCarta(baralho.comprar());
                        alvo.adicionarCarta(baralho.comprar());
                        System.out.println(">> EFEITO: " + alvo.getNome() + " comprou 2 e perdeu a vez!");
                    }

                    // 4. EFEITO CORINGAS (Funciona para ambos os baralhos)
                    if (this.cartaTopo instanceof CartaCoringa || this.cartaTopo instanceof CartaD4) {
                        System.out.println("Escolha a nova COR ou NAIPE:");
                        String novaCor = scanner.next();
                        this.cartaTopo.setCor(novaCor);

                        if (this.cartaTopo instanceof CartaD4) {
                            avancarVez();
                            Jogador alvo = players.get(indiceAtual);
                            for(int i=0; i<4; i++) alvo.adicionarCarta(baralho.comprar());
                            System.out.println(">> EFEITO: " + alvo.getNome() + " comprou 4 e perdeu a vez!");
                        }
                    }

                    // Verificação de Vitória
                    if (jogadorDaVez.temMaovazia()) {
                        System.out.println("\n*** " + jogadorDaVez.getNome() + " VENCEU O JOGO! ***");
                        jogoRolando = false;
                    } else {
                        avancarVez();
                    }
                } else {
                    System.out.println("Jogada inválida!");
                }
            }
        }
    }
}