import java.util.Collections;
import java.util.List;

public abstract class Baralho {

    protected List< Carta> cartas;

    public Baralho(List<Carta> cartas) {
        this.cartas = cartas;
        montarBaralho();
    }


    public abstract void montarBaralho();

    public void embaralhar(){
        Collections.shuffle(this.cartas);

    }

    public Carta comprar(){
        if( this.cartas.isEmpty()){
            return null;
        }
        return this.cartas.remove(0);

    }
    public int tamanho() {
        return this.cartas.size();
    }

    public boolean estaVazio() {
        return this.cartas.isEmpty();
    }
}



