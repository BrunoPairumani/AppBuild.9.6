package com.example.pairumani.appbuild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MamposteriaActivity extends AppCompatActivity {
    public double h, l, e, s ;
    public double CantidadL, CantidadLt, area, CareaL;
    public double Cmortero, CmorteroTd, TotalMortero;  // CANTIDAD DE MORTERO
    public double Cemento, CementoTd, TotalCemento, Totalpc, Totalpf, Totalbolsa, Totalbolsap;  // CEMENTO
    public double AgrFino, AgrFinoTd, TotalAgrFino;
    public double pcemento, pfino;
    public double Pcemento, Parena, Pagua, Pgrava, Pcemento2, Parena2, Pladrillo;

    EditText Maltura1, Manchura1, Mlargo1, desperdicio;
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


        String aux = Maltura1.getText().toString();
        String aux1 = Mlargo1.getText().toString();

        try {
        if (aux.matches("")) {
            Toast.makeText(getApplicationContext(), "Campo Altura está vacío", Toast.LENGTH_SHORT).show();
            Maltura1.setError("Llenar Campo");
            if (aux1.matches("")) {
                Toast.makeText(getApplicationContext(), "Campo Longitud está vacío", Toast.LENGTH_SHORT).show();
                Mlargo1.setError("Llenar Campo");
            }
        } else {
            if (aux1.matches("")) {
                Toast.makeText(getApplicationContext(), "Campo Longitud está vacío", Toast.LENGTH_SHORT).show();
                Mlargo1.setError("Llenar Campo");
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
                    h = 0.07;
                    l = 0.12;
                    e = 0.22;


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
                        h = 0.07;
                        e = 0.12;
                        l = 0.22;


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


                        h = 0.12;
                        e = 0.07;
                        l = 0.22;


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
                     Totalbolsa = TotalCemento / 42.5;
                     Totalbolsap = Totalpc / 42.5;
                     Pcemento = 7500 * Totalbolsa;
                     Pcemento2 = 7500 * Totalbolsap;
                     Pladrillo = 490 * CareaL;
                     Parena = 48450 * TotalAgrFino;
                     Parena2 = 48450 * Totalpf;

                 }
                 catch (Exception e)
                 {
                     Toast.makeText(getApplicationContext(), "Parámetros Inválidos, Ingresar Números", Toast.LENGTH_SHORT).show();
                 }
                Intent i = new Intent(this, ResultadosActivity.class);
                i.putExtra("dato01", String.format("%.2f", area));
                i.putExtra("dato02", String.format("%.0f", CareaL));
                i.putExtra("dato03", String.format("%.2f", TotalCemento));
                i.putExtra("dato04", String.format("%.2f", Totalbolsa));
                i.putExtra("dato05", String.format("%.2f", TotalMortero));
                i.putExtra("dato06", String.format("%.2f", TotalAgrFino));
                i.putExtra("dato07", String.format("%.2f", Totalpc));
                i.putExtra("dato08", String.format("%.2f", Totalbolsap));
                i.putExtra("dato09", String.format("%.2f", Totalpf));

                i.putExtra("dato10", String.format("%.2f", Pcemento));
                i.putExtra("dato11", String.format("%.2f", Pcemento2));
                i.putExtra("dato12", String.format("%.2f", Parena));
                i.putExtra("dato13", String.format("%.2f", Parena2));
                i.putExtra("dato14", String.format("%.2f", Pladrillo));

                startActivity(i);

            }
        }

    }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Parámetros Inválidos, Ingresar Números", Toast.LENGTH_SHORT).show();
            Maltura1.setError("Verificar");

            Mlargo1.setError("Verificar");
        }

    }




}