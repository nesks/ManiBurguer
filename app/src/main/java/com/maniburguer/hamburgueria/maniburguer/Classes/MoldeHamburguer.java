package com.maniburguer.hamburgueria.maniburguer.Classes;

import java.util.ArrayList;

/**
 * Created by ind on 27/12/2017.
 */
public class MoldeHamburguer {

    private static Ingrediente pao;
    private static ArrayList<Ingrediente> carne = new ArrayList<Ingrediente>();
    private static ArrayList<Ingrediente> salada= new ArrayList<Ingrediente>();
    private static ArrayList<Ingrediente> acrescimos= new ArrayList<Ingrediente>();
    private static ArrayList<Ingrediente> molhos= new ArrayList<Ingrediente>();
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


    public static  void adicionarCarne(Ingrediente x){
        carne.add(x);
        preco += x.getPreco();
    }
    public  static void removeCarne(Ingrediente x){
        carne.remove(x);
        preco -= x.getPreco();
    }

    public  static void adicionarSalada(Ingrediente x){
        salada.add(x);
        preco += x.getPreco();
    }
    public static  void removeSalada(Ingrediente x){
        salada.remove(x);
        preco -= x.getPreco();
    }
    public static  void adicionarAcrescimos(Ingrediente x){
        acrescimos.add(x);
        preco += x.getPreco();
    }
    public  static void removeAcrescimos(Ingrediente x){
        acrescimos.remove(x);
        preco -= x.getPreco();
    }
    public  static void adicionarMolho(Ingrediente x){
        molhos.add(x);
        preco += x.getPreco();
    }
    public  static void removeMolho(Ingrediente x){
        molhos.remove(x);
        preco -= x.getPreco();
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

    public  static void setPreco(Double p) {
        preco = p;
    }
}
