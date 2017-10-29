package ages.hacka.fichasapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by mazzardo on 28/10/17.
 */

public class Jogo  implements Serializable {
    List<Jogador> jogadores;
    Mao mao ;
    int buyIn;
    int reBuy;
    int multiplicador;
    int valor;

    public Jogo(List<Jogador> jogadores, Mao mao, int buyIn, int reBuy, int multiplicador, int valor) {
        this.jogadores = jogadores;
        this.mao = mao;
        this.buyIn = buyIn;
        this.reBuy = reBuy;
        this.multiplicador = multiplicador;
        this.valor = valor;
    }
    public Jogo(){

    }

    public int getBuyIn() {

        return buyIn;
    }

    public void setBuyIn(int buyIn) {
        this.buyIn = buyIn;
    }

    public int getReBuy() {
        return reBuy;
    }

    public void setReBuy(int reBuy) {
        this.reBuy = reBuy;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public Mao getMao() {
        return mao;
    }

    public void setMao(Mao mao) {
        this.mao = mao;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }
}
