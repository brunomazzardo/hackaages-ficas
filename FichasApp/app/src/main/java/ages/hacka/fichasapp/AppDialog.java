package ages.hacka.fichasapp;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AppDialog extends Dialog {

    View mainView;
    public AppDialog(@NonNull Context context) {
        super(context);
        mainView = LayoutInflater.from(context).inflate(R.layout.popup_entrar_sala,null);

        addContentView(mainView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
    }
}