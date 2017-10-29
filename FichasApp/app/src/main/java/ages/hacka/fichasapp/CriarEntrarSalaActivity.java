package ages.hacka.fichasapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import ages.hacka.fichasapp.model.Sala;
import ages.hacka.fichasapp.util.BuscaSala;


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

                final EditText etCodigoSala = view1.findViewById(R.id.etCodigoSala);
                final Button btnCodigoSala = view1.findViewById(R.id.btnCodigoSala);

                btnCodigoSala.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
//                   dialog.dismiss();

                        final Intent intent = new Intent(getBaseContext(), SalaJogoActivity.class);

                        final String codigo = etCodigoSala.getText().toString();
                        final Sala[] sala = {null};

                        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("salas");

                        ref.addListenerForSingleValueEvent(
                                new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                        boolean temSala = false;
                                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                                            if (postSnapshot.getValue(Sala.class).getId().equals(codigo)) {
                                                temSala = true;
                                                sala[0] = postSnapshot.getValue(Sala.class);
                                                intent.putExtra("sala", sala[0]);
                                                startActivity(intent);
                                            }
                                        }
                                        if(!temSala){
                                            Snackbar snackbar = Snackbar.make(
                                                    view,
                                                    "Lobby não encontrado",
                                                    Snackbar.LENGTH_SHORT
                                            );
                                            snackbar.show();
                                        }
                                    }

                                    @Override
                                    public void onCancelled(DatabaseError databaseError) {
                                        //handle databaseError

                                    }
                                });
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
