package apps.proyecto.pairumani.appbuild;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Properties;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ResultadosActivity extends AppCompatActivity implements View.OnClickListener {

    //CORREO

    Session session = null;
    ProgressDialog pdialog = null;
    Context context = null;
    EditText reciep;
    String rec, subject, textMessage;
    String sub, msg;
    String html;





    TextView tvDatos, tvDatos2;
    TextView tvMLadrillo, tvCLadrillo;
    TextView tvMCemento, tvCCemento;
    TextView tvMmortero, tvCmortero;
    TextView tvMfino, tvCfino;
    TextView tvMppc, tvCppc;
    TextView tvMppf, tvCppf, PcAgua;
    TextView Pcemento, Pladrillo, Parena, Pcemento2, Parena2, Ptotal;
    Button btn_correo, login;
    EditText correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
       // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        correo = (EditText) findViewById(R.id.et_to); // DESTINATARIO DEL CORREO
        sub = "Cotización";  // ASUNTO DEL CORREO


        context = this;
        login = (Button) findViewById(R.id.btn_Enviar);

        btn_correo = (Button) findViewById(R.id.btn_Correo);




        recibirDatos();

        login.setOnClickListener(this);
    }



    public void recibirDatos() {
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
        String d16 = extras.getString("dato16");
        String d17 = extras.getString("dato17");
        String d18 = extras.getString("dato18");
        String d19 = extras.getString("dato19");
        String d20 = extras.getString("dato20");
// CARGAR ARCHIVO HTML

        html = "<!DOCTYPE html>" +
                "<html>" +

                "<body>" +
                "<div >" +
                "<h3> MATERIALES MAMPOSTERÍA</h3>"+
                "<h4> Cálculo para cubrir  "+ d1+ "  metros cuadrados (m²) </h4>"+
                "<table border='1'  role='grid' >" +
                "<thead>"+
                "<tr bgcolor='#b2ffff' role='row'>" +
                "<th width='100'  tabindex='0'  rowspan='1' colspan='1'>" +
                "<strong>Material</strong>" +
                "</th>" +
                "<th width='100'  tabindex='0'  rowspan='1' colspan='1'>" +
                "<strong>Medida</strong>" +
                "</th>" +
                "<th width='100'  tabindex='0'  rowspan='1' colspan='1'>" +
                "<strong>Cantidad</strong>" +
                "</th>" +
                "<th width='100'  tabindex='0'  rowspan='1' colspan='1'>" +
                "<strong>Precio</strong>" +
                "</th>" +
                "</tr>"+
                "</thead>" +

                " <tbody>" +
                "<tr role='row'>" +
                "<td> Ladrillo </td>"+
                "<td align=\"right\">" + d2 +" (Un.)</td>"+
                "<td align=\"right\">" + d2 +" (Un.)</td>"+
                "<td align=\"right\"> $ " + d14 +"</td>"+
                "</tr>"+



                "<tr role='row'>" +
                "<td> Cemento </td>"+
                "<td align=\"right\">" + d3 +" (kg.)</td>"+
                "<td align=\"right\">" + d4 +" (Bolsas.)</td>"+
                "<td align=\"right\"> $ " + d10 +"</td>"+
                "</tr>"+

                "<tr role='row'>" +
                "<td> Agua </td>"+
                "<td align=\"right\">" + d17 +" (Lts.)</td>"+
                "<td align=\"right\">" + d18 +" (m³.)</td>"+
                "<td align=\"right\"> $ " + d19 +"</td>"+
                "</tr>"+

                "<tr role='row'>" +
                "<td> Arena </td>"+
                "<td align=\"right\">" + d16 +" (Lts.)</td>"+
                "<td align=\"right\">" + d6 +" (m³)</td>"+
                "<td align=\"right\"> $ " + d12 +"</td>"+
                "</tr>"+


                "<tr bgcolor='#b2ffff' align=\"center\" valign=\"middle\" >" +
                "<th bgcolor='#b2ffff' colspan=\"4\" > Muro a Repellar </th>"+
                "</tr>"+

                "<tr role='row'>" +
                "<td> Cemento </td>"+
                "<td align=\"right\">" + d7 +" (kg.)</td>"+
                "<td align=\"right\">" + d8 +" (Bolsas.)</td>"+
                "<td align=\"right\"> $ " + d11 +"</td>"+
                "</tr>"+

                "<tr role='row'>" +
                "<td> Arena </td>"+
                "<td align=\"right\">" + d20 +" (Lts.)</td>"+
                "<td align=\"right\">" + d9 +" (m³.)</td>"+
                "<td align=\"right\"> $ " + d13 +"</td>"+
                "</tr>"+

                "<tr role='row'>" +
                "<td> <strong>Total </strong> </td>"+
                "<td align=\"right\" valign=\"middle\" colspan=\"3\"> <strong> $ " + d15 +"</strong></td>"+
                "</tr>"+

                "</tbody>"+
                "</table>"+
                "<h4> Cemento: Bolsas 42.5 Kg, Arena 25kg, Grava 25  Kg. </h4>"+
                "</div>" +

                "<br>"+
                "<strong style=\"margin: 0; font-size:17px; color: rgba(40, 45, 49,.9); line-height: 24px; height: 24px; display:block\">Atentamente</strong>"+
                "<br>"+
                "<div style=\"border: 1px solid rgba(37, 201, 255,.5); display: inline-block; border-radius: 3px;\">"+

                "<table style=\"font-family: arial; height:90px; border-collapse: collapse; border: \">\n" +
                "  <tr>\n" +
                "    <td style=\"padding: 7px\">\n" +
                "      <img src=\"https://imageshack.com/i/potPwSzQp\" \n" +
                "         alt=\"\" \n" +
                "         width=\"80\" \n" +
                "         height=\"80\" \n" +
                "         style=\"display:block; border-radius: 50%; margin-right: 7px; float: left\"\n" +
                "       >\n" +
                "      <div style=\"width: 5px; height: 80px; background:#75c8fd; float: right\">\n" +
                "    </td>\n" +
                "      \n" +
                "    <td style=\"vertical-align:top; padding:7px 14px 7px 3px\">\n" +
                "      <br>\n" +
                "      <strong style=\"margin: 0; font-size:17px; color: rgba(40, 45, 49,.9); line-height: 24px; height: 24px; display:block\">Soporte Build'u</strong>\n" +
                "      <p style='font-size:12px; margin: 0px 0 6px; height: 30px'>\n" +
                "        <span style=\"margin: 0; color: #666\">Muchas gracias por usar nuestra aplicación</span>\n" +
                "        <br>\n" +
                "        <a style=\"color: #25C9FF; font-weight: bold\" >soporte.buildu@gmail.com</a>\n" +
                "      </p>\n" +
                "     \n" +
                "    </td>\n" +
                "  </tr>\n" +
                "</table>" +

                "</div>"+
                "</body>" +
                "</html>";



        tvDatos = (TextView) findViewById(R.id.tvDatos);
        tvDatos2 = (TextView) findViewById(R.id.tvDatos2);
        tvCLadrillo = (TextView) findViewById(R.id.tvCLadrillo);
        tvMLadrillo = (TextView) findViewById(R.id.tvMLadrillo);

        tvCLadrillo.setText(d2 + " (Un.)");
        tvMLadrillo.setText(d2 + " (Un.)");

        tvMCemento = (TextView) findViewById(R.id.tvMCemento);
        tvMCemento.setText(d4+" (Bolsas)");

        tvCCemento = (TextView) findViewById(R.id.tvCCemento);
        tvCCemento.setText(d3+" (Kg.)");

        tvMfino = (TextView) findViewById(R.id.tvMfino);
        tvCfino = (TextView) findViewById(R.id.tvCfino);
        tvMfino.setText(d16+" (Lts.)");
        tvCfino.setText(d6+" (m³.)");

        tvMmortero = (TextView) findViewById(R.id.tvMmortero);
        tvCmortero = (TextView) findViewById(R.id.tvCmortero);
        tvCmortero.setText(d18+" (m³.)");
        tvMmortero.setText(d17+" (Lts.)");

        tvMppc = (TextView) findViewById(R.id.tvMppc);
        tvCppc = (TextView) findViewById(R.id.tvCppc);
        tvMppc.setText(d7+" (Kg.)");
        tvCppc.setText(d8+ " (Bolsas)");

        tvMppf = (TextView) findViewById(R.id.tvMppf);
        tvCppf = (TextView) findViewById(R.id.tvCppf);
        tvCppf.setText(d9+" (m³.)");
        tvMppf.setText(d20+" (Lts.)");

        tvDatos2.setText(d5 +"(m³/m².)");
        tvDatos.setText(d1+ " metros cuadrados (m².)");

        Pcemento = (TextView) findViewById(R.id.Pcemento);
        Pcemento.setText("$ " + d10 );

        Pcemento2 = (TextView) findViewById(R.id.Pcemento2);
        Pcemento2.setText("$ " + d11 );


        PcAgua= (TextView) findViewById(R.id.PcAgua);
        PcAgua.setText("$ "+ d19);

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


    public void EnviarCorreo(View view) {
        correo.setVisibility(EditText.VISIBLE);
        btn_correo.setVisibility(Button.INVISIBLE);
        login.setVisibility(Button.VISIBLE);

    }
    @Override
    public void onClick(View v) {
        rec = correo.getText().toString();
        subject = sub.toString();
       // textMessage = msg.toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        if (rec.matches("")) {
            Toast.makeText(getApplicationContext(), "Campo de dirección de correo vacío", Toast.LENGTH_SHORT).show();
            correo.setError("Llenar Campo");
        }

           else {

            if (android.util.Patterns.EMAIL_ADDRESS.matcher(rec).matches()) {



            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            // PAREMETROS DEL CORREO SOPORTE
            session = Session.getDefaultInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("soporte.buildu@gmail.com", "bagner2104");
                }
            });

            pdialog = ProgressDialog.show(context, "", "Enviando correo...", true);

            RetreiveFeedTask task = new RetreiveFeedTask();
            task.execute();
            }
            else
            {

                Toast.makeText(getApplicationContext(), "Por favor, verificar correo electronico", Toast.LENGTH_SHORT).show();
                correo.setError("Verificar");
            }
        }
    }


    class RetreiveFeedTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            try{
                Intent intent = new Intent(Intent.ACTION_SEND);

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("testfrom354@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rec));
                message.setSubject(subject);
              // message.setContent(html, "text/html; charset=utf-8");
                message.setContent (html, "text/html; charset=utf-8");
             //  intent.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(html));
                Transport.send(message);
            } catch(MessagingException e) {
                e.printStackTrace();
            } catch(Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(String result) {
            pdialog.dismiss();
           // reciep.setText("");
          //  msg.setText("");
            // sub = ("");

            login.setVisibility(Button.INVISIBLE);
            btn_correo.setVisibility(Button.VISIBLE);
            correo.setVisibility(EditText.INVISIBLE);
            correo.setText("");
            Toast.makeText(getApplicationContext(), "Correo enviado", Toast.LENGTH_LONG).show();
        }
    }

}