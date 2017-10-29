package ages.hacka.fichasapp.util;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import ages.hacka.fichasapp.model.Jogador;
import ages.hacka.fichasapp.model.Sala;

/**
 * Created by mazzardo on 29/10/17.
 */

public class EntraSala {

    public static boolean entra(String hash, Jogador jogador){
        Sala sala = null;
//                BuscaSala.busca(hash);
        if(sala!=null){
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("salas/"+hash+"/jogos/0/");
            String key = ref.child("jogadores").push().getKey();

            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("/salas/" + key, sala);
           // rootRef.updateChildren(childUpdates);
            return false;
        }

        return true;


    }
}
