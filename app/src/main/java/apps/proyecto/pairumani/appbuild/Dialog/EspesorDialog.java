package apps.proyecto.pairumani.appbuild.Dialog;

import android.app.DialogFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import apps.proyecto.pairumani.appbuild.R;

public class EspesorDialog extends DialogFragment implements View.OnClickListener{

    Button cerrar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.activity_espesor_dialog, null);
        cerrar = (Button) view.findViewById(R.id.btncerrar);
        setCancelable(false);
        cerrar.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        dismiss();
    }
}
