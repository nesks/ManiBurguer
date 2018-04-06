package com.maniburguer.hamburgueria.maniburguer.Util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.maniburguer.hamburgueria.maniburguer.CarrinhoActivity;
import com.maniburguer.hamburgueria.maniburguer.Classes.MoldeHamburguer;
import com.maniburguer.hamburgueria.maniburguer.Classes.Usuario;
import com.maniburguer.hamburgueria.maniburguer.FechadosActivity;
import com.maniburguer.hamburgueria.maniburguer.LogInActivity;
import com.maniburguer.hamburgueria.maniburguer.Main2Activity;
import com.maniburguer.hamburgueria.maniburguer.R;

/**
 * Created by ind on 08/01/2018.
 */
public class TestesIniciais {


    private static String status = "online";
    private static TextView preco;



    //Firebase
    private static DatabaseReference databaseReferencia = FirebaseDatabase.getInstance().getReference();
    private static DatabaseReference statusReferencia = databaseReferencia.child("status");
    private static FirebaseAuth firebaseAuth;
    private static FirebaseAuth.AuthStateListener firebaseAuthListener;
    private static Usuario usuario;

    private static final String TAG ="ERRO:" ;



    public static void verificaStatus(final Context x){
        //verifica se esta fechado ou aberto
        statusReferencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                status = dataSnapshot.getValue().toString();
                if(!status.equals("online")){
                    goFechadosScreen(x);
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "erro ao conectar com database, verificacao de status");
            }
        });
    }


    private static void onStart() {
        firebaseAuth.addAuthStateListener(firebaseAuthListener);
    }

    private static void onStop() {
        if(firebaseAuthListener!=null){
            firebaseAuth.removeAuthStateListener(firebaseAuthListener);
        }
    }


    public static void verificaAuth(Context c){

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user!=null){
            setUserData(user);
        }
    }


    private static void setUserData(FirebaseUser user) {
        String nome = user.getDisplayName();
        String email = user.getEmail();
        Uri photourl = user.getPhotoUrl();
        String id = user.getUid();
        usuario = new Usuario(nome, email, photourl, id);
    }



    public static void sair(Context x) {
        firebaseAuth.signOut();
        goLogInScreen(x);
    }

    public static void goCarrinhoScreen(Context c) {
        Intent intent = new Intent(c, CarrinhoActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        c.startActivity(intent);
    }


    public static void goFechadosScreen(Context c) {
        Intent intent = new Intent(c, FechadosActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        c.startActivity(intent);
    }


    public static void goLogInScreen(Context c) {
        Intent intent = new Intent(c, LogInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        c.startActivity(intent);
    }

    public static void goMainScreen(Context c) {
        Intent intent = new Intent(c, Main2Activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        c.startActivity(intent);
    }

    public static void inicializaPreco(View v){
        preco = (TextView)v.findViewById(R.id.precoTotal);
    }



    public static void atualizaPreco(){
        preco.setText("R$ "+String.valueOf(MoldeHamburguer.getPreco())+"0");
    }

}
