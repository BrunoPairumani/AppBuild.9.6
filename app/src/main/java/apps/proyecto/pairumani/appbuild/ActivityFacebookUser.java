package apps.proyecto.pairumani.appbuild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ActivityFacebookUser extends AppCompatActivity {


    private TextView nameTextView1;
    private TextView emailTextView1;
    private TextView uidTextView1;
    private ImageView photoUrl1;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this);
        setContentView(R.layout.activity_facebook_user);


        photoUrl1 = (ImageView) findViewById(R.id.photoUrl1);
        nameTextView1 = (TextView) findViewById(R.id.nameTextView1);
        emailTextView1 = (TextView) findViewById(R.id.emailTextView1);
        uidTextView1 = (TextView) findViewById(R.id.uidTextView1);

        FirebaseUser user2 = FirebaseAuth.getInstance().getCurrentUser();

        if (user2 != null) {

            setUserDataF(user2);


        } else {
            goLoginScreen2();
        }


    }

    private void setUserDataF(FirebaseUser user2) {

        nameTextView1.setText(user2.getDisplayName());
        emailTextView1.setText(user2.getEmail());
        uidTextView1.setText(user2.getUid());
        Glide.with(ActivityFacebookUser.this).load(user2.getPhotoUrl()).into(photoUrl1);
    }


    private void goLoginScreen2() {
        Intent intent = new Intent(ActivityFacebookUser.this, LogInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void logout1(View view) {
        FirebaseAuth.getInstance().signOut();
        LoginManager.getInstance().logOut();

        goLoginScreen2();

    }
}
