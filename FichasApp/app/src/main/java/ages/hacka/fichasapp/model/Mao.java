package ages.hacka.fichasapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mazzardo on 28/10/17.
 */

public class Mao implements Serializable {

    String vencedor;
    int mainPot;
    int sidePot;

    public Mao(){

    }
    public Mao(String vencedor, int mainPot, int sidePot, List<Jogada> jogadas) {
        this.vencedor = vencedor;
        this.mainPot = mainPot;
        this.sidePot = sidePot;
        this.jogadas = jogadas;
    }

    public String getVencedor() {

        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    public int getMainPot() {
        return mainPot;
    }

    public void setMainPot(int mainPot) {
        this.mainPot = mainPot;
    }

    public int getSidePot() {
        return sidePot;
    }

    public void setSidePot(int sidePot) {
        this.sidePot = sidePot;
    }

    public List<Jogada> getJogadas() {
        return jogadas;
    }

    public void setJogadas(List<Jogada> jogadas) {
        this.jogadas = jogadas;
    }

    List<Jogada> jogadas;
}
