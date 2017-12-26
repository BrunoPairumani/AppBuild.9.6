package apps.proyecto.pairumani.appbuild;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import apps.proyecto.pairumani.appbuild.Dialog.EspesorDialog;
import apps.proyecto.pairumani.appbuild.Dialog.ProporcionDialog;
import apps.proyecto.pairumani.appbuild.Dialog.RepelloDialog;

public class MamposteriaActivity extends AppCompatActivity {
    public double h, l, e, s ;
    public double CantidadL, CantidadLt, area, CareaL;
    public double Cmortero, CmorteroTd, TotalMortero;  // CANTIDAD DE MORTERO
    public double Cemento, CementoTd, TotalCemento, Totalpc, Totalpf, Totalbolsa, Totalbolsap;  // CEMENTO
    public double AgrFino, AgrFinoTd, TotalAgrFino;
    public double pcemento, pfino, agua;
    public double Pcemento, Parena, Pcemento2, Parena2, Pladrillo, Ptotal,Pcladrillo;
    public double PcAgua, PltArena, aguaTd, Totalagua, PltsArena;

    public String lx1;
    String url = "";
    String parametros = "";

    EditText Maltura1, Manchura1, Mlargo1;
    Button Calcular1;
    RadioButton rbespesor11, rbespesor21, rbespesor31;
    RadioButton rbtizon1, rbsoga1, rbpapelillo1;
    TextView Txtarea, TxtTotal;
    RadioGroup Ladrillo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mamposteria);


        Maltura1 = (EditText) findViewById(R.id.Maltura);
        //  Manchura1 = (EditText) findViewById(R.id.Manchura);

        Mlargo1 = (EditText) findViewById(R.id.Mlargo);

        // desperdicio = (EditText) findViewById(R.id.edtdesperdicio);


        rbespesor11 = (RadioButton) findViewById(R.id.rbespesor1);


        rbespesor21 = (RadioButton) findViewById(R.id.rbespesor2);

        rbespesor31 = (RadioButton) findViewById(R.id.rbespesor3);

        rbtizon1 = (RadioButton) findViewById(R.id.rbtizon);
        rbsoga1 = (RadioButton) findViewById(R.id.rbsoga);
        rbpapelillo1 = (RadioButton) findViewById(R.id.rbpapelillo);

