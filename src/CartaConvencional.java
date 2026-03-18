public class CartaConvencional extends Carta {
    private String valor; // "A", "2", "J", "Q", "K"...

    public CartaConvencional(String naipe, String valor) {
        // Mapeamento: O Naipe (Copas, Paus...) entra como a "Cor" da classe pai
        super(naipe);
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean podeSerJogadasobre(Carta topo) {
        // mesmo naipe (cor) ou mesmo valor (número/ação)
        if (topo instanceof CartaConvencional) {
            CartaConvencional outra = (CartaConvencional) topo;
            return this.getCor().equals(outra.getCor()) || this.valor.equals(outra.valor);
        }
        // Se a carta debaixo for de outro tipo, compara só o Naipe/Cor
        return this.getCor().equals(topo.getCor());
    }

    @Override
    public void aplicarEfeito(Carta especial) {
        // Efeito processado no Jogo.java
    }

    @Override
    public String toString() {
        return "[" + valor + " de " + getCor() + "]";
    }
}