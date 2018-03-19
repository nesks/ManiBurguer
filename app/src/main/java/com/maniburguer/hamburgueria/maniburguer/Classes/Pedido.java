package com.maniburguer.hamburgueria.maniburguer.Classes;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by indigente on 15/03/2018.
 */
public class Pedido {

    private Double precoGeral;
    private ArrayList<Hamburguer> hamburguers = new ArrayList<>();
    private ArrayList<Acompanhamento> acompanhamentos = new ArrayList<>();

    public Pedido() {
        precoGeral = 0.0;
    }

    public void addHamburguer(Hamburguer hamb) {
        hamburguers.add(hamb);
        Log.d("FRAGMENT", "adicionarHamburguer: " + hamburguers.size());
    }


    public Double getPrecoGeral() {
        return precoGeral;
    }

    public ArrayList<Hamburguer> getHamburguers() {
        return hamburguers;
    }

    public void removeHamburguer(int i){
        hamburguers.remove(i);
        atualizarPrecoGeral();
    }


    public ArrayList<Acompanhamento> getAcompanhamentos() {
        return acompanhamentos;
    }

    public void atualizarPrecoGeral() {
        int i;
        precoGeral = 0.0;
        for (i = 0; i < hamburguers.size(); i++) {
            precoGeral += hamburguers.get(i).getDados().getPrecoDoHamburguer();
        }



    }
}
