package ages.hacka.fichasapp.activities;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import ages.hacka.fichasapp.R;
import ages.hacka.fichasapp.model.Aposta;
import ages.hacka.fichasapp.model.Ficha;
import ages.hacka.fichasapp.model.Jogada;
import ages.hacka.fichasapp.model.Jogador;
import ages.hacka.fichasapp.model.Jogo;
import ages.hacka.fichasapp.model.Mao;
import ages.hacka.fichasapp.model.Sala;

public class TestFirebaseActivity extends AppCompatActivity {

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference salasRef = rootRef.child("salas");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_firebase);
        ArrayList<Sala> salas = new ArrayList<>();
        List<Jogador> jogadors= new ArrayList<>();
        Ficha ficha10= new Ficha(10);
        Ficha ficha20= new Ficha(20);
        Ficha ficha50= new Ficha(50);
        Ficha ficha100= new Ficha(100);
        List<Ficha> fichaSet= new ArrayList<>();
        fichaSet.add(ficha10);
        fichaSet.add(ficha20);
        fichaSet.add(ficha50);
        fichaSet.add(ficha100);
        Aposta aposta = new Aposta(fichaSet);
        Jogada jogada = new Jogada("1",aposta,false);

        ArrayList<Jogada> jogadas = new ArrayList<>();

        Jogador jogador = new Jogador(10,"1",aposta,true);
        jogadors.add(jogador);

        jogadas.add(jogada);
        Mao mao = new Mao("1",10,0,jogadas);

//
//        String vencedor, int mainPot, int sidePot, ArrayList<Jogada > jogadas
        Jogo jogo = new Jogo(jogadors,mao,10,5,1,10);

//
//        ArrayList<Jogador> jogadores;
//        Mao mao ;
//        int buyIn;
//        int reBuy;
//        int multiplicador;
//        int valor;
        List<Jogo> jogos = new ArrayList<>();
        jogos.add(jogo);

        Sala sala = new Sala("11",jogos);

        salas.add(sala);
//        ObjectMapper mapper = new ObjectMapper();
//String jsonInString="";
//        try {
//             jsonInString = mapper.writeValueAsString(sala);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
//        JSONObject jsonObject = null;
//        try {
//             jsonObject = new JSONObject(jsonInString);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        salasRef.setValue(salas);
        salasRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                ArrayList<Sala> salas = new ArrayList<>();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Sala sala = postSnapshot.getValue(Sala.class);
                    salas.add(sala);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getBaseContext(),"Failed to read value." + error.toException() ,Toast.LENGTH_LONG);
            }
        });

    }

}
