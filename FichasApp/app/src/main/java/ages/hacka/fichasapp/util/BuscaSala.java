package ages.hacka.fichasapp.util;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

import ages.hacka.fichasapp.model.Jogador;
import ages.hacka.fichasapp.model.Sala;

/**
 * Created by mazzardo on 29/10/17.
 */

public class BuscaSala {


    public static Sala busca(final String hash){

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("salas");
        final Sala[] sala = {null};
        ref.addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren())
                            if(postSnapshot.getValue(Sala.class).getId().equals(hash))
                                 sala[0] = postSnapshot.getValue(Sala.class);


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        //handle databaseError
                    }
                });

        return sala[0];



    }
}
