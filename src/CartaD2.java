
    public class CartaD2 extends Carta {

        public CartaD2(String cor) {
            super(cor);
        }

        @Override
        public boolean podeSerJogadasobre(Carta topo) {
            return this.getCor().equals(topo.getCor()) || topo instanceof CartaD2;
        }

        @Override
        public void aplicarEfeito(Carta especial) {
            System.out.println("EFEITO: O próximo jogador deve comprar 2 cartas!");
        }


    }

