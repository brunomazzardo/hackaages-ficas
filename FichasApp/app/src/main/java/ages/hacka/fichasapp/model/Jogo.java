package ages.hacka.fichasapp.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mazzardo on 28/10/17.
 */

public class Jogo  implements Serializable {
    ArrayList<Jogador> jogadores;
    Mao mao ;
    int buyIn;
    int reBuy;
    int multiplicador;
    int valor;

    public Jogo(ArrayList<Jogador> jogadores, Mao mao, int multiplicador) {
        this.jogadores = jogadores;
        this.mao = mao;
        this.multiplicador = multiplicador;
    }

    public Jogo(ArrayList<Jogador> jogadores, Mao mao, int buyIn, int reBuy, int multiplicador, int valor) {
        this.jogadores = jogadores;
        this.mao = mao;
        this.buyIn = buyIn;
        this.reBuy = reBuy;
        this.multiplicador = multiplicador;
        this.valor = valor;
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

    public ArrayList<Jogador> getJogadores() {

        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
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
