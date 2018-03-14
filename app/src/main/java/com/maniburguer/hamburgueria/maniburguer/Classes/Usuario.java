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

    private static String nome;
    private static String email;
    private static Uri photoURL;
    private static String id;
    private static Endereco endereco;
    private static ArrayList<Hamburguer> carrinho = new ArrayList<Hamburguer>();
    private static Double precoGeral;

    public Usuario(){

    }

    public void atualizarPrecoGeral(){
        int i;
        for(i=0;i<carrinho.size();i++){
            precoGeral += carrinho.get(i).getDados().getPrecoDoHamburguer();
        }

    }

    public Usuario(String nome, String email, Uri photoURL, String id) {
        this.nome = nome;
        this.email = email;
        this.photoURL = photoURL;
        this.id = id;
    }

    public static String getNome() {
        return nome;
    }

    public static String getEmail() {
        return email;
    }

    public static Uri getPhotoURL() {
        return photoURL;
    }

    public static String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static ArrayList<Hamburguer> getCarrinho() {
        return carrinho;
    }

    public static Double getPrecoGeral() {
        return precoGeral;
    }

    public static Endereco getEndereco() {
        return endereco;
    }

    public static void addHamburguer(Hamburguer hamb){
        carrinho.add(hamb);
        Log.d("FRAGMENT", "adicionarHamburguer: "+carrinho.size());
    }




}
