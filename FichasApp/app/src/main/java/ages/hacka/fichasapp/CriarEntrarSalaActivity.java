package ages.hacka.fichasapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import ages.hacka.fichasapp.activities.TestFirebaseActivity;
import ages.hacka.fichasapp.model.Aposta;
import ages.hacka.fichasapp.model.Ficha;
import ages.hacka.fichasapp.model.Jogada;
import ages.hacka.fichasapp.model.Jogador;
import ages.hacka.fichasapp.model.Jogo;
import ages.hacka.fichasapp.model.Mao;
import ages.hacka.fichasapp.model.Sala;
import ages.hacka.fichasapp.util.CriaSala;
import ages.hacka.fichasapp.util.EntraSala;


public class CriarEntrarSalaActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseUser user;
    Button btnCriarSala;
    Button btnEntrarSala;
    private ImageView ivPhoto;
    private TextView tvLogoff;

    String m_Text = "Jesus";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        this.setContentView(R.layout.activity_criar_entrar_sala);

        user = FirebaseAuth.getInstance().getCurrentUser();

        btnCriarSala= findViewById(R.id.criar_sala_btn);
        btnEntrarSala= findViewById(R.id.entrar_sala_btn);
        ivPhoto = findViewById(R.id.ivUserPhoto);
        tvLogoff = findViewById(R.id.tvLogoff);
        findViewById(R.id.tvLogoff).setOnClickListener(this);

        tvLogoff.setText(getString(R.string.logoff_text, user.getDisplayName().split(" ")));
        Picasso.with(this).load(user.getProviderData().get(1).getPhotoUrl()).into(ivPhoto);

        btnCriarSala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),ConfiguracaoSalaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnEntrarSala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CriaSala criaSala = new CriaSala();

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


                Jogo jogo = new Jogo(jogadors,mao,10,5,1,10);


                List<Jogo> jogos = new ArrayList<>();
                jogos.add(jogo);

                Sala sala = new Sala("11",jogos);

                salas.add(sala);
                //criaSala.cria(jogador,sala);
                EntraSala entraSala = new EntraSala();
                jogador.setId("bucetinha");
                entraSala.entraSala("61cb6fa63",jogador);


//                Intent intent = new Intent(getBaseContext(),TestFirebaseActivity.class);
//                startActivity(intent);
//                finish();


                //Alerter funcionando

//                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(CriarEntrarSalaActivity.this, R.style.CustomAlertDialog));
//                builder.setTitle("Id da Sala");
//
//// Set up the input
//                final EditText input = new EditText(CriarEntrarSalaActivity.this);
//// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
//                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//                builder.setView(input);
//
//// Set up the buttons
//                builder.setPositiveButton("Entrar", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                       m_Text = input.getText().toString();
//                    }
//                });
//                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                });
//
//                builder.show();


                //Com uma classe que chama o xml e poe em cima
//                AppDialog dialog = new AppDialog(CriarEntrarSalaActivity.this);
//                dialog.show();
//


                //Com um xml zuado
//                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
//                        getBaseContext(), R.style.CustomAlertDialog);
//                AlertDialog alertDialog = alertDialogBuilder.create();
//                alertDialog.show();
            }
        });
    }

    private void signOut() {
        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();

        finish();
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.tvLogoff) {
            signOut();
        }
    }
}
