package com.maniburguer.hamburgueria.maniburguer.Classes;

import android.util.Log;
import android.widget.Switch;

import java.util.ArrayList;


public class MoldeHamburguer {

    private static  ArrayList<Ingrediente> pao = new ArrayList<>();
    private static ArrayList<Ingrediente> carne = new ArrayList<>();
    private static  ArrayList<Ingrediente> queijo = new ArrayList<>();
    private static ArrayList<Ingrediente> salada= new ArrayList<>();
    private static ArrayList<Ingrediente> acrescimos= new ArrayList<>();
    private static ArrayList<Ingrediente> molhos= new ArrayList<>();
    private static Double preco = 0.0;


    public static void adicionarIngrediente(ArrayList<Ingrediente> x , Ingrediente y){
        if(x==getPao()) {
            pao.add(y);
        }else if(x==getCarne()) {
            carne.add(y);
        }else if(x==getQueijo()){
            queijo.add(y);
        }else if(x==getSalada()){
            salada.add(y);
        }else if(x==getAcrescimos()){
            acrescimos.add(y);
        }else if(x==getMolhos()){
            molhos.add(y);
        }
    }

    public static void removerIngrediente(ArrayList<Ingrediente> x , Ingrediente y){
        x.remove(y);
    }

    public MoldeHamburguer(){
        preco=0.0;
    }

    public  static void apagaTudo(){
        pao.clear();
        carne.clear();
        salada.clear();
        acrescimos.clear();
        molhos.clear();
        queijo.clear();
        preco = 0.0;
    }

    public static ArrayList<Ingrediente> getPao() {
        return pao;
    }

    public static  ArrayList<Ingrediente> getCarne() {
        return carne;
    }

    public static ArrayList<Ingrediente> getQueijo() {
        return queijo;
    }

    public static  ArrayList<Ingrediente> getSalada() {
        return salada;
    }

    public  static ArrayList<Ingrediente> getAcrescimos() {
        return acrescimos;
    }

    public  static ArrayList<Ingrediente> getMolhos() {
        return molhos;
    }

    public  static Double getPreco() {

        return preco;
    }

    public  static void adicionaPreco(Double p) {
        preco += p;
    }
    public  static void removePreco(Double p) {
        preco -= p;
    }
}
