package apps.proyecto.pairumani.appbuild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class RadierActivity extends AppCompatActivity {
    public double area,
            Cmortero, CmorteroTd,Cemento, CementoTd,
            Totalarena, Totalagua, Totalbolsa, Totalgrava,  // CEMENTO
            AgrFino, AgrFinoTd,
            agua, aguaTd,
            Ptotal, Pcemento, Parena, Pagua,  Parena2;

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
try {
        String aux = Mespesor1.getText().toString();
        String aux1= Mlargo1.getText().toString();
        String aux2 = Mancho1.getText().toString();
        try{

            if(aux2.matches("") ){
                Toast.makeText(getApplicationContext(),R.string.Ancho_Vacio, Toast.LENGTH_SHORT).show();
                Mancho1.setError("Verificar");

                if(aux1.matches(""))
                {
                    Toast.makeText(getApplicationContext(),R.string.Longitud_Vacio, Toast.LENGTH_SHORT).show();
                    Mlargo1.setError("Verificar");
                    if (aux.matches(""))
                    {
                        Toast.makeText(getApplicationContext(),R.string.Espesor_Vacio, Toast.LENGTH_SHORT).show();
                        Mespesor1.setError("Verificar");
                    }
                }

            }
            else {

                if (aux1.matches("")) {
                    Toast.makeText(getApplicationContext(), R.string.Longitud_Vacio, Toast.LENGTH_SHORT).show();
                    Mlargo1.setError("Verificar");

                    if (aux.matches("")) {
                        Toast.makeText(getApplicationContext(), R.string.Espesor_Vacio, Toast.LENGTH_SHORT).show();
                        Mespesor1.setError("Verificar");
                    }

                } else

                {
                    if (aux.matches("")) {
                        Toast.makeText(getApplicationContext(), R.string.Espesor_Vacio, Toast.LENGTH_SHORT).show();
                        Mespesor1.setError("Verificar");
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

                        // PRECIOS
                        Pcemento = 7500 * Totalbolsa;

                        Parena = 48450 * Totalarena;


                        Parena2 = 48450 * Totalgrava; // Grava

                        Pagua = 3042 * Totalagua;

                        // TOTAL DE PRECIOS

                        Ptotal = Pcemento + Parena + Parena2 + Pagua;

                        Intent i = new Intent(this, ResultadoRadierActivity.class);

                        DecimalFormatSymbols simbolo=new DecimalFormatSymbols();
                        simbolo.setDecimalSeparator(',');
                        simbolo.setGroupingSeparator('.');
                        DecimalFormat formateador = new DecimalFormat("###,###",simbolo);
                        DecimalFormat formateador2 = new DecimalFormat("###,###.##",simbolo);


                        i.putExtra("dato01", formateador2.format(area));
                        i.putExtra("dato02", formateador2.format(CementoTd));
                        i.putExtra("dato03", formateador2.format(Totalbolsa));   // TOTAL BOLSA
                        i.putExtra("dato04", formateador2.format(AgrFinoTd));
                        i.putExtra("dato05", formateador2.format(Totalarena));
                        i.putExtra("dato06", formateador2.format(CmorteroTd));  // GRAVA
                        i.putExtra("dato07", formateador2.format(Totalgrava));
                        i.putExtra("dato08", formateador2.format(aguaTd));
                        i.putExtra("dato09", formateador2.format(Totalagua));

                        // PRECIO EN PESOS CHILENOS

                        i.putExtra("dato10", formateador.format(Pcemento));
                      //  i.putExtra("dato10", String.format("%.2f", Pcemento));
                        i.putExtra("dato11", formateador.format(Pagua));
                        i.putExtra("dato12", formateador.format(Parena));
                        i.putExtra("dato13", formateador.format(Parena2)); // GRAVA
                        i.putExtra("dato14", formateador.format(Ptotal));

                        startActivity(i);
                    }
                }
            }

        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), R.string.No_num, Toast.LENGTH_SHORT).show();
            Mancho1.setError("Verificar");
            Mespesor1.setError("Verificar");
            Mlargo1.setError("Verificar");
        }


}
catch (Exception e){
    Toast.makeText(getApplicationContext(), "Ocurrió un error, inténtelo de nuevo", Toast.LENGTH_SHORT).show();
    Intent intent = new Intent(this, RadierActivity.class);
    startActivity(intent);
}

    }



}
