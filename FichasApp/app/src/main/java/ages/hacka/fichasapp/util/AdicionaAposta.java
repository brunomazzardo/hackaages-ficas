package ages.hacka.fichasapp.util;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import ages.hacka.fichasapp.model.Jogada;
import ages.hacka.fichasapp.model.Sala;

/**
 * Created by mazzardo on 29/10/17.
 */

public class AdicionaAposta {

    public static boolean adiciona(final Jogada jogada){
        final ArrayList<Jogada> jogadas = new ArrayList<>();
        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("salas/-KxaHQa9r_igFHHhMy01/jogos/0/mao/jogadas/");
        databaseReference.setValue(jogada);

        return false;


    }

}
