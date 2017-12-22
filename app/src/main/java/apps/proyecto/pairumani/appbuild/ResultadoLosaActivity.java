package apps.proyecto.pairumani.appbuild;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultadoLosaActivity extends AppCompatActivity {


    TextView tvDatos;

    TextView tvMCemento, tvCCemento;
    TextView tvMgrava, tvCgrava;
    TextView tvMarena, tvCarena;
    TextView tvMagua, tvCagua;
    TextView Pcemento, Pagua, Parena, Pcemento2, Parena2, Ptotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_losa);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        recibirDatos();
    }


    private void recibirDatos() {
        Bundle extras = getIntent().getExtras();
        String d1 = extras.getString("dato01");
        String d2 = extras.getString("dato02");
        String d3 = extras.getString("dato03");
        String d4 = extras.getString("dato04");
        String d5 = extras.getString("dato05");
        String d6 = extras.getString("dato06");
        String d7 = extras.getString("dato07");
        String d8 = extras.getString("dato08");
        String d9 = extras.getString("dato09");

        String d10 = extras.getString("dato10");
        String d11 = extras.getString("dato11");
        String d12= extras.getString("dato12");
        String d13 = extras.getString("dato13");
        String d14 = extras.getString("dato14");

        tvDatos = (TextView) findViewById(R.id.tvDatos);
        tvCCemento = (TextView) findViewById(R.id.tvCCemento);
        tvMCemento = (TextView) findViewById(R.id.tvMCemento);

        tvMCemento.setText(d2 + " (Kg.)");
        tvCCemento.setText(d3 + " (Bolsas.)");

        tvMarena = (TextView) findViewById(R.id.tvMarena);
        tvMarena.setText(d4+" (Lts.)");

        tvCarena = (TextView) findViewById(R.id.tvCarena);
        tvCarena.setText(d5+" (m³)");

        tvMgrava = (TextView) findViewById(R.id.tvMgrava);
        tvCgrava = (TextView) findViewById(R.id.tvCgrava);
        tvMgrava.setText(d6+" (Lts)");
        tvCgrava.setText(d7+" (m³)");

        tvMagua = (TextView) findViewById(R.id.tvMagua);
        tvCagua = (TextView) findViewById(R.id.tvCagua);
        tvCagua.setText(d8+" (Lts)");
        tvMagua.setText(d9+" (m³)");

        Pcemento = (TextView) findViewById(R.id.Pcemento);
        Pcemento.setText("$ " + d10 );

        Pagua = (TextView) findViewById(R.id.Pagua);
        Pagua.setText("$ " + d11 );


        Parena = (TextView) findViewById(R.id.Parena);
        Parena.setText("$ " + d12 );

        Parena2 = (TextView) findViewById(R.id.Pgrava);
        Parena2.setText("$ " + d13 );

        tvDatos.setText(d1+ " m³,  (H-20)");

        Ptotal = (TextView) findViewById(R.id.TxtPtotal);
        Ptotal.setText("$ " + d14);
    }
    public void Home2(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
