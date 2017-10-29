package ages.hacka.fichasapp.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created by mazzardo on 28/10/17.
 */




public class Aposta implements Serializable {
    List<Ficha> fichas;


    public Aposta(){

    }
    public List<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(List<Ficha> fichas) {
        this.fichas = fichas;
    }

    public Aposta(List<Ficha> fichas) {

        this.fichas = fichas;
    }
}
