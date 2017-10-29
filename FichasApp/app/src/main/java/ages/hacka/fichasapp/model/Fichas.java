package ages.hacka.fichasapp.model;

import java.io.Serializable;

/**
 * Created by mazzardo on 28/10/17.
 */

public class Fichas  implements Serializable {
    private int valor ;
    private int quantidade;
   public  Fichas(int valor){
         this.valor=valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Fichas{" +
                "valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }
}
