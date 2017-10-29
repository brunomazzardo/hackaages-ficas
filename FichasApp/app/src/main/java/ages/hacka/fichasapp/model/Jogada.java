package ages.hacka.fichasapp.model;

import java.io.Serializable;

/**
 * Created by mazzardo on 28/10/17.
 */

public class Jogada  implements Serializable {

    private String id;
    private   Aposta aposta;
    private String nomeJogador;

    private  Boolean out;

    public Jogada(String id, Aposta aposta, String nomeJogador, Boolean out) {
        this.id = id;
        this.aposta = aposta;
        this.nomeJogador = nomeJogador;
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

    @Override
    public String toString() {
        return "O jogador "+ nomeJogador +" apostou " + calculaFicha() + " fichas";
    }

    private int calculaFicha() {
        int valor=0;
        for (Ficha f: aposta.getFichas())
            valor+= (f.getValor()* f.getQuantidade());

        return valor;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }
}
