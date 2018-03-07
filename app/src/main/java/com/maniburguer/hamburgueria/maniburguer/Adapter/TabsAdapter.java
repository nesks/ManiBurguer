package com.maniburguer.hamburgueria.maniburguer.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.maniburguer.hamburgueria.maniburguer.Classes.MoldeHamburguer;
import com.maniburguer.hamburgueria.maniburguer.Fragment.CarneFragment;
import com.maniburguer.hamburgueria.maniburguer.Fragment.PaoFragment;
import com.maniburguer.hamburgueria.maniburguer.Fragment.QueijoFragment;

/**
 * Created by ind on 07/01/2018.
 */
public class TabsAdapter extends FragmentStatePagerAdapter {
private Context context;
    private String[] abas = new String[]{"PÃO","CARNE","QUEIJO"};
    private MoldeHamburguer moldeHamburguer = new MoldeHamburguer();

    private Fragment paoFragment = new PaoFragment();
    private Fragment carneFragment = new CarneFragment();
    private Fragment queijoFraqment = new QueijoFragment();



    public TabsAdapter(FragmentManager fm, Context c) {
        super(fm);
        this.context = c;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position){
            case 0 :
                fragment = paoFragment;
                break;
            case 1 :
                fragment = carneFragment;
                break;
            case 2:
                fragment = queijoFraqment;
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
