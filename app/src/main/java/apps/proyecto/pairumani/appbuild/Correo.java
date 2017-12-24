package apps.proyecto.pairumani.appbuild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



//public class Correo extends AppCompatActivity implements OnClickListener{
public class Correo extends AppCompatActivity implements OnClickListener{
    Session session = null;
    ProgressDialog pdialog = null;
    Context context = null;
    EditText reciep, msg;
    String rec, subject, textMessage;
    String sub;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correo);

        context = this;
        Button login = (Button) findViewById(R.id.btn_Enviar);

        reciep = (EditText) findViewById(R.id.et_to);
        sub = "Cotizacón";
        msg = (EditText) findViewById(R.id.et_text);

        login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        rec = reciep.getText().toString();
        subject = sub.toString();
        textMessage = msg.getText().toString();

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("soporte.buildu@gmail.com", "bagner2104");
            }
        });

        pdialog = ProgressDialog.show(context, "", "Sending Mail...", true);

        RetreiveFeedTask task = new RetreiveFeedTask();
        task.execute();


    }

    class RetreiveFeedTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            try{
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("testfrom354@gmail.com"));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rec));
                message.setSubject(subject);
                message.setContent(textMessage, "text/html; charset=utf-8");
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
            reciep.setText("");
            msg.setText("");
           // sub = ("");
            Toast.makeText(getApplicationContext(), "Correo Enviado", Toast.LENGTH_LONG).show();
        }
    }

}
