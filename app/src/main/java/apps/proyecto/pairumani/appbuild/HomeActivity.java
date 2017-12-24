package apps.proyecto.pairumani.appbuild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
}
