public class CartaPular extends Carta {

    public CartaPular(String cor) {
        super(cor);
    }

    @Override
    public boolean podeSerJogadasobre(Carta topo) {
        // Pode jogar se for a mesma cor OU se o topo for outra carta de Pular
        return this.getCor().equals(topo.getCor()) || topo instanceof CartaPular;
    }

    @Override
    public void aplicarEfeito(Carta especial) {
        System.out.println("EFEITO: O próximo jogador foi pulado!");
    }

}