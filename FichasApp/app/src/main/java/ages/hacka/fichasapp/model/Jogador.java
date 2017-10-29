package ages.hacka.fichasapp.model;

import java.io.Serializable;

/**
 * Created by mazzardo on 28/10/17.
 */

public class Jogador implements Serializable {

    int pot;
    String id;
Aposta aposta;




    Boolean admin;

    public Jogador(int pot, String id, Aposta aposta, Boolean admin) {
        this.pot = pot;
        this.id = id;
        this.aposta = aposta;
        this.admin = admin;
    }

    public Aposta getAposta() {
        return aposta;
    }

    public void setAposta(Aposta aposta) {
        this.aposta = aposta;
    }

    public int getPot() {

        return pot;
    }

    public void setPot(int pot) {
        this.pot = pot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
