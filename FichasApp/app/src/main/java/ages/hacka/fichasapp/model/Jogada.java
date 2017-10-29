package ages.hacka.fichasapp.model;

import java.io.Serializable;

/**
 * Created by mazzardo on 28/10/17.
 */

public class Jogada  implements Serializable {

    private String id;
    private   Aposta aposta;

    private  Boolean out;

    public Jogada(String id, Aposta aposta, Boolean out) {
        this.id = id;
        this.aposta = aposta;
        this.out = out;
    }

    public Jogada(){

    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Aposta getAposta() {
        return aposta;
    }

    public void setAposta(Aposta aposta) {
        this.aposta = aposta;
    }

    public Boolean getOut() {
        return out;
    }

    public void setOut(Boolean out) {
        this.out = out;
    }





}
