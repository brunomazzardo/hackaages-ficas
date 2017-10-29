        package ages.hacka.fichasapp;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
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

    ImageView ficha10Imgg;
    ImageView ficha20Imgg;
    ImageView ficha50Imgg;
    ImageView ficha100Imgg;
    TextView aposta;
    TextView total;
    FirebaseUser user;
    Button apostarBtn;
    Button cancelarBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sala_jogo);

        ficha10Imgg = (ImageView) findViewById(R.id.ficha10Img);
        ficha20Imgg = (ImageView) findViewById(R.id.ficha20Img);
        ficha50Imgg = (ImageView) findViewById(R.id.ficha50Img);
        ficha100Imgg = (ImageView) findViewById(R.id.ficha100Img);
        aposta = findViewById(R.id.apostaNum);
        total = findViewById(R.id.totalNum);
        user = FirebaseAuth.getInstance().getCurrentUser();
        apostarBtn = findViewById(R.id.apostarBtn);
        cancelarBtn = findViewById(R.id.cancelarBtn);

        final Ficha ficha10= new Ficha(10);
        final Ficha ficha20= new Ficha(20);
        final Ficha ficha50= new Ficha(50);
        final Ficha ficha100= new Ficha(100);
        final ArrayList<Ficha> fichaSet= new ArrayList<>();

        fichaSet.add(ficha10);
        fichaSet.add(ficha20);
        fichaSet.add(ficha50);
        fichaSet.add(ficha100);


        apostarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aposta aposta = new Aposta(fichaSet);
                Jogada jogada = new Jogada(user.getUid() ,aposta,false);
                AdicionaAposta.adiciona(jogada);



            }

        });

        ficha10Imgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aposter(10);
                ficha10.setQuantidade(ficha10.getQuantidade()+1);
            }

        });

        ficha20Imgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aposter(20);
                ficha20.setQuantidade(ficha20.getQuantidade()+1);
            }

        });

        ficha50Imgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aposter(50);
                ficha50.setQuantidade(ficha50.getQuantidade()+1);
            }

        });

        ficha100Imgg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aposter(100);
                ficha100.setQuantidade(ficha100.getQuantidade()+1);
            }

        });


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

    public void aposter(int num){
//        Toast toast = Toast.makeText(getBaseContext(), num, Toast.LENGTH_LONG);
//        toast.show();

        int apostaInt = Integer.parseInt(aposta.getText().toString());
        int soma = apostaInt + num;
        String resultado = Integer.toString(soma);
        aposta.setText(resultado);

        int totalInt = Integer.parseInt(total.getText().toString());
        int subtracao = totalInt - num;
        String result = Integer.toString(subtracao);
        total.setText(result);

    }
}
