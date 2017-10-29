package ages.hacka.fichasapp.model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by mazzardo on 28/10/17.
 */

public class Sala  implements Serializable {
    String id ;

    List<Jogo> jogos;

    public Sala(List<Jogo> jogos,String id){
        this.id = id;
        this.jogos = jogos;
    }
    public Sala(String id, List<Jogo> jogos) {
        this.id = id;
        this.jogos = jogos;
    }

    public Sala(){

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public List<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(List<Jogo> jogos) {
        this.jogos = jogos;
    }
}



