package com.maniburguer.hamburgueria.maniburguer.Classes;

import android.net.Uri;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by ind on 27/12/2017.
 */
public class Usuario {


    //firebase
    private static DatabaseReference databaseReferencia = FirebaseDatabase.getInstance().getReference();
    private static DatabaseReference idReferencia = databaseReferencia.child("pedidos").child("date");
    private DatabaseReference nomeDoHamburguerReferencia;


    private static String nome;
    private static String email;
    private static Uri photoURL;
    private static String id;
    private static Endereco endereco;


    private static ArrayList<Hamburguer> carrinho = new ArrayList<Hamburguer>();

    public Usuario(String nome, String email, Uri photoURL, String id) {
        this.nome = nome;
        this.email = email;
        this.photoURL = photoURL;
        this.id = id;
    }

    public static String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Uri getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(Uri photoURL) {
        this.photoURL = photoURL;
    }

    public static String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public static ArrayList<Hamburguer> getCarrinho() {
        return carrinho;
    }

    public void removeHamburguer(Hamburguer hamb){
        carrinho.remove(hamb);
    }

    public static void addHamburguer(Hamburguer hamb){
        carrinho.add(hamb);
        Log.d("FRAGMENT", "adicionarHamburguer: "+carrinho.size());
    }

    public static void enviarHamburguers(){
        idReferencia = idReferencia.child(nome);
        idReferencia.setValue(id);
        idReferencia.child("endereco").setValue(endereco);
        for(int i=0; i<carrinho.size();i++){
            idReferencia.child("Maniburguer"+(i+1)).setValue(carrinho.get(i));
        }

    }


}
