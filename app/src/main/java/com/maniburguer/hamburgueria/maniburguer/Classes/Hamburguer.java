package com.maniburguer.hamburgueria.maniburguer.Classes;

import java.util.ArrayList;

/**
 * Created by ind on 08/01/2018.
 */
public class Hamburguer {

        private  Ingrediente pao;
        private  ArrayList<Ingrediente> carne = new ArrayList<Ingrediente>();
        private  ArrayList<Ingrediente> salada= new ArrayList<Ingrediente>();
        private  ArrayList<Ingrediente> acrescimos= new ArrayList<Ingrediente>();
        private  ArrayList<Ingrediente> molhos= new ArrayList<Ingrediente>();
        private  Double preco;


        public Hamburguer(){
            pao = MoldeHamburguer.getPao();
            carne = MoldeHamburguer.getCarne();
            salada = MoldeHamburguer.getSalada();
            acrescimos = MoldeHamburguer.getAcrescimos();
            molhos = MoldeHamburguer.getMolhos();
            preco = MoldeHamburguer.getPreco();
        }

        public   Ingrediente getPao() {
            return pao;
        }

        public   ArrayList<String> getCarne() {
            ArrayList<String> carnes = new ArrayList<>();
            for(int x=0;x<carne.size();x++)
                carnes.add(carne.get(x).getNome());
            return carnes;
        }

       public   ArrayList<Ingrediente> getSalada() {
            return salada;
        }

        public   ArrayList<Ingrediente> getAcrescimos() {
            return acrescimos;
        }

        public   ArrayList<Ingrediente> getMolhos() {
            return molhos;
        }

        public   Double getPreco() {
            return preco;
        }

    @Override
    public String toString() {
        return "Hamburguer\n" +
                String.format("  %-15s","pão:"+ pao.toString()) +
                String.format("\n %-15s","carne:"+ pegaAsString(carne)) +
                String.format("\n %-15s","salada:"+pegaAsString(salada)) +
                String.format(" \n %-15s","acrescimos:"+pegaAsString(acrescimos)) +
                String.format(" \n %-15s","molhos:"+pegaAsString(molhos)) +
                String.format("\n %50s %10s","preço:", preco);

    }

    private String pegaAsString(ArrayList<Ingrediente> a){
        String x ="";
        if(a.size()>0){
            x+="\n";
            x+=a.get(0).toString();
              for(int i = 1; i<a.size(); i++){
                  x+="\n";
                  x+=String.format("%15s","",a.get(i).toString());
              }}else{
            x=String.format("%45s","Não selecionou nada!");
        }
        return x;
    }

}
