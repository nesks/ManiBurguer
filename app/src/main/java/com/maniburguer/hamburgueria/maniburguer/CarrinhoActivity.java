package com.maniburguer.hamburgueria.maniburguer;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.maniburguer.hamburgueria.maniburguer.Adapter.TabsAdapter;
import com.maniburguer.hamburgueria.maniburguer.Adapter.TabsAdapterPedido;
import com.maniburguer.hamburgueria.maniburguer.Classes.EnviarCarrinho;
import com.maniburguer.hamburgueria.maniburguer.Classes.Hamburguer;
import com.maniburguer.hamburgueria.maniburguer.Classes.Usuario;
import com.maniburguer.hamburgueria.maniburguer.Fragment.CarrinhoFragmentPedido;
import com.maniburguer.hamburgueria.maniburguer.Util.SlidingTabLayout;
import com.maniburguer.hamburgueria.maniburguer.Util.TestesIniciais;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CarrinhoActivity extends ToolbarMenu{



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

        iniciar();

        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.content_carrinho, null);
        LinearLayout foo = (LinearLayout)findViewById(R.id.layoutt);
        foo.addView(view);

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        CarrinhoFragmentPedido fragment = new CarrinhoFragmentPedido();
        fragmentTransaction.replace(R.id.fragment_exemplo, fragment);
        fragmentTransaction.commit();
        fragmentTransaction.addToBackStack(null);

     /*   //configurar abas
        slidingTabLayout  = (SlidingTabLayout) findViewById(R.id.stcarrinho);
        viewPager = (ViewPager) findViewById(R.id.vpcarrinho);

        //configurar adapter
        TabsAdapterPedido tabsAdapter = new TabsAdapterPedido(getSupportFragmentManager(), this );
        viewPager.setAdapter(tabsAdapter);
        slidingTabLayout.setCustomTabView(R.layout.tab_view, R.id.text_item_tab);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setSelectedIndicatorColors(ContextCompat.getColor(this,R.color.cinza));
        slidingTabLayout.setViewPager(viewPager);
        viewPager.setCurrentItem(2);
*/
    }







}
