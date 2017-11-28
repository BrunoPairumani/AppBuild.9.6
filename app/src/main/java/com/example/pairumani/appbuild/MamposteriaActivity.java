package com.example.pairumani.appbuild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MamposteriaActivity extends AppCompatActivity {
    public double h, l, e, s ;
    public double CantidadL, CantidadLt, area, CareaL;

    EditText Maltura1, Manchura1, Mlargo1, desperdicio;
    Button Calcular1;
    RadioButton rbespesor11, rbespesor21, rbespesor31;
    RadioButton rbtizon1, rbsoga1, rbpapelillo1;
    TextView Txtarea, TxtTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mamposteria);


        Maltura1 = (EditText) findViewById(R.id.Maltura);
        Manchura1 = (EditText) findViewById(R.id.Manchura);

        Mlargo1 = (EditText) findViewById(R.id.Mlargo);

        desperdicio = (EditText) findViewById(R.id.edtdesperdicio);


        rbespesor11 = (RadioButton) findViewById(R.id.rbespesor1);


        rbespesor21 = (RadioButton) findViewById(R.id.rbespesor2);

        rbespesor31 = (RadioButton) findViewById(R.id.rbespesor3);

        rbtizon1 = (RadioButton) findViewById(R.id.rbtizon);
        rbsoga1 = (RadioButton) findViewById(R.id.rbsoga);
        rbpapelillo1 = (RadioButton) findViewById(R.id.rbpapelillo);

// objeto sea una variable global
    Calcular1 = (Button) findViewById(R.id.btncalcular);


Txtarea= (TextView)findViewById(R.id.txtarea);


        TxtTotal=(TextView) findViewById(R.id.txtTotal);






    }


    public void Operar (View view) {


       /* double dpdicio = Double.parseDouble(desperdicio.getText().toString());
        double alt = Double.parseDouble(Maltura1.getText().toString());
        double anch = Double.parseDouble(Manchura1.getText().toString());
        double longi = Double.parseDouble(Mlargo1.getText().toString());
*/        double v1 = Double.parseDouble(Maltura1.getText().toString());
        double v2 = Double.parseDouble(Manchura1.getText().toString());
        double v3 = Double.parseDouble(Mlargo1.getText().toString());
        double v4 = Double.parseDouble(desperdicio.getText().toString());
        area = 2*(v1 * v2 + v2 * v3 + v1 * v3);
       // area = 2 * ((alt * anch) + (anch * longi) + (alt * longi)); // Area del muro


        Txtarea.setText(String.valueOf(String.format("%.2f", area)));


        if (rbtizon1.isChecked())
        {
            h = 0.07;
            l = 0.12;
            e = 0.22;

            CantidadL = 1/((l+s)*(h+s));  // metro cuadrado






            if (rbespesor11.isChecked())
            {
                s=0.01;
                CantidadLt = CantidadL + (CantidadL * (v4/100));   // total con desperdicio

                CareaL = area * CantidadLt;

                TxtTotal.setText(String.valueOf(String.format("%.2f",CareaL)));



            }
            else
            {
                if (rbespesor21.isChecked())
                {
                    s=0.012;
                    CantidadLt = CantidadL + (CantidadL * (v4/100));   // total con desperdicio
                    CareaL = area * CantidadLt;
                    TxtTotal.setText(String.valueOf(String.format("%.2f",CareaL)));
                }

                else {

                    s=0.015;
                    CantidadLt = CantidadL + (CantidadL * (v4/100));   // total con desperdicio
                    CareaL = area * CantidadLt;
                    TxtTotal.setText(String.valueOf(String.format("%.2f",CareaL)));

                }


            }


        }
        else
        {
            if (rbsoga1.isChecked())
            {
                h = 0.07;
                e = 0.12;
                l = 0.22;
                CantidadL = 1/(((l)+(s))*((h)+(s)));

                if (rbespesor11.isChecked())
                {
                    s=0.01;
                    CantidadLt = CantidadL + (CantidadL * (v4/100));   // total con desperdicio
                    CareaL = area * CantidadLt;
                    TxtTotal.setText(String.valueOf(String.format("%.2f",CareaL)));
                }
                else
                {
                    if (rbespesor21.isChecked())
                    {
                        s=0.012;

                        CantidadLt = CantidadL + (CantidadL * (v4/100));   // total con desperdicio
                        CareaL = area * CantidadLt;
                        TxtTotal.setText(String.valueOf(String.format("%.2f",CareaL)));
                    }

                    else {

                        s=0.015;
                        CantidadLt = CantidadL + (CantidadL * (v4/100));   // total con desperdicio
                        CareaL = area * CantidadLt;
                        TxtTotal.setText(String.valueOf(String.format("%.2f",CareaL)));

                    }


                }
            }

            else
            {


                h = 0.12;
                e = 0.07;
                l = 0.22;
                CantidadL = 1/(((l)+(s))*((h)+(s)));

                if (rbespesor11.isChecked())
                {
                    s=0.01;
                    CantidadLt = CantidadL + (CantidadL * (v4/100));   // total con desperdicio
                    CareaL = area * CantidadLt;
                    TxtTotal.setText(String.valueOf(String.format("%.2f",CareaL)));
                }
                else
                {
                    if (rbespesor21.isChecked())
                    {
                        s=0.012;
                        CantidadLt = CantidadL + (CantidadL * (v4/100));   // total con desperdicio
                        CareaL = area * CantidadLt;
                        TxtTotal.setText(String.valueOf(String.format("%.2f",CareaL)));
                    }


                    else {

                        s=0.015;
                        CantidadLt = CantidadL + (CantidadL * (v4/100));   // total con desperdicio
                        CareaL = area * CantidadLt;

                        TxtTotal.setText(String.valueOf(String.format("%.2f",CareaL)));
                    }


                }
            }
        }


    }


}
