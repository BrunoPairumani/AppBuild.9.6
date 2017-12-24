package apps.proyecto.pairumani.appbuild;

import android.app.DialogFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LadrilloDialog extends DialogFragment
{

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ladrillo_dialog);
    }
    */

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
     //   return super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.activity_ladrillo_dialog, null);

    }
}
