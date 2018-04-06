package com.maniburguer.hamburgueria.maniburguer.Classes;

import com.maniburguer.hamburgueria.maniburguer.R;

import java.util.ArrayList;

/**
 * Created by ind on 28/12/2017.
 */
public class Estoque {
    private static ArrayList<Ingrediente>  pao= new ArrayList<Ingrediente>();
    private static ArrayList<Ingrediente> carne = new ArrayList<Ingrediente>();
    private static ArrayList<Ingrediente> salada = new ArrayList<Ingrediente>();
    private static ArrayList<Ingrediente> queijo = new ArrayList<Ingrediente>();
    private static ArrayList<Ingrediente> acrescimos= new ArrayList<Ingrediente>();
    private static ArrayList<Ingrediente> molhos = new ArrayList<Ingrediente>();


    public Estoque(){
        //pao
        pao.add(new Ingrediente("Pão com gergelim", 0.3, R.drawable.sandwich));
        pao.add(new Ingrediente("Pão comum", 0.3, R.drawable.sandwich));
        //carne
        carne.add(new Ingrediente("Carne bovina artesanal 100g",3.0, R.drawable.sandwich));
        carne.add(new Ingrediente("Carne bovina artesanal 150g",4.0, R.drawable.sandwich));
        carne.add(new Ingrediente("Carne bovina artesanal 200g",5.0, R.drawable.sandwich));
        carne.add(new Ingrediente("Carne bovina artesanal 250g",6.0, R.drawable.sandwich));
        carne.add(new Ingrediente("Carne suina artesanal 100g",2.50, R.drawable.sandwich));
        carne.add(new Ingrediente("Carne suina artesanal 150g",3.50, R.drawable.sandwich));
        carne.add(new Ingrediente("Carne suina artesanal 200g",4.50, R.drawable.sandwich));
        carne.add(new Ingrediente("Carne frango artesanal 100g",2.00, R.drawable.sandwich));
        carne.add(new Ingrediente("Carne frango artesanal 150g",3.00, R.drawable.sandwich));
        carne.add(new Ingrediente("Carne frango artesanal 200g",4.00, R.drawable.sandwich));
        carne.add(new Ingrediente("Carne frango comum 90g",1.50, R.drawable.sandwich));
        carne.add(new Ingrediente("Carne bovina comum 90g",1.50, R.drawable.sandwich));
        //salada
        salada.add(new Ingrediente("Cebola caramelizada",0.50, R.drawable.sandwich));
        salada.add(new Ingrediente("Cebola comum",0.0, R.drawable.sandwich));
        salada.add(new Ingrediente("Pimentão",0.0, R.drawable.sandwich));
        salada.add(new Ingrediente("Picles",0.0, R.drawable.sandwich));
        salada.add(new Ingrediente("Alface",0.0, R.drawable.sandwich));
        salada.add(new Ingrediente("Tomate",0.0, R.drawable.sandwich));
        salada.add(new Ingrediente("Tomate Seco",0.0, R.drawable.sandwich));
        salada.add(new Ingrediente("Milho",0.0, R.drawable.sandwich));
        //queijos
        queijo.add(new Ingrediente("Queijo Mussarela",0.0, R.drawable.sandwich));
        queijo.add(new Ingrediente("Queijo Prato",0.0, R.drawable.sandwich));
        queijo.add(new Ingrediente("Cheedar",0.0, R.drawable.sandwich));
        queijo.add(new Ingrediente("Catupiry",0.0, R.drawable.sandwich));
        queijo.add(new Ingrediente("Cream Chease",0.0, R.drawable.sandwich));
        //acrescimos
        acrescimos.add(new Ingrediente("ovo",0.0, R.drawable.sandwich));
        acrescimos.add(new Ingrediente("presunto",0.0, R.drawable.sandwich));
        acrescimos.add(new Ingrediente("calabresa",0.0, R.drawable.sandwich));
        acrescimos.add(new Ingrediente("bacon",0.0, R.drawable.sandwich));
        acrescimos.add(new Ingrediente("batata palha",0.0, R.drawable.sandwich));
        //molhos
        molhos.add(new Ingrediente("Molho do BigMac",0.0, R.drawable.sandwich));
        molhos.add(new Ingrediente("Molho do BigTasty",0.0, R.drawable.sandwich));
        molhos.add(new Ingrediente("Maionese Temperada",0.0, R.drawable.sandwich));
        molhos.add(new Ingrediente("Molho Barbecue",0.0, R.drawable.sandwich));
        molhos.add(new Ingrediente("Molho Picante",0.0, R.drawable.sandwich));
        molhos.add(new Ingrediente("Maionese de bacon",0.0, R.drawable.sandwich));
    }

    public static ArrayList<Ingrediente> getPao() {
        return pao;
    }

    public static ArrayList<Ingrediente> getCarne() {
        return carne;
    }

    public static ArrayList<Ingrediente> getSalada() {
        return salada;
    }

    public static ArrayList<Ingrediente> getQueijo() {
        return queijo;
    }

    public static ArrayList<Ingrediente> getAcrescimos() {
        return acrescimos;
    }

    public static ArrayList<Ingrediente> getMolhos() {
        return molhos;
    }
}
