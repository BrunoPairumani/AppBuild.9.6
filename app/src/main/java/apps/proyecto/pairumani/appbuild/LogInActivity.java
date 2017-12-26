package apps.proyecto.pairumani.appbuild;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;

import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.auth.GoogleAuthProvider;

import java.util.Arrays;

import apps.proyecto.pairumani.appbuild.Dialog.RadierDialog;
import apps.proyecto.pairumani.appbuild.Dialog.SobreDialog;


public class LogInActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    // inciar Google

    private GoogleApiClient googleApiClient;
    //Iniciar button Google
    private SignInButton signInButton;

    private ProgressBar progressBar;
    
    public ProgressBar progressBar2;
public int x;
    //GOOGLE

    private FirebaseAuth firebaseAuth2;
    private FirebaseAuth.AuthStateListener firebaseAuthListener2;

    
    //FACEBOOK
    public LoginButton loginButton;
    public CallbackManager mCallbackManager;
    public FirebaseAuth mAuth;
    public FirebaseAuth.AuthStateListener mAuthListener;
    
        //codigo de aprobación para google
    public static final int SIGN_IN_CODE = 9001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this);
        setContentView(R.layout.activity_log_in);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
// iNICIA LOS 2 METODOS DE ACUERDO A LA SOLICITUD DEL USUARIO
        InicioGoogle();
        InicioFacebook();
        
    }
// METODO FACEBOOK


    public void InicioFacebook() {




        mCallbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton) findViewById(R.id.loginButton);

        loginButton.setReadPermissions(Arrays.asList("email"));

        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            //SI EL LOGEO ES CORRECTO APRUEBA EL TOKEN GENERADO POR FIREBASE - DESARROLLADORES DE FACEBOOK
            public void onSuccess(LoginResult loginResult) {
                handleFacebookAccessToken(loginResult.getAccessToken());
                x=0;
            }

            @Override
            public void onCancel() {
                //LANZA ERROR DE LA OPERACIÓN
                Toast.makeText(getApplicationContext(), R.string.cancel_login, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(FacebookException error) {
                //ERROR DE ENLACE CONEXION
                Toast.makeText(getApplicationContext(), R.string.error_login, Toast.LENGTH_SHORT).show();
            }
        });

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                x=0;
                FirebaseUser user2 = firebaseAuth.getCurrentUser();
                if (user2 != null) {

                    //SI ES CORRECTO MANDA AL METODO GO MAINSCREEN
                    goMainScreen();
                }
            }
        };
        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
    }

    private void goMainScreen2() {
        Intent i = new Intent(this, ActivityFacebookUser.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }


// METODO DE LAS CREDENCIALES DE FACEBOOK
    private void handleFacebookAccessToken(AccessToken accessToken) {
        progressBar2.setVisibility(View.VISIBLE);
        loginButton.setVisibility(View.GONE);

        AuthCredential credential2 = FacebookAuthProvider.getCredential(accessToken.getToken());
        mAuth.signInWithCredential(credential2).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "No se pudo Iniciar Sesión con Facebook  FIREBASE", Toast.LENGTH_LONG).show();
                }
                progressBar2.setVisibility(View.GONE);
                loginButton.setVisibility(View.VISIBLE);
            }
        });
    }







    // FIN METODO FACEBOOK
// login GOOGLE
    private void InicioGoogle() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        signInButton = (SignInButton) findViewById(R.id.signInButton);

        signInButton.setSize(SignInButton.SIZE_WIDE);

        signInButton.setColorScheme(SignInButton.COLOR_DARK);

        signInButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent, SIGN_IN_CODE);
            }
        });


        firebaseAuth2 = FirebaseAuth.getInstance();
        firebaseAuthListener2 = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {
// MANDA AL METODO PARA MOSTRAR EL SEGUNDO ACTIVITY
                    goMainScreen();
                }
            }
        };

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //FACEBOOK
        mAuth.addAuthStateListener(mAuthListener);
        //GOOGLE
        firebaseAuth2.addAuthStateListener(firebaseAuthListener2);

        //INICIAL LOS FIREBASE
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode,resultCode, data);

        if (requestCode == SIGN_IN_CODE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            firebaseAuthWithGoogle(result.getSignInAccount());
            // CORRECTO LOGEO DE GOOGLE
            x=1;
        } else {
            Toast.makeText(this, R.string.not_log_in, Toast.LENGTH_SHORT).show();
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount signInAccount) {

        progressBar.setVisibility(View.VISIBLE);
        signInButton.setVisibility(View.GONE);

        AuthCredential credential = GoogleAuthProvider.getCredential(signInAccount.getIdToken(), null);
        firebaseAuth2.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
//REVISA CREDENCIALES CORRECTAS
                progressBar.setVisibility(View.GONE);
                signInButton.setVisibility(View.VISIBLE);

                if (!task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), R.string.not_firebase_auth, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void goMainScreen() {



        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }




    @Override
    protected void onStop() {
        super.onStop();
        // DETIENEN LOS METODOS  FINALIZA
        //FACEBOOK
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
        //GOOGLE
        if (firebaseAuthListener2 != null) {
            firebaseAuth2.removeAuthStateListener(firebaseAuthListener2);
        }
    }


    public void nexthome(View view) {

        Intent intent = new Intent(this, HomeActivity.class);

        startActivity(intent);
    }

    public void Aboutis(View view) {

        FragmentManager manager11 = getFragmentManager();
        SobreDialog myDialog11 = new SobreDialog();

        myDialog11.show(manager11, "SobreDialog");
    }





    }





