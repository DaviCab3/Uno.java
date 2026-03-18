import java.util.ArrayList;
import java.util.List;

public class Jogador {

    private List<Carta> mao;
    private String nome;

    public Jogador(String nome) {
        this.mao = new ArrayList<>();
        this.nome = nome;

    }


public String getNome(){
    return nome;
}

public int getQuantidadeCartas(){
    return mao.size();
}

public boolean temMaovazia(){
        return mao.isEmpty();
}

public void adicionarCarta(Carta carta) {
    mao.add(carta);
   }


public Carta verCarta (int indice) {
    if (indice >= 0 && indice < mao.size()) {
        return mao.get(indice);
    }
    return null;
}

public Carta jogarCarta (int indice) {
    if (indice >= 0 && indice < mao.size()) {
        return mao.remove(indice);
    }
    return null;
}

    public void mostrarMao() {
        System.out.println("\n--- Cartas de " + nome + " ---");
        for (int i = 0; i < mao.size(); i++) {

            System.out.println("[" + i + "] " + mao.get(i));
        }
    }
}





