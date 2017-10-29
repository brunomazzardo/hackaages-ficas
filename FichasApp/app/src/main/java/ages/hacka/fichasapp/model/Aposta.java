package ages.hacka.fichasapp.model;

import java.io.Serializable;

/**
 * Created by mazzardo on 28/10/17.
 */




public class Aposta implements Serializable {
    Fichas dez ;
    Fichas vinte ;
    Fichas cinquenta;
    Fichas cem ;


    public Aposta(Fichas dez, Fichas vinte, Fichas cinquenta, Fichas cem) {
        this.dez = dez;
        this.vinte = vinte;
        this.cinquenta = cinquenta;
        this.cem = cem;
    }

    public Aposta() {
    }

    public Fichas getDez() {
        return dez;
    }

    public void setDez(Fichas dez) {
        this.dez = dez;
    }

    public Fichas getVinte() {
        return vinte;
    }

    public void setVinte(Fichas vinte) {
        this.vinte = vinte;
    }

    public Fichas getCinquenta() {
        return cinquenta;
    }

    public void setCinquenta(Fichas cinquenta) {
        this.cinquenta = cinquenta;
    }

    public Fichas getCem() {
        return cem;
    }

    public void setCem(Fichas cem) {
        this.cem = cem;
    }

    public int valorAposta(){
        return dez.getQuantidade()*dez.getValor() + vinte.getValor()*vinte.getQuantidade() + cinquenta.getValor() *cinquenta.getQuantidade() + cem.getQuantidade() * cem.getValor();
    }
}
