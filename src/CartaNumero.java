public  class CartaNumero  extends Carta{
    private int numero;

    public int getNumero() {
        return numero;
    }

    public CartaNumero(String cor, int numero) {
        super(cor);
        this.numero = numero;
    }
    @Override
    public String toString() {
        // Retorna algo como "[azul 7]"
        return "[" + getCor() + " " + numero + "]";
    }


    @Override
    public boolean podeSerJogadasobre(Carta topo) {
        if ( topo instanceof CartaNumero) {
            CartaNumero outra = (CartaNumero) topo;   // converte topo para carta numero
            return this.getCor().equals(outra.getCor())
                    ||
                    this.numero == outra.numero;
        }
            return this.getCor().equals(topo.getCor());  // caso a cor seja igual mas n seja do tipo numero
    }

    @Override
    public void aplicarEfeito(Carta especial) {

    }
}

