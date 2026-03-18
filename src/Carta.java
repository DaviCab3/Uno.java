public abstract class Carta {



    private String Cor;

    public Carta(String cor) {

        Cor = cor;
    }

    public String getCor() {

        return Cor;
    }




    public abstract boolean podeSerJogadasobre (Carta topo);

    public abstract void  aplicarEfeito (Carta especial);
}








