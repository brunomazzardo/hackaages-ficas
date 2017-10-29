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

import ages.hacka.fichasapp.R;
import ages.hacka.fichasapp.model.Aposta;
import ages.hacka.fichasapp.model.Fichas;
import ages.hacka.fichasapp.model.Jogada;
import ages.hacka.fichasapp.model.Jogador;
import ages.hacka.fichasapp.model.Jogo;
import ages.hacka.fichasapp.model.Mao;
import ages.hacka.fichasapp.model.Sala;

public class TestFirebaseActivity extends AppCompatActivity {

    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference nameRef= rootRef.child("name");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_firebase);
        ArrayList<Sala> salas = new ArrayList<>();
        ArrayList<Jogador> jogadors= new ArrayList<>();
        Fichas ficha10= new Fichas(10);
        Fichas ficha20= new Fichas(20);
        Fichas ficha50= new Fichas(50);
        Fichas ficha100= new Fichas(100);
        Aposta aposta = new Aposta(ficha10,ficha20,ficha50,ficha100);
        Jogada jogada = new Jogada("1",aposta,false);
        jogada.getAposta().getCem().setQuantidade(10);
        jogada.getAposta().getCinquenta().setQuantidade(1);
        jogada.getAposta().getCinquenta().setQuantidade(5);
        jogada.getAposta().getVinte().setQuantidade(3);
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
        ArrayList<Jogo> jogos = new ArrayList<>();
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

        nameRef.setValue(salas);
        nameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(getBaseContext(),value,Toast.LENGTH_LONG);
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Toast.makeText(getBaseContext(),"Failed to read value." + error.toException() ,Toast.LENGTH_LONG);
            }
        });

    }

}
