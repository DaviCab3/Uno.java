public class Jogo {

    private String tipo;
    private Baralho baralho;
    private Jogador jogadores;


    public Jogo(String tipo) {
        this.tipo = tipo;
        this.baralho = baralho;
        this.jogadores = jogadores;
    }

    public String getTipo() {
        return tipo;
    }

    public String getBaralho() {
        return baralho;
    }

    public String getJogadores() {
        return jogadores;
    }

    public void começar () {
        Baralho oficial =  new BaralhoOficial();
        oficial.embaralhar();

        } ;
    }


}







