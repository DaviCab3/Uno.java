public abstract class Carta {



    private String Cor;

    public Carta(String cor) {

        Cor = cor;
    }
    public void setCor(String novaCor) {
        this.Cor = novaCor;
    }
    public String getCor() {

        return Cor;
    }




    public abstract boolean podeSerJogadasobre (Carta topo);

    public abstract void  aplicarEfeito (Carta especial);
}








