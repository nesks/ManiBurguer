package com.maniburguer.hamburgueria.maniburguer.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.maniburguer.hamburgueria.maniburguer.Classes.MoldeHamburguer;
import com.maniburguer.hamburgueria.maniburguer.Fragment.CarrinhoFragmentPedido;
import com.maniburguer.hamburgueria.maniburguer.Fragment.EnderecoFragmentPedido;
import com.maniburguer.hamburgueria.maniburguer.Fragment.PagamentoFragmentPedido;

/**
 * Created by ind on 07/01/2018.
 */
public class TabsAdapterPedido extends FragmentStatePagerAdapter {
    private Context context;
    private String[] abas = new String[]{"CARRINHO","ENDEREÇO","PAGAMENTO"};
    private MoldeHamburguer moldeHamburguer = new MoldeHamburguer();


    private Fragment carrinhoFragment = new CarrinhoFragmentPedido();
    private Fragment enderecoFragment = new EnderecoFragmentPedido();
    private Fragment pagamentoFragment = new PagamentoFragmentPedido();


    public TabsAdapterPedido(FragmentManager fm, Context c) {
        super(fm);
        this.context = c;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position){
            case 0 :
                fragment = carrinhoFragment;
                break;
            case 1 :
                fragment = enderecoFragment;
                break;
            case 2:
                fragment = pagamentoFragment;
                break;
        }

        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return abas[position];
    }

    @Override
    public int getCount() {
        return abas.length;
    }
}
