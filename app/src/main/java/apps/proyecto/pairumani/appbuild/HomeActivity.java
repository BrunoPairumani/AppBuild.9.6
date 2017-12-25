package apps.proyecto.pairumani.appbuild;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import apps.proyecto.pairumani.appbuild.Dialog.LosaHDialog;
import apps.proyecto.pairumani.appbuild.Dialog.MampDialog;
import apps.proyecto.pairumani.appbuild.Dialog.RadierDialog;
import apps.proyecto.pairumani.appbuild.Dialog.RadierHDialog;
import apps.proyecto.pairumani.appbuild.Dialog.RepelloDialog;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



    }


    public void Mposteria(View view) {


        Intent intent = new Intent(this, MamposteriaActivity.class);

        startActivity(intent);
    }
    public void Losa(View view) {


        Intent intent = new Intent(this, LosaActivity.class);

        startActivity(intent);
    }
    public void Radier(View view) {


        Intent intent = new Intent(this, RadierActivity.class);

        startActivity(intent);
    }

    public void Home2(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void Enviar_Cotizacion(View view) {

    }

    public void mampDialog(View view) {

        FragmentManager manager7 = getFragmentManager();
        MampDialog myDialog7 = new MampDialog();

        myDialog7.show(manager7, "MampDialog");
    }

    public void losahDialog(View view) {
        FragmentManager manager8 = getFragmentManager();
        LosaHDialog myDialog8 = new LosaHDialog();

        myDialog8.show(manager8, "LosaHDialog");
    }

    public void radierHDialog(View view) {
        FragmentManager manager9 = getFragmentManager();
        RadierHDialog myDialog9 = new RadierHDialog();

        myDialog9.show(manager9, "RadierHDialog");
    }
}
