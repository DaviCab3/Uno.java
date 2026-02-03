public class CartaPular extends CartaEspecial{

    public CartaPular(String cor) {
        super(cor);
    }

    @Override
    public void aplicarEfeito(Carta Especial) {
        System.out.println("O jogador perde a vez");


    }
}
