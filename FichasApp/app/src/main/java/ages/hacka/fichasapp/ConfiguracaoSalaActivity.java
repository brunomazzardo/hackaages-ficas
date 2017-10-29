package ages.hacka.fichasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ages.hacka.fichasapp.activities.TestFirebaseActivity;

public class ConfiguracaoSalaActivity extends AppCompatActivity {

    Button btnCriarSala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_configuracao_sala);

        btnCriarSala = findViewById(R.id.criarSalaBtn);

        btnCriarSala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),SalaJogoActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
