package com.maniburguer.hamburgueria.maniburguer.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.maniburguer.hamburgueria.maniburguer.Classes.Estoque;
import com.maniburguer.hamburgueria.maniburguer.Classes.Hamburguer;
import com.maniburguer.hamburgueria.maniburguer.Classes.MoldeHamburguer;
import com.maniburguer.hamburgueria.maniburguer.Classes.MonteSeuHamburguer;
import com.maniburguer.hamburgueria.maniburguer.Classes.Usuario;
import com.maniburguer.hamburgueria.maniburguer.R;
import com.maniburguer.hamburgueria.maniburguer.Util.TestesIniciais;

/**
 * A simple {@link Fragment} subclass.
 */
public class QueijoFragment extends Fragment {

    private View v;

    public QueijoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_queijo, container, false);

        MonteSeuHamburguer.distribuiIngrediente(Estoque.getQueijo(), MoldeHamburguer.getQueijo(),v);


        return v;
    }



}
