package ages.hacka.fichasapp.util;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import ages.hacka.fichasapp.model.Jogada;

/**
 * Created by mazzardo on 29/10/17.
 */

public class AdicionaAposta {

    public static boolean adiciona(final Jogada jogada){

        Random random = new Random();
        int key= random.nextInt(99999)+1;
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref = rootRef.child("salas/-KxaHQa9r_igFHHhMy01/jogos/0/mao/");
//        String key =ref.child("jogadas").push().getKey();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/jogadas/"+key, jogada);
        ref.updateChildren(childUpdates);


        return false;


    }

}
