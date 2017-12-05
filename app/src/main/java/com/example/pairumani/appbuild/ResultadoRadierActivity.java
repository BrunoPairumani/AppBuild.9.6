package com.example.pairumani.appbuild;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoRadierActivity extends AppCompatActivity {
    TextView tvDatos;

    TextView tvMCemento, tvCCemento;
    TextView tvMgrava, tvCgrava;
    TextView tvMarena, tvCarena;
    TextView tvMagua, tvCagua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_radier);
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

        tvDatos = (TextView) findViewById(R.id.tvDatos);
        tvCCemento = (TextView) findViewById(R.id.tvCCemento);
        tvMCemento = (TextView) findViewById(R.id.tvMCemento);

        tvMCemento.setText(d2 + " (Kg.)");
        tvCCemento.setText(d3 + " (Bolsas.)");

        tvMarena = (TextView) findViewById(R.id.tvMarena);
        tvMarena.setText(d4+" (Lts.)");

        tvCarena = (TextView) findViewById(R.id.tvCarena);
        tvCarena.setText(d5+" (m^3)");

        tvMgrava = (TextView) findViewById(R.id.tvMgrava);
        tvCgrava = (TextView) findViewById(R.id.tvCgrava);
        tvMgrava.setText(d6+" (Lts)");
        tvCgrava.setText(d7+" (m^3)");

        tvMagua = (TextView) findViewById(R.id.tvMagua);
        tvCagua = (TextView) findViewById(R.id.tvCagua);
        tvCagua.setText(d9+" (m^3)");
        tvMagua.setText(d8+" (Lts)");



        tvDatos.setText(d1+ " m^3,  (H-20)");


    }
}