// objeto sea una variable global
        Calcular1 = (Button) findViewById(R.id.btncalcular);








    }


    public void Operar (View view) {

        try {
            String aux = Maltura1.getText().toString();
            String aux1 = Mlargo1.getText().toString();

            try {
                if (aux.matches("")) {
                    Toast.makeText(getApplicationContext(), "Campo Altura está vacío", Toast.LENGTH_SHORT).show();
                    Maltura1.setError("Verificar");
                    if (aux1.matches("")) {
                        Toast.makeText(getApplicationContext(), "Campo Longitud está vacío", Toast.LENGTH_SHORT).show();
                        Mlargo1.setError("Verificar");
                    }
                } else {
                    if (aux1.matches("")) {
                        Toast.makeText(getApplicationContext(), "Campo Longitud está vacío", Toast.LENGTH_SHORT).show();
                        Mlargo1.setError("Verificar");
                    } else {
                 /* double dpdicio = Double.parseDouble(desperdicio.getText().toString());
        double alt = Double.parseDouble(Maltura1.getText().toString());
        double anch = Double.parseDouble(Manchura1.getText().toString());
        double longi = Double.parseDouble(Mlargo1.getText().toString());
*/
                        double v1 = Double.parseDouble(Maltura1.getText().toString());
                        // double v2 = Double.parseDouble(Manchura1.getText().toString());
                        double v3 = Double.parseDouble(Mlargo1.getText().toString());
                        double v4 = 5;
                        area = v1 * v3;  // para cubrir cierta rango m2
                        // area = 2 * ((alt * anch) + (anch * longi) + (alt * longi)); // Area del muro


                        // Txtarea.setText(String.valueOf(String.format("%.2f", area)));


                        if (rbtizon1.isChecked()) {
                            h = 0.071;
                            l = 0.29;
                            e = 0.14;
                            Pcladrillo = 490;

                            if (rbespesor11.isChecked()) {
                                s = 0.01;

                                CantidadL = 1 / ((l + s) * (h + s));  // metro cuadrado cantidad de ladrillos

                                CantidadLt = CantidadL + (CantidadL * (v4 / 100));   // total con desperdicio + x metro2

                                CareaL = area * CantidadLt;

                                //  TxtTotal.setText(String.valueOf(String.format("%.2f",CareaL)));


                                // CANTIDAD DE MORTERO DE PEGA M^3 / M^2 MURO

                                Cmortero = (100 * 100 - ((l * 100) * (h * 100) * CantidadL)) * (e / 10000); // POR METRO CUADRADO
                                CmorteroTd = Cmortero + (Cmortero * (v4 / 100));   // Mortero + 5% desperdicio

                                // MORTERO POR  PROPORCIÓN

                                Cemento = Cmortero * 450;
                                AgrFino = Cmortero * 1.08;


                                //MORTERO POR PROPORCION + DESPERDICIO

                                CementoTd = Cemento + (Cemento * (v4 / 100));
                                AgrFinoTd = AgrFino + (AgrFino * (v4 / 100));
                                // PREPELLO

                                pcemento = 7.9;
                                pfino = 0.025;

                                // totales
                                TotalCemento = area * CementoTd;  // TOTAL CON DP
                                TotalMortero = area * CmorteroTd; // TOTAL MORTERO DP
                                TotalAgrFino = area * AgrFinoTd;    // AGREGADO FINO TOTAL DP
                                Totalpc = area * pcemento;  // Prepello
                                Totalpf = area * pfino;

                            //    Conectarbd();

                            } else {
                                if (rbespesor21.isChecked()) {
                                    s = 0.012;
                                    CantidadL = 1 / ((l + s) * (h + s));  // metro cuadrado cantidad de ladrillos

                                    CantidadLt = CantidadL + (CantidadL * (v4 / 100));   // total con desperdicio + x metro2

                                    CareaL = area * CantidadLt;

                                    //  TxtTotal.setText(String.valueOf(String.format("%.2f",CareaL)));


                                    // CANTIDAD DE MORTERO DE PEGA M^3 / M^2 MURO

                                    Cmortero = (100 * 100 - ((l * 100) * (h * 100) * CantidadL)) * (e / 10000); // POR METRO CUADRADO
                                    CmorteroTd = Cmortero + (Cmortero * (v4 / 100));   // Mortero + 5% desperdicio

                                    // MORTERO POR  PROPORCIÓN

                                    Cemento = Cmortero * 450;
                                    AgrFino = Cmortero * 1.08;


                                    //MORTERO POR PROPORCION + DESPERDICIO

                                    CementoTd = Cemento + (Cemento * (v4 / 100));
                                    AgrFinoTd = AgrFino + (AgrFino * (v4 / 100));
                                    // PREPELLO

                                    pcemento = 7.9;
                                    pfino = 0.025;

                                    // totales
                                    TotalCemento = area * CementoTd;  // TOTAL CON DP
                                    TotalMortero = area * CmorteroTd; // TOTAL MORTERO DP
                                    TotalAgrFino = area * AgrFinoTd;    // AGREGADO FINO TOTAL DP
                                    Totalpc = area * pcemento;  // Prepello
                                    Totalpf = area * pfino;


                                } else {

                                    s = 0.015;
                                    CantidadL = 1 / ((l + s) * (h + s));  // metro cuadrado cantidad de ladrillos

                                    CantidadLt = CantidadL + (CantidadL * (v4 / 100));   // total con desperdicio + x metro2

                                    CareaL = area * CantidadLt;

                                    //  TxtTotal.setText(String.valueOf(String.format("%.2f",CareaL)));


                                    // CANTIDAD DE MORTERO DE PEGA M^3 / M^2 MURO

                                    Cmortero = (100 * 100 - ((l * 100) * (h * 100) * CantidadL)) * (e / 10000); // POR METRO CUADRADO
                                    CmorteroTd = Cmortero + (Cmortero * (v4 / 100));   // Mortero + 5% desperdicio

                                    // MORTERO POR  PROPORCIÓN

                                    Cemento = Cmortero * 450;
                                    AgrFino = Cmortero * 1.08;


                                    //MORTERO POR PROPORCION + DESPERDICIO

                                    CementoTd = Cemento + (Cemento * (v4 / 100));
                                    AgrFinoTd = AgrFino + (AgrFino * (v4 / 100));
                                    // PREPELLO

                                    pcemento = 7.9;
                                    pfino = 0.025;

                                    // totales
                                    TotalCemento = area * CementoTd;  // TOTAL CON DP
                                    TotalMortero = area * CmorteroTd; // TOTAL MORTERO DP
                                    TotalAgrFino = area * AgrFinoTd;    // AGREGADO FINO TOTAL DP
                                    Totalpc = area * pcemento;  // Prepello
                                    Totalpf = area * pfino;


                                }


                            }


                        } else {
                            if (rbsoga1.isChecked()) {
                                h = 0.05;
                                e = 0.14;
                                l = 0.285;
Pcladrillo=140;

                                if (rbespesor11.isChecked()) {
                                    CantidadL = 1 / ((l + s) * (h + s));  // metro cuadrado cantidad de ladrillos

                                    CantidadLt = CantidadL + (CantidadL * (v4 / 100));   // total con desperdicio + x metro2

                                    CareaL = area * CantidadLt;

                                    //  TxtTotal.setText(String.valueOf(String.format("%.2f",CareaL)));


                                    // CANTIDAD DE MORTERO DE PEGA M^3 / M^2 MURO

                                    Cmortero = (100 * 100 - ((l * 100) * (h * 100) * CantidadL)) * (e / 10000); // POR METRO CUADRADO
                                    CmorteroTd = Cmortero + (Cmortero * (v4 / 100));   // Mortero + 5% desperdicio

                                    // MORTERO POR  PROPORCIÓN

                                    Cemento = Cmortero * 450;
                                    AgrFino = Cmortero * 1.08;


                                    //MORTERO POR PROPORCION + DESPERDICIO

                                    CementoTd = Cemento + (Cemento * (v4 / 100));
                                    AgrFinoTd = AgrFino + (AgrFino * (v4 / 100));
                                    // PREPELLO

                                    pcemento = 7.9;
                                    pfino = 0.025;

                                    // totales
                                    TotalCemento = area * CementoTd;  // TOTAL CON DP
                                    TotalMortero = area * CmorteroTd; // TOTAL MORTERO DP
                                    TotalAgrFino = area * AgrFinoTd;    // AGREGADO FINO TOTAL DP
                                    Totalpc = area * pcemento;  // Prepello
                                    Totalpf = area * pfino;


                                } else {
                                    if (rbespesor21.isChecked()) {
                                        s = 0.012;
                                        CantidadL = 1 / ((l + s) * (h + s));  // metro cuadrado cantidad de ladrillos

                                        CantidadLt = CantidadL + (CantidadL * (v4 / 100));   // total con desperdicio + x metro2

                                        CareaL = area * CantidadLt;

                                        //   TxtTotal.setText(String.valueOf(String.format("%.2f",CareaL)));


                                        // CANTIDAD DE MORTERO DE PEGA M^3 / M^2 MURO

                                        Cmortero = (100 * 100 - ((l * 100) * (h * 100) * CantidadL)) * (e / 10000); // POR METRO CUADRADO
                                        CmorteroTd = Cmortero + (Cmortero * (v4 / 100));   // Mortero + 5% desperdicio

                                        // MORTERO POR  PROPORCIÓN

                                        Cemento = Cmortero * 450;
                                        AgrFino = Cmortero * 1.08;


                                        //MORTERO POR PROPORCION + DESPERDICIO

                                        CementoTd = Cemento + (Cemento * (v4 / 100));
                                        AgrFinoTd = AgrFino + (AgrFino * (v4 / 100));
                                        // PREPELLO

                                        pcemento = 7.9;
                                        pfino = 0.025;

                                        // totales
                                        TotalCemento = area * CementoTd;  // TOTAL CON DP
                                        TotalMortero = area * CmorteroTd; // TOTAL MORTERO DP
                                        TotalAgrFino = area * AgrFinoTd;    // AGREGADO FINO TOTAL DP
                                        Totalpc = area * pcemento;  // Prepello
                                        Totalpf = area * pfino;


                                    } else {

                                        s = 0.015;
                                        CantidadL = 1 / ((l + s) * (h + s));  // metro cuadrado cantidad de ladrillos

                                        CantidadLt = CantidadL + (CantidadL * (v4 / 100));   // total con desperdicio + x metro2

                                        CareaL = area * CantidadLt;

                                        //TxtTotal.setText(String.valueOf(String.format("%.2f",CareaL)));


                                        // CANTIDAD DE MORTERO DE PEGA M^3 / M^2 MURO

                                        Cmortero = (100 * 100 - ((l * 100) * (h * 100) * CantidadL)) * (e / 10000); // POR METRO CUADRADO
                                        CmorteroTd = Cmortero + (Cmortero * (v4 / 100));   // Mortero + 5% desperdicio

                                        // MORTERO POR  PROPORCIÓN

                                        Cemento = Cmortero * 450;
                                        AgrFino = Cmortero * 1.08;


                                        //MORTERO POR PROPORCION + DESPERDICIO

                                        CementoTd = Cemento + (Cemento * (v4 / 100));
                                        AgrFinoTd = AgrFino + (AgrFino * (v4 / 100));
                                        // PREPELLO

                                        pcemento = 7.9;
                                        pfino = 0.025;

                                        // totales
                                        TotalCemento = area * CementoTd;  // TOTAL CON DP
                                        TotalMortero = area * CmorteroTd; // TOTAL MORTERO DP
                                        TotalAgrFino = area * AgrFinoTd;    // AGREGADO FINO TOTAL DP
                                        Totalpc = area * pcemento;  // Prepello
                                        Totalpf = area * pfino;


                                    }


                                }
                            } else {


                                h = 0.055;
                                e = 0.071;
                                l = 0.24;
                                Pcladrillo=145;


                                if (rbespesor11.isChecked()) {
                                    s = 0.01;
                                    CantidadL = 1 / ((l + s) * (h + s));  // metro cuadrado cantidad de ladrillos

                                    CantidadLt = CantidadL + (CantidadL * (v4 / 100));   // total con desperdicio + x metro2

                                    CareaL = area * CantidadLt;

                                    // TxtTotal.setText(String.valueOf(String.format("%.2f",CareaL)));


                                    // CANTIDAD DE MORTERO DE PEGA M^3 / M^2 MURO

                                    Cmortero = (100 * 100 - ((l * 100) * (h * 100) * CantidadL)) * (e / 10000); // POR METRO CUADRADO
                                    CmorteroTd = Cmortero + (Cmortero * (v4 / 100));   // Mortero + 5% desperdicio

                                    // MORTERO POR  PROPORCIÓN

                                    Cemento = Cmortero * 450;
                                    AgrFino = Cmortero * 1.08;


                                    //MORTERO POR PROPORCION + DESPERDICIO

                                    CementoTd = Cemento + (Cemento * (v4 / 100));
                                    AgrFinoTd = AgrFino + (AgrFino * (v4 / 100));
                                    // PREPELLO

                                    pcemento = 7.9;
                                    pfino = 0.025;

                                    // totales
                                    TotalCemento = area * CementoTd;  // TOTAL CON DP
                                    TotalMortero = area * CmorteroTd; // TOTAL MORTERO DP
                                    TotalAgrFino = area * AgrFinoTd;    // AGREGADO FINO TOTAL DP
                                    Totalpc = area * pcemento;  // Prepello
                                    Totalpf = area * pfino;


                                } else {
                                    if (rbespesor21.isChecked()) {
                                        s = 0.012;
                                        CantidadL = 1 / ((l + s) * (h + s));  // metro cuadrado cantidad de ladrillos

                                        CantidadLt = CantidadL + (CantidadL * (v4 / 100));   // total con desperdicio + x metro2

                                        CareaL = area * CantidadLt;

                                        //  TxtTotal.setText(String.valueOf(String.format("%.2f",CareaL)));


                                        // CANTIDAD DE MORTERO DE PEGA M^3 / M^2 MURO

                                        Cmortero = (100 * 100 - ((l * 100) * (h * 100) * CantidadL)) * (e / 10000); // POR METRO CUADRADO
                                        CmorteroTd = Cmortero + (Cmortero * (v4 / 100));   // Mortero + 5% desperdicio

                                        // MORTERO POR  PROPORCIÓN

                                        Cemento = Cmortero * 450;
                                        AgrFino = Cmortero * 1.08;


                                        //MORTERO POR PROPORCION + DESPERDICIO

                                        CementoTd = Cemento + (Cemento * (v4 / 100));
                                        AgrFinoTd = AgrFino + (AgrFino * (v4 / 100));
                                        // PREPELLO

                                        pcemento = 7.9;
                                        pfino = 0.025;

                                        // totales
                                        TotalCemento = area * CementoTd;  // TOTAL CON DP
                                        TotalMortero = area * CmorteroTd; // TOTAL MORTERO DP
                                        TotalAgrFino = area * AgrFinoTd;    // AGREGADO FINO TOTAL DP
                                        Totalpc = area * pcemento;  // Prepello
                                        Totalpf = area * pfino;


                                    } else {

                                        s = 0.015;
                                        CantidadL = 1 / ((l + s) * (h + s));  // metro cuadrado cantidad de ladrillos

                                        CantidadLt = CantidadL + (CantidadL * (v4 / 100));   // total con desperdicio + x metro2

                                        CareaL = area * CantidadLt;

                                        //TxtTotal.setText(String.valueOf(String.format("%.2f",CareaL)));


                                        // CANTIDAD DE MORTERO DE PEGA M^3 / M^2 MURO

                                        Cmortero = (100 * 100 - ((l * 100) * (h * 100) * CantidadL)) * (e / 10000); // POR METRO CUADRADO
                                        CmorteroTd = Cmortero + (Cmortero * (v4 / 100));   // Mortero + 5% desperdicio

                                        // MORTERO POR  PROPORCIÓN

                                        Cemento = Cmortero * 450;
                                        AgrFino = Cmortero * 1.08;


                                        //MORTERO POR PROPORCION + DESPERDICIO

                                        CementoTd = Cemento + (Cemento * (v4 / 100));
                                        AgrFinoTd = AgrFino + (AgrFino * (v4 / 100));
                                        // PREPELLO

                                        pcemento = 7.9;
                                        pfino = 0.025;

                                        // totales
                                        TotalCemento = area * CementoTd;  // TOTAL CON DP
                                        TotalMortero = area * CmorteroTd; // TOTAL MORTERO DP
                                        TotalAgrFino = area * AgrFinoTd;    // AGREGADO FINO TOTAL DP
                                        Totalpc = area * pcemento;  // Prepello
                                        Totalpf = area * pfino;


                                    }


                                }
                            }
                        }
                        try {

                            agua = 147 * area;
                            aguaTd = agua + (agua * (v4 / 100));
                            Totalagua = aguaTd / 1000;
                            Totalbolsa = TotalCemento / 42.5;
                            Totalbolsap = Totalpc / 42.5;

                            // PRECIOS DE MATERIALES
                              Pcemento = (7500 * Totalbolsa);

                           // Pcemento = (c1 * Totalbolsa);
                            Pcemento2 = 7500 * Totalbolsap;


                            //Pladrillo = 490 * CareaL;
                           Pladrillo = Pcladrillo * CareaL;
                            Parena = 48450 * TotalAgrFino;
                            Parena2 = 48450 * Totalpf;


                            PcAgua = 3042 * Totalagua;


                            // TOTAL

                            Ptotal = Pcemento + Pcemento2 + Pladrillo + Parena + Parena2;

                            PltArena = TotalAgrFino * 1000;

                            PltsArena= Totalpf *1000;
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Parámetros Inválidos, Ingresar Números", Toast.LENGTH_SHORT).show();
                        }
                        Intent i = new Intent(this, ResultadosActivity.class);

                        DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
                        simbolo.setDecimalSeparator(',');
                        simbolo.setGroupingSeparator('.');
                        DecimalFormat formateador = new DecimalFormat("###,###", simbolo);

                        DecimalFormat formateador2 = new DecimalFormat("###,###.##", simbolo);

                        i.putExtra("dato01", formateador2.format(area));
                        i.putExtra("dato02", formateador.format(CareaL));
                        i.putExtra("dato03", formateador2.format(TotalCemento));
                        i.putExtra("dato04", formateador2.format(Totalbolsa));
                        i.putExtra("dato05", formateador2.format(TotalMortero));
                        i.putExtra("dato06", formateador2.format(TotalAgrFino));
                        i.putExtra("dato07", formateador2.format(Totalpc));
                        i.putExtra("dato08", formateador2.format(Totalbolsap));
                        i.putExtra("dato09", formateador2.format(Totalpf));

                        i.putExtra("dato10", formateador.format(Pcemento));
                        //i.putExtra("dato10", String.format("%.0f", Pcemento));
                        i.putExtra("dato11", formateador.format(Pcemento2));
                        i.putExtra("dato12", formateador.format(Parena));
                        i.putExtra("dato13", formateador.format(Parena2));
                        i.putExtra("dato14", formateador.format(Pladrillo));
                        i.putExtra("dato15", formateador.format(Ptotal));
                        i.putExtra("dato16", formateador.format(PltArena));

                        i.putExtra("dato17", formateador2.format(aguaTd));
                        i.putExtra("dato18", formateador2.format(Totalagua));
                        i.putExtra("dato19", formateador.format(PcAgua));
                        i.putExtra("dato20", formateador.format(PltsArena));
                        startActivity(i);

                    }
                }

            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Parámetros Inválidos, Ingresar Números", Toast.LENGTH_SHORT).show();
                Maltura1.setError("Verificar");

                Mlargo1.setError("Verificar");
            }
        }
        catch (Exception e){
            Toast.makeText(getApplicationContext(), "Ocurrió un error, inténtelo de nuevo", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MamposteriaActivity.class);
            startActivity(intent);
        }
        }
