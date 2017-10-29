package ages.hacka.fichasapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;


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

                AlertDialog.Builder builder = new AlertDialog.Builder(CriarEntrarSalaActivity.this, R.style.CustomAlertDialog);
                View view1 = getLayoutInflater().inflate(R.layout.popup_entrar_sala, null);
                builder.setView(view1);
                final AlertDialog dialog = builder.create();
                dialog.show();

                EditText etCodigoSala = view1.findViewById(R.id.etCodigoSala);
                Button btnCodigoSala = view1.findViewById(R.id.btnCodigoSala);

                btnCodigoSala.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                        Intent intent = new Intent(getBaseContext(), SalaJogoActivity.class);
                        //Enviar jogador aqui ao encontrar sala
                        //
                        startActivity(intent);
                    }
                });
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
