package com.maniburguer.hamburgueria.maniburguer.Classes;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by indigente on 14/03/2018.
 */
public class EnviarCarrinho {


    //firebase
    private static DatabaseReference databaseReferencia = FirebaseDatabase.getInstance().getReference();
    private static DatabaseReference pedidoReferencia = databaseReferencia.child("pedidos");

    private static DatabaseReference nomeUsuarioReferencia = pedidoReferencia.child(Usuario.getNome());

    public static void enviarHamburguers(){
        Log.i("carrinho", "enviado");
        for(int i=0; i<Usuario.getCarrinho().size();i++){
            nomeUsuarioReferencia.child(Usuario.getCarrinho().get(i).getDados().getNomeDoHamburguer()).setValue(Usuario.getCarrinho().get(i));
        }

    }

}
