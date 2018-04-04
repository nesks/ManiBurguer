package com.maniburguer.hamburgueria.maniburguer.Classes;

import android.util.Log;

import java.util.ArrayList;

public class Hamburguer {

        private  ArrayList<Ingrediente> pao = new ArrayList<>();
        private  ArrayList<Ingrediente> carne = new ArrayList<Ingrediente>();
        private  ArrayList<Ingrediente> queijo = new ArrayList<Ingrediente>();
        private  ArrayList<Ingrediente> salada= new ArrayList<Ingrediente>();
        private  ArrayList<Ingrediente> acrescimos= new ArrayList<Ingrediente>();
        private  ArrayList<Ingrediente> molhos= new ArrayList<Ingrediente>();
        private DadosDoHamburguer dados;



    public Hamburguer(String nome, String nomeDoUsuario){
            dados = new DadosDoHamburguer(nome , MoldeHamburguer.getPreco(), nomeDoUsuario);
            pao.addAll(MoldeHamburguer.getPao());
            carne.addAll(MoldeHamburguer.getCarne());
            queijo.addAll(MoldeHamburguer.getQueijo());
            salada.addAll(MoldeHamburguer.getSalada());
            acrescimos.addAll(MoldeHamburguer.getAcrescimos());
            molhos.addAll(MoldeHamburguer.getMolhos());
            MoldeHamburguer.apagaTudo();
        }

    public ArrayList<Ingrediente> getPao() {
        return pao;
    }

    public   ArrayList<Ingrediente> getCarne() {
            return carne;
        }

    public DadosDoHamburguer getDados() {
        return dados;
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


}
