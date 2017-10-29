






        package ages.hacka.fichasapp;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.Toast;

        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

        import ages.hacka.fichasapp.activities.TestFirebaseActivity;
        import ages.hacka.fichasapp.model.Aposta;
        import ages.hacka.fichasapp.model.Ficha;
        import ages.hacka.fichasapp.model.Jogada;
        import ages.hacka.fichasapp.model.Sala;
        import ages.hacka.fichasapp.util.AdicionaAposta;

public class SalaJogoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sala_jogo);

        Ficha ficha10= new Ficha(10);
        Ficha ficha20= new Ficha(20);
        Ficha ficha50= new Ficha(50);
        Ficha ficha100= new Ficha(100);
        ArrayList<Ficha> fichaSet= new ArrayList<>();

        fichaSet.add(ficha10);
        fichaSet.add(ficha20);
        fichaSet.add(ficha50);
        fichaSet.add(ficha100);
        Aposta aposta = new Aposta(fichaSet);
        Jogada jogada = new Jogada("1",aposta,false);

        AdicionaAposta.adiciona(jogada);

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref = rootRef.child("salas/-KxaHQa9r_igFHHhMy01/jogos/0/mao/jogadas");



        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Toast.makeText(getBaseContext(),"SHOW",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getBaseContext(),"Failed to read value." + error.toException() ,Toast.LENGTH_LONG);
            }
        });
    }
}
