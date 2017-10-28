package ages.hacka.fichasapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.support.v7.app.ActionBarActivity;


public class criarEntrarSala extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        this.setContentView(R.layout.criar_entrar_sala);
    }
}
