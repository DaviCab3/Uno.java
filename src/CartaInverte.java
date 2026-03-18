public class CartaInverte extends Carta {

    public CartaInverte(String cor) {
        super(cor);
    }

    @Override
    public boolean podeSerJogadasobre(Carta topo) {
        return this.getCor().equals(topo.getCor()) || topo instanceof CartaInverte;
    }

    @Override
    public void aplicarEfeito(Carta especial) {
        System.out.println("EFEITO: O sentido do jogo foi invertido!");
    }

}
