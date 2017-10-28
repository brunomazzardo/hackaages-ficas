package ages.hacka.fichasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class criarEntrarSala extends AppCompatActivity {

    Button btnCriarSala;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        this.setContentView(R.layout.criar_entrar_sala);


        btnCriarSala= (Button) findViewById(R.id.criar_sala_btn);
        btnCriarSala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),ConfiguracaoSalaActivity.class);
                startActivity(intent);
                finish();



            }
        });
    }
}
