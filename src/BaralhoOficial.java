public class BaralhoOficial extends Baralho {

    @Override
    public void montarBaralho() {
        String[] cores = {"azul", "amarelo", "verde", "vermelho" };
        for (String cor : cores) {
            this.cartas.add(new CartaNumero(cor, 0));


            for (int i = 1; i <= 9; i++) {
                this.cartas.add(new CartaNumero(cor, i));    // add 2 cartas de cada numero e cor
                this.cartas.add(new CartaNumero(cor, i));

            }

            this.cartas.add(new CartaPular(cor));
            this.cartas.add(new CartaPular(cor));

            this.cartas.add(new CartaInverte(cor));
            this.cartas.add(new CartaInverte(cor))

            this.cartas.add(new CartaD2(cor));
            this.cartas.add(new CartaD2(cor));

        }

        for (int j = 1; j <= 4; j++) {
            this.cartas.add(new CartaD4);
            this.cartas.add(new CartaCoringa);
        }


    }
}