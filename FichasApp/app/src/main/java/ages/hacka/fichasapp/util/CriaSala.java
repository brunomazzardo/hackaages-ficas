package ages.hacka.fichasapp.util;

import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import ages.hacka.fichasapp.model.Jogador;
import ages.hacka.fichasapp.model.Sala;


/**
 * Created by mazzardo on 28/10/17.
 */

public class CriaSala {
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();


    public boolean cria(Jogador jogador, Sala sala) throws NoSuchAlgorithmException {


        try {
            jogador.setEmail("bruno@gmail.com");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(jogador.getEmail().getBytes());
            String hash = String.format("%032x%n", new BigInteger(1, digest)).substring(0, 9);
            sala.setId(hash);
            String key = rootRef.child("salas").push().getKey();
            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("/salas/" + key, sala);
            rootRef.updateChildren(childUpdates);
            return true;

        }catch (Exception e){
            return false;

        }



    }

}
