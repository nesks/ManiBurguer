package com.maniburguer.hamburgueria.maniburguer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.maniburguer.hamburgueria.maniburguer.Classes.MoldeHamburguer;
import com.maniburguer.hamburgueria.maniburguer.Classes.Pedido;
import com.maniburguer.hamburgueria.maniburguer.Classes.Usuario;

import java.util.Arrays;

public class LogInActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {


    //google
    private GoogleApiClient googleApiClient;
    private ProgressBar progressBar;
    //facebook
    private CallbackManager mCallbackManager;
    private static final String TAG = "FACELOG";
    //firebase
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;
    //botoes
    private Button btnFacebook;
    private Button btnGoogle;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso )
                .build();

        //Menu botoes
        btnFacebook = (Button) findViewById(R.id.BTNfacebook);
        btnGoogle = (Button) findViewById(R.id.BTNgoogle);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        texto = (TextView) findViewById(R.id.textView);

        // Initialize Facebook Login button
        mCallbackManager = CallbackManager.Factory.create();

        btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ligaProcess();
                LoginManager.getInstance().logInWithReadPermissions(LogInActivity.this, Arrays.asList("email", "public_profile"));
                LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.d(TAG, "facebook:onSuccess:" + loginResult);
                        handleFacebookAccessToken(loginResult.getAccessToken());

                    }

                    @Override
                    public void onCancel() {
                        Log.d(TAG, "facebook:onCancel");
                        Toast.makeText(LogInActivity.this,"Cancelado", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(FacebookException error) {
                        Log.d(TAG, "facebook:onError", error);
                        Toast.makeText(LogInActivity.this, "Erro ao efetuar o login, verifique sua conexão", Toast.LENGTH_SHORT).show();
                        desligaProcess();
                    }
                });
            }
        });




        //botao do google
        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(intent, 777);
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!= null){
                    updateUI();
                }
            }
        };



    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(firebaseAuthListener);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 777 ){
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
        mCallbackManager.onActivityResult(requestCode, resultCode, data);

    }

    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            updateUI();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(LogInActivity.this,"Falha ao logar pelo facebook.",Toast.LENGTH_SHORT).show();

                            desligaProcess();
                        }

                        // ...
                    }
                });
    }

    private void updateUI() {
        Toast.makeText(this, "Logado com sucesso", Toast.LENGTH_SHORT).show();
        Pedido y = new Pedido();
        Usuario.setPedido(y);
        goMainScreen();
        finish();
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if(result.isSuccess()){

            firebaseAuthWithGoogle(result.getSignInAccount());

        }else{
            Toast.makeText(this, "Erro ao efetuar o login, verifique sua conexão", Toast.LENGTH_SHORT).show();
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount signInAccount) {

            ligaProcess();
        progressBar.setVisibility(View.VISIBLE);

        AuthCredential credencial = GoogleAuthProvider.getCredential(signInAccount.getIdToken(), null );
        firebaseAuth.signInWithCredential(credencial).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                desligaProcess();
                progressBar.setVisibility(View.GONE);

                if(!task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Erro com autenticação", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void goMainScreen() {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(firebaseAuthListener!=null){
            firebaseAuth.removeAuthStateListener(firebaseAuthListener);
        }
    }

    private void ligaProcess(){
        btnFacebook.setVisibility(View.GONE);
        btnGoogle.setVisibility(View.GONE);
        texto.setVisibility(View.GONE);

    }

    private void desligaProcess(){
        btnFacebook.setVisibility(View.VISIBLE);
        btnGoogle.setVisibility(View.VISIBLE);
        texto.setVisibility(View.VISIBLE);

    }

}





