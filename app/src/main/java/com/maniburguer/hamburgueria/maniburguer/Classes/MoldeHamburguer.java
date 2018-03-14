package com.maniburguer.hamburgueria.maniburguer.Classes;

import android.util.Log;
import android.widget.Switch;

import java.util.ArrayList;


public class MoldeHamburguer {

    private static String nome;

    private static Ingrediente pao;
    private static ArrayList<Ingrediente> carne = new ArrayList<>();
    private static  ArrayList<Ingrediente> queijo = new ArrayList<>();
    private static ArrayList<Ingrediente> salada= new ArrayList<>();
    private static ArrayList<Ingrediente> acrescimos= new ArrayList<>();
    private static ArrayList<Ingrediente> molhos= new ArrayList<>();
    private static Double preco;


    public static void adicionarIngrediente(ArrayList<Ingrediente> x , Ingrediente y){
        Log.i("EJOR","entrou no adicionarIngrediente com o ingrediente "+ y.getNome());
        if(x==getCarne()) {
            Log.i("EJOR","entrou no getCarne() e foi add "+ y.getNome());
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
        pao = null;
        carne.clear();
        salada.clear();
        acrescimos.clear();
        molhos.clear();
        preco = 0.0;
    }

    public  static Ingrediente getPao() {
        return pao;
    }

    public  static void setPao(Ingrediente po) {
        pao = po;
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
