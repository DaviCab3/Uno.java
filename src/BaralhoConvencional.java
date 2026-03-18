import java.util.List;

public class BaralhoConvencional extends Baralho {

    public BaralhoConvencional(List<Carta> cartas) {
        super(cartas);
    }

    @Override
    public void montarBaralho() {
        String[] naipes = {"Copas", "Ouros", "Paus", "Espadas"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String n : naipes) {
            for (String v : valores) {
                this.cartas.add(new CartaConvencional(n, v));
            }
        }


        // Joker preto = Coringa normal | Joker vermelho = Coringa +4
        this.cartas.add(new CartaCoringa());
        this.cartas.add(new CartaD4());
    }

}