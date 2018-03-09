package com.maniburguer.hamburgueria.maniburguer.Classes;

import java.util.ArrayList;

public class Hamburguer {

        private  Ingrediente pao;
        private  ArrayList<Ingrediente> carne = new ArrayList<>();
         private  ArrayList<Ingrediente> queijo = new ArrayList<>();
        private  ArrayList<Ingrediente> salada= new ArrayList<>();
        private  ArrayList<Ingrediente> acrescimos= new ArrayList<>();
        private  ArrayList<Ingrediente> molhos= new ArrayList<>();
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




}
