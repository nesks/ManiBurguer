package com.maniburguer.hamburgueria.maniburguer.Classes;

import java.util.ArrayList;


public class MoldeHamburguer {

    private static Ingrediente pao;
    private static ArrayList<Ingrediente> carne = new ArrayList<>();
    private static  ArrayList<Ingrediente> queijo = new ArrayList<>();
    private static ArrayList<Ingrediente> salada= new ArrayList<>();
    private static ArrayList<Ingrediente> acrescimos= new ArrayList<>();
    private static ArrayList<Ingrediente> molhos= new ArrayList<>();
    private static Double preco;


    public MoldeHamburguer(){
        preco=0.0;
    }

    public static void adicionarPao(Ingrediente x){

        pao = x;
        preco += x.getPreco();
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

    public  static void setCarne(ArrayList<Ingrediente> c) {
       carne = c;
    }

    public static ArrayList<Ingrediente> getQueijo() {
        return queijo;
    }

    public void setQueijo(ArrayList<Ingrediente> queijo) {
        this.queijo = queijo;
    }



    public static  ArrayList<Ingrediente> getSalada() {
        return salada;
    }

    public  static void setSalada(ArrayList<Ingrediente> s) {
        salada = s;
    }

    public  static ArrayList<Ingrediente> getAcrescimos() {
        return acrescimos;
    }

    public  static void setAcrescimos(ArrayList<Ingrediente> a) {
        acrescimos = a;
    }

    public  static ArrayList<Ingrediente> getMolhos() {
        return molhos;
    }

    public  static void setMolhos(ArrayList<Ingrediente> m) {
        molhos = m;
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
