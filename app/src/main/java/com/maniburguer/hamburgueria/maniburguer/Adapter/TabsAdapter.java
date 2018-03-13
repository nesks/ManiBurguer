package com.maniburguer.hamburgueria.maniburguer.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.maniburguer.hamburgueria.maniburguer.Classes.MoldeHamburguer;
import com.maniburguer.hamburgueria.maniburguer.Fragment.CarneFragment;
import com.maniburguer.hamburgueria.maniburguer.Fragment.EnviarFragment;
import com.maniburguer.hamburgueria.maniburguer.Fragment.GuarnicoesFragment;
import com.maniburguer.hamburgueria.maniburguer.Fragment.MolhosFragment;
import com.maniburguer.hamburgueria.maniburguer.Fragment.PaoFragment;
import com.maniburguer.hamburgueria.maniburguer.Fragment.QueijoFragment;
import com.maniburguer.hamburgueria.maniburguer.Fragment.SaladaFragment;

/**
 * Created by ind on 07/01/2018.
 */
public class TabsAdapter extends FragmentStatePagerAdapter {
private Context context;
    private String[] abas = new String[]{"PÃO","CARNE","MOLHOS","GUARNIÇÕES", "SALADA","QUEIJOS","ENVIAR" };
    private MoldeHamburguer moldeHamburguer = new MoldeHamburguer();

    private Fragment paoFragment = new PaoFragment();
    private Fragment carneFragment = new CarneFragment();
    private Fragment queijoFraqment = new QueijoFragment();
    private Fragment saladaFragment = new SaladaFragment();
    private Fragment guarnicoesFragment = new GuarnicoesFragment();
    private Fragment molhosFragment = new MolhosFragment();
    private Fragment enviarFragment = new EnviarFragment();


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

                fragment = molhosFragment;
                break;
            case 3:
                fragment = guarnicoesFragment;
                break;
            case 4:
                fragment = saladaFragment;
                break;
            case 5:

                fragment = queijoFraqment;
                break;
            case 6:
                fragment = enviarFragment;
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