/*
    private void Conectarbd() {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {


            String nombre = "Condor";



            if (nombre.isEmpty() ) {
                Toast.makeText(getApplicationContext(), "Ningun campo puede estar vacio", Toast.LENGTH_LONG).show();
            }
            else
            {
                 url = "http://www.nexotec.cl/buildu/buscacondor.php";
                // url = "http://192.168.1.34/logar.php";
                parametros = "nombre=" + nombre ;
                Toast.makeText(getApplicationContext(), parametros, Toast.LENGTH_LONG).show();
                //"rut=" + rut +
                new SolicitaDatos().execute(url);
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Ninguna conexion detectada", Toast.LENGTH_LONG).show();
        }


    }



    private class SolicitaDatos extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return conn.postDatos(urls[0], parametros);
            // return conn.postDatos(url, parametros);

        }

        @Override
        protected void onPostExecute(String resultado) {
            Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            if (resultado.contains("ok,")) {

                String[] datos  = resultado.split(",");

                Toast.makeText(getApplicationContext(), datos[1].toString() , Toast.LENGTH_LONG).show();


                l1 = Double.parseDouble(datos[1]);





              //datos2= datos[1].toString();
                //l1 = getIntent().getExtras().getDouble("precio");


             //   l1 = getIntent().getExtras().getDouble("precio");


            } else {
                Toast.makeText(getApplicationContext(), " Usuario / pass Incorrectos ", Toast.LENGTH_LONG).show();

            }
        }




    }
*/    //DIALOG MENSAJES

    public void showDialog(View v) {

        FragmentManager manager = getFragmentManager();
        LadrilloDialog myDialog = new LadrilloDialog();

        myDialog.show(manager, "LadrilloDialog");

    }

    public void espesorDialog(View v) {

        FragmentManager manager2 = getFragmentManager();
        EspesorDialog myDialog2 = new EspesorDialog();

        myDialog2.show(manager2, "EspesorDialog");

    }


    public void proporcionDialog(View v) {

        FragmentManager manager3 = getFragmentManager();
        ProporcionDialog myDialog3 = new ProporcionDialog();

        myDialog3.show(manager3, "PropocionDialog");

    }

    public void repelloDialog(View v) {

        FragmentManager manager4 = getFragmentManager();
        RepelloDialog myDialog4 = new RepelloDialog();

        myDialog4.show(manager4, "RepelloDialog");

    }

}


