package com.maniburguer.hamburgueria.maniburguer.Classes;

/**
 * Created by ind on 28/12/2017.
 */
public class Ingrediente {

    private String nome;
    private Double preco;
    private String image;

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Ingrediente(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
       // this.image = image;
    }


    @Override
    public String toString() {
        return String.format("%-35s %10s", nome, preco);
    }
}
