package ages.hacka.fichasapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import ages.hacka.fichasapp.activities.TestFirebaseActivity;
import ages.hacka.fichasapp.model.Jogo;

public class ConfiguracaoSalaActivity extends AppCompatActivity {

    Button btnCriarSala;
    EditText buyInInput;
    EditText reBuyInput;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracao_sala);

        btnCriarSala = findViewById(R.id.criarSalaBtn);
        buyInInput = findViewById(R.id.buyInInput);
        reBuyInput = findViewById(R.id.reBuyInput);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);



        btnCriarSala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!buyInInput.getText().toString().equalsIgnoreCase("") && !reBuyInput.getText().toString().equalsIgnoreCase("")){
                    Jogo jogo = new Jogo();
                    jogo.setBuyIn(Integer.parseInt(buyInInput.getText().toString()));
                    jogo.setReBuy(Integer.parseInt(reBuyInput.getText().toString()));

                    //Pegando o RadioButtons que foram selecionado;
                    radioButton = (RadioButton) radioGroup.getChildAt(radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId())));

                    //Pegando o texto dos RadioButtons selecionados
                    jogo.setMultiplicador(Integer.parseInt(radioButton.getText().toString()));


                    Intent intent = new Intent(getBaseContext(), SalaJogoActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast toast = Toast.makeText(getBaseContext(), "Campos obrigatórios não preenchidos", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}
