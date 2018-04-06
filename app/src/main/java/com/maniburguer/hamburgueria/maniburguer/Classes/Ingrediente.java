package com.maniburguer.hamburgueria.maniburguer.Classes;

import com.maniburguer.hamburgueria.maniburguer.R;

/**
 * Created by ind on 28/12/2017.
 */
public class Ingrediente {

    private String nome;
    private Double preco;
    private int image;

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public int getImage() {
        return image;
    }

    public Ingrediente(String nome, Double preco, int image) {
        this.nome = nome;
        this.preco = preco;
        this.image = image;
    }


    @Override
    public String toString() {
        return String.format("%-35s %10s", nome, preco);
    }
}
