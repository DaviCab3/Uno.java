public class CartaCoringa extends Carta {

    public CartaCoringa() {
        super("preto"); // Começa preta, mas vai mudar no jogo
    }

    @Override
    public boolean podeSerJogadasobre(Carta topo) {
        return true; // Coringa aceita qualquer carta embaixo
    }

    @Override
    public void aplicarEfeito(Carta especial) {
        System.out.println("EFEITO: Coringa jogado! Escolha a nova cor.");
    }

}
