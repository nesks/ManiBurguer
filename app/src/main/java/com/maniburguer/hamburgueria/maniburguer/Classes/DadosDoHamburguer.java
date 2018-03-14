package com.maniburguer.hamburgueria.maniburguer.Classes;

/**
 * Created by indigente on 14/03/2018.
 */
public class DadosDoHamburguer {

    private String nomeDoHamburguer;
    private Double precoDoHamburguer;
    private Endereco endereco;
    private String nomeDoUsuario;

    public DadosDoHamburguer(){}

    public DadosDoHamburguer(String nomeDoHamburguer, Double precoDoHamburguer, String nomeDoUsuario) {
        this.nomeDoHamburguer = nomeDoHamburguer;
        this.precoDoHamburguer = precoDoHamburguer;
        this.endereco = new Endereco();
        this.nomeDoUsuario = nomeDoUsuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNomeDoUsuario() {
        return nomeDoUsuario;
    }

    public String getNomeDoHamburguer() {
        return nomeDoHamburguer;
    }

    public Double getPrecoDoHamburguer() {
        return precoDoHamburguer;
    }
}
