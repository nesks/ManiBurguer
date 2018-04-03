package com.maniburguer.hamburgueria.maniburguer;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maniburguer.hamburgueria.maniburguer.Classes.Usuario;
import com.maniburguer.hamburgueria.maniburguer.Util.TestesIniciais;

import de.hdodenhof.circleimageview.CircleImageView;

public class ToolbarMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    private TextView tvnome;
    private TextView tvemail;
    private CircleImageView ivfoto;



    public void iniciar(){

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.carrinho, menu);
        //coloca a imagem

        tvnome = (TextView) findViewById(R.id.TVnome);
        tvemail = (TextView) findViewById(R.id.TVemail);
        ivfoto = (CircleImageView) findViewById(R.id.IVfoto);
        tvnome.setText(Usuario.getNome());
        tvemail.setText(Usuario.getEmail());
        Glide.with(this).load(Usuario.getPhotoURL()).into(ivfoto);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.carrinho) {
            if(Usuario.getPedido()!=null&&!Usuario.getPedido().getHamburguers().isEmpty()) {
                TestesIniciais.goCarrinhoScreen(this);
            }else{
                alerta();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_historico) {

        } else if (id == R.id.nav_pagina_inicial) {
            TestesIniciais.goMainScreen(this);
        } else if (id == R.id.nav_sair) {
            TestesIniciais.sair(this);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void alerta() {
        new AlertDialog.Builder(this).setTitle("Carrinho").setMessage("Carrinho vazio").show();
    }
}
