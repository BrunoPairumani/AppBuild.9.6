package com.example.pairumani.appbuild;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadosActivity extends AppCompatActivity {

    TextView tvDatos;
    TextView tvMLadrillo, tvCLadrillo;
    TextView tvMCemento, tvCCemento;
    TextView tvMmortero, tvCmortero;
    TextView tvMfino, tvCfino;
    TextView tvMppc, tvCppc;
    TextView tvMppf, tvCppf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
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


        tvDatos.setText(d1+ " metros cuadrados");


    }
}
