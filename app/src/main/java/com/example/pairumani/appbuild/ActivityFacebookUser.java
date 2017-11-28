package com.example.pairumani.appbuild;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import java.io.InputStream;
import android.util.Log;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.squareup.picasso.Picasso;

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
