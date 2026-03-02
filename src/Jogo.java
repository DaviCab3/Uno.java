import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jogo {


    private Baralho baralho;
    private List<Jogador> players;
    private int indiceatual;
    private int direção;
    private Scanner scanner;
    private Carta cartaTopo;

    public Jogo() {
        this.players = new ArrayList<>();

        this.scanner = new Scanner(System.in);
        this.indiceatual = 0;
        this.direção = 1;
    }

 public void adicionarJogador (String nome){
        players.add(new Jogador (nome));
}
    public void começar() {
        // Escolhe o tipo de baralho .
        System.out.println("Escolha o baralho: 1-Uno oficial, 2- Convencional");
        int opcção = scanner.nextInt();

        if (opcção == 1) {
            this.baralho = new BaralhoOficial();

        } else
            this.baralho = new BaralhoConvencional();
                baralho.montarBaralho();

        for (Jogador J : players) {
            for (int k = 0; k < 7; k++) {
                J.adicionarCarta((baralho.comprar()));

            }
        }
        this.cartaTopo = baralho.comprar();

        System.out.println("--- Jogo Iniciado! ---");
        System.out.println("Carta na mesa: " + cartaTopo);

        loopPrincipal();
    }
    public void avancarVez() {
        indiceatual = indiceatual+ direção;
        if (indiceatual >= players.size()){
            indiceatual=0;
        else if (indiceatual < 0) {
            indiceatual = players.size()-1;
            }
        }
    }
    public void inverterDirecao() {
        this.direção *= -1;
    }

    public Carta getCartaTopo() {
        return this.cartaTopo;
    }


    public void loopPrincipal(){
        boolean jogoRolando = true;

        while (jogoRolando){
            Jogador jogadorDaVez = players.get(indiceatual){
                System.out.println("\n==================================");
                System.out.println("CARTA NA MESA: " + cartaTopo);
                System.out.println("Vez de: " + jogadorDaVez.getNome());
            }
        }
    }

}






