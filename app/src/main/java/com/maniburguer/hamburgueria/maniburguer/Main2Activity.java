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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
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

public class Main2Activity extends ToolbarMenu {

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


        iniciar();


        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.content_main2, null);
        LinearLayout foo = (LinearLayout)findViewById(R.id.layoutt);
        foo.addView(view);

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

}