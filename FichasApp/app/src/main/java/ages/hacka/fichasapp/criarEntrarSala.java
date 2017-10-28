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


public class criarEntrarSala extends AppCompatActivity {

    Button btnCriarSala;
    Button btnEntrarSala;
     String m_Text = "Jesus";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        this.setContentView(R.layout.activity_criar_entrar_sala);


        btnCriarSala= (Button) findViewById(R.id.criar_sala_btn);
        btnEntrarSala= (Button) findViewById(R.id.entrar_sala_btn);
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

                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(criarEntrarSala.this, R.style.CustomAlertDialog));
                builder.setTitle("Id da Sala");

// Set up the input
                final EditText input = new EditText(criarEntrarSala.this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                builder.setView(input);

// Set up the buttons
                builder.setPositiveButton("Entrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       m_Text = input.getText().toString();
                    }
                });
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();


                //Com uma classe que chama o xml e poe em cima
//                AppDialog dialog = new AppDialog(criarEntrarSala.this);
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
}
