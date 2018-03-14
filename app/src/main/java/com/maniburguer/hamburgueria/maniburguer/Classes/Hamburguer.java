package com.maniburguer.hamburgueria.maniburguer.Classes;

import android.util.Log;

import java.util.ArrayList;

public class Hamburguer {

        private String nome;
        private  Ingrediente pao;
        private  ArrayList<Ingrediente> carne = new ArrayList<Ingrediente>();
        private  ArrayList<Ingrediente> queijo = new ArrayList<Ingrediente>();
        private  ArrayList<Ingrediente> salada= new ArrayList<Ingrediente>();
        private  ArrayList<Ingrediente> acrescimos= new ArrayList<Ingrediente>();
        private  ArrayList<Ingrediente> molhos= new ArrayList<Ingrediente>();
        private  Double preco;

    public Hamburguer() {
    }

    public Hamburguer(String nome){
            this.nome = nome;
            pao = MoldeHamburguer.getPao();
            this.carne.addAll(MoldeHamburguer.getCarne());
            queijo.addAll(MoldeHamburguer.getQueijo());
            salada.addAll(MoldeHamburguer.getSalada());
            acrescimos.addAll(MoldeHamburguer.getAcrescimos());
            molhos.addAll(MoldeHamburguer.getMolhos());
            preco = MoldeHamburguer.getPreco();
            MoldeHamburguer.apagaTudo();
        }

        public   Ingrediente getPao() {
            return pao;
        }

        public   ArrayList<Ingrediente> getCarne() {
            return carne;
        }

            public String getNome() {
                return nome;
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

    public ArrayList<Ingrediente> getQueijo() {
        return queijo;
    }

    public   Double getPreco() {
            return preco;
        }

}
