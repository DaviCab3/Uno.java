public class CartaD4 extends Carta {

    public CartaD4() {
        super("preto");
    }

    @Override
    public boolean podeSerJogadasobre(Carta topo) {
        return true; // O +4 também pode ser jogado sobre qualquer uma
    }

    @Override
    public void aplicarEfeito(Carta especial) {
        System.out.println("EFEITO: +4 jogado! Próximo compra 4 e você escolhe a cor.");
    }


}