public class CartaCoringa extends Carta {

    public CartaCoringa() {
        super("preto"); // Começa preta, mas vai mudar no jogo
    }
    @Override
    public String toString() {
        // Se a cor ainda for preto, mostra apenas CORINGA.
        // Se já tiver uma cor escolhida (ex: Verde), mostra [VERDE CORINGA]
        if (this.getCor().equalsIgnoreCase("preto")) {
            return "[ CORINGA ]";
        } else {
            return "[" + getCor().toUpperCase() + " CORINGA]";
        }
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
