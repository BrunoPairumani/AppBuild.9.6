package com.example.pairumani.appbuild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RadierActivity extends AppCompatActivity {
    public double area;
    public double Cmortero, CmorteroTd;  // CANTIDAD DE MORTERO
    public double Cemento, CementoTd,  Totalarena, Totalagua, Totalbolsa, Totalgrava;  // CEMENTO
    public double AgrFino, AgrFinoTd;
    public double agua, aguaTd;


    EditText Mespesor1, Mancho1, Mlargo1;
    Button Calcular1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radier);

        Mespesor1= (EditText) findViewById(R.id.Mespesor);
        Mancho1 = (EditText) findViewById(R.id.Mancho);
        Mlargo1 = (EditText) findViewById(R.id.Mlargo);




// objeto sea una variable global
        Calcular1 = (Button) findViewById(R.id.btnlosa);
    }


    public void Operar(View view) {

        String aux = Mespesor1.getText().toString();
        String aux1= Mlargo1.getText().toString();
        String aux2 = Mancho1.getText().toString();
        try{

            if(aux2.matches("") ){
                Toast.makeText(getApplicationContext(),"Campo  Ancho está vacío", Toast.LENGTH_SHORT).show();
                Mancho1.setError("Llenar Campo");

                if(aux1.matches(""))
                {
                    Toast.makeText(getApplicationContext(),"Campo  Longitud está vacío", Toast.LENGTH_SHORT).show();
                    Mlargo1.setError("Llenar Campo");
                    if (aux.matches(""))
                    {
                        Toast.makeText(getApplicationContext(),"Campo  Espesor está vacío", Toast.LENGTH_SHORT).show();
                        Mespesor1.setError("Llenar Campo");
                    }
                }

            }
            else {

                if (aux1.matches("")) {
                    Toast.makeText(getApplicationContext(), "Campo  Longitud está vacío", Toast.LENGTH_SHORT).show();
                    Mlargo1.setError("Llenar Campo");

                    if (aux.matches("")) {
                        Toast.makeText(getApplicationContext(), "Campo  Espesor está vacío", Toast.LENGTH_SHORT).show();
                        Mespesor1.setError("Llenar Campo");
                    }

                } else

                {
                    if (aux.matches("")) {
                        Toast.makeText(getApplicationContext(), "Campo  Espesor está vacío", Toast.LENGTH_SHORT).show();
                        Mespesor1.setError("Llenar Campo");
                    } else {

                        double v1 = Double.parseDouble(Mancho1.getText().toString());
                        double v2 = Double.parseDouble(Mespesor1.getText().toString());
                        double v3 = Double.parseDouble(Mlargo1.getText().toString());
                        double v4 = 5;

                        v2 = v2 / 100;

                        area = v2 * v1 * v3;  // para cubrir cierta rango m2

                        Cemento = 255 * area;  // CANTIDAD DE CEMENTO
                        CementoTd = Cemento + (Cemento * (v4 / 100));  // CEMENTO CON 5% DESPERDICIO

                        AgrFino = 450 * area;  // CANTIDAD DE ARENA

                        AgrFinoTd = AgrFino + (AgrFino * (v4 / 100));


                        Cmortero = 720 * area; // CANTIDAD DE GRAVA
                        CmorteroTd = Cmortero + (Cmortero * (v4 / 100));

                        agua = 126 * area;
                        aguaTd = agua + (agua * (v4 / 100));

                        Totalbolsa = CementoTd / 42.5;  // BOLSA DE CEMENTO
                        Totalarena = AgrFinoTd / 1000;  // ARENA
                        Totalgrava = CmorteroTd / 1000; // GRAVA
                        Totalagua = aguaTd / 1000;  // AGUA M^3


                        Intent i = new Intent(this, ResultadoRadierActivity.class);

                        i.putExtra("dato01", String.format("%.2f", area));
                        i.putExtra("dato02", String.format("%.2f", CementoTd));
                        i.putExtra("dato03", String.format("%.2f", Totalbolsa));   // TOTAL BOLSA
                        i.putExtra("dato04", String.format("%.2f", AgrFinoTd));
                        i.putExtra("dato05", String.format("%.2f", Totalarena));
                        i.putExtra("dato06", String.format("%.2f", CmorteroTd));  // GRAVA
                        i.putExtra("dato07", String.format("%.2f", Totalgrava));
                        i.putExtra("dato08", String.format("%.2f", aguaTd));
                        i.putExtra("dato09", String.format("%.2f", Totalagua));
                        startActivity(i);
                    }
                }
            }

        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "Parámetros Inválidos, Ingresar Números", Toast.LENGTH_SHORT).show();
            Mancho1.setError("Verificar");
            Mespesor1.setError("Verificar");
            Mlargo1.setError("Verificar");
        }





    }



}
