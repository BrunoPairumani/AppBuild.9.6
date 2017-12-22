package apps.proyecto.pairumani.appbuild;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultadosActivity extends AppCompatActivity {

    TextView tvDatos;
    TextView tvMLadrillo, tvCLadrillo;
    TextView tvMCemento, tvCCemento;
    TextView tvMmortero, tvCmortero;
    TextView tvMfino, tvCfino;
    TextView tvMppc, tvCppc;
    TextView tvMppf, tvCppf;
    TextView Pcemento, Pladrillo, Parena, Pcemento2, Parena2, Ptotal;

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
        String d10 = extras.getString("dato10");
        String d11 = extras.getString("dato11");
        String d12= extras.getString("dato12");
        String d13 = extras.getString("dato13");
        String d14 = extras.getString("dato14");
        String d15 = extras.getString("dato15");
        tvDatos = (TextView) findViewById(R.id.tvDatos);
        tvCLadrillo = (TextView) findViewById(R.id.tvCLadrillo);
        tvMLadrillo = (TextView) findViewById(R.id.tvMLadrillo);

        tvCLadrillo.setText(d2 + " (Un.)");
        tvMLadrillo.setText(d2 + " (Un.)");

        tvMCemento = (TextView) findViewById(R.id.tvMCemento);
        tvMCemento.setText(d4+" (Bolsas.)");

        tvCCemento = (TextView) findViewById(R.id.tvCCemento);
        tvCCemento.setText(d3+" (Kg.)");

        tvMfino = (TextView) findViewById(R.id.tvMfino);
        tvCfino = (TextView) findViewById(R.id.tvCfino);
        tvMfino.setText(d6+" (m³)");
        tvCfino.setText(d6+" (m³)");

        tvMmortero = (TextView) findViewById(R.id.tvMmortero);
        tvCmortero = (TextView) findViewById(R.id.tvCmortero);
        tvCmortero.setText(d5+" (m³/m²)");
        tvMmortero.setText(d5+" (m³/m²)");

        tvMppc = (TextView) findViewById(R.id.tvMppc);
        tvCppc = (TextView) findViewById(R.id.tvCppc);
        tvMppc.setText(d7+" (Kg.)");
        tvCppc.setText(d8+ " (Bolsas.)");

        tvMppf = (TextView) findViewById(R.id.tvMppf);
        tvCppf = (TextView) findViewById(R.id.tvCppf);
        tvCppf.setText(d9+" (m³)");
        tvMppf.setText(d9+" (m³)");

        tvDatos.setText(d1+ " metros cuadrados (m²)");

        Pcemento = (TextView) findViewById(R.id.Pcemento);
        Pcemento.setText("$ " + d10 );

        Pcemento2 = (TextView) findViewById(R.id.Pcemento2);
        Pcemento2.setText("$ " + d11 );


        Parena = (TextView) findViewById(R.id.Parena);
        Parena.setText("$ " + d12 );

        Parena2 = (TextView) findViewById(R.id.Parena2);
        Parena2.setText("$ " + d13 );

        Pladrillo= (TextView) findViewById(R.id.Pladrillo);
        Pladrillo.setText("$ " + d14 );

        Ptotal = (TextView) findViewById(R.id.TxtPtotal);
        Ptotal.setText("$ " + d15);





    }
    public void Home2(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}