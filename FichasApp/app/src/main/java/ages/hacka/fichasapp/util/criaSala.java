package ages.hacka.fichasapp.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import ages.hacka.fichasapp.model.Jogador;
import ages.hacka.fichasapp.model.Sala;

/**
 * Created by mazzardo on 28/10/17.
 */

public class criaSala {

    public boolean cria(Jogador jogador, Sala sala) throws NoSuchAlgorithmException {

        String password = new Date().toString() ;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        String hash =  new BigInteger(md.digest()).toString(8);




        return false;

    }

}
