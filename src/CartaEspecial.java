public abstract class CartaEspecial extends Carta {


    public CartaEspecial(String cor) {
        super(cor);

    }

    @Override
    public boolean podeSerJogadasobre(Carta topo) {    // pode ser jogada se : mesma cor ou mesma função. No caso as funçoes estao sendo comparadas pela classe.
        return this.getCor().equals(topo.getCor())
                || this.getClass().equals(topo.getClass());
    }
}


