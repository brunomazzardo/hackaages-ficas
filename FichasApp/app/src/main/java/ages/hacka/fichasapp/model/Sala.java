package ages.hacka.fichasapp.model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by mazzardo on 28/10/17.
 */

public class Sala  implements Serializable {
    String id ;

    ArrayList<Jogo> jogos;

    public Sala(String id, ArrayList<Jogo> jogos) {
        this.id = id;
        this.jogos = jogos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(ArrayList<Jogo> jogos) {
        this.jogos = jogos;
    }

}



