package com.maniburguer.hamburgueria.maniburguer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maniburguer.hamburgueria.maniburguer.Adapter.TabsAdapter;
import com.maniburguer.hamburgueria.maniburguer.Classes.Estoque;
import com.maniburguer.hamburgueria.maniburguer.Classes.MoldeHamburguer;
import com.maniburguer.hamburgueria.maniburguer.Classes.Usuario;
import com.maniburguer.hamburgueria.maniburguer.Util.SlidingTabLayout;
import com.maniburguer.hamburgueria.maniburguer.Util.TestesIniciais;

import junit.framework.Test;

import de.hdodenhof.circleimageview.CircleImageView;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //hamburguer estoque NAO DELETAR, DA ERRO
    private static Estoque tudoquetemos = new Estoque();

    private TextView tvnome;
    private TextView tvemail;
    private CircleImageView ivfoto;

    //abas
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Deleta o molde
        MoldeHamburguer.apagaTudo();

        //verifica se está aberto ou não
        TestesIniciais.verificaStatus(this);

        //verifica se está logado
        TestesIniciais.verificaAuth(this);

        //toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //configurar abas
        slidingTabLayout  = (SlidingTabLayout) findViewById(R.id.stmain);
        viewPager = (ViewPager) findViewById(R.id.vpmain);

        //configurar adapter
        TabsAdapter tabsAdapter = new TabsAdapter(getSupportFragmentManager(), this );
        viewPager.setAdapter(tabsAdapter);
        slidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.text_item_tab);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this,R.color.cinza));
        slidingTabLayout.setViewPager(viewPager);
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
            if(Usuario.getPedido()!=null&&(!Usuario.getPedido().getHamburguers().isEmpty())) {
                TestesIniciais.goCarrinhoScreen(this);
            }else{
                alerta();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_configuracao) {
            // Handle the camera action
        } else if (id == R.id.nav_compartilhar) {

        } else if (id == R.id.nav_enviar) {

        } else if (id == R.id.nav_sair) {
           TestesIniciais.sair(this);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void alerta(){
        new AlertDialog.Builder(this).setTitle("Carrinho")
                .setMessage("Carrinho vazio, não pode continuar.")
                .show();

    }
}