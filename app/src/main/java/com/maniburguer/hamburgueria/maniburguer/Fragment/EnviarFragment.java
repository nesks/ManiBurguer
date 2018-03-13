package com.maniburguer.hamburgueria.maniburguer.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.maniburguer.hamburgueria.maniburguer.Classes.Hamburguer;
import com.maniburguer.hamburgueria.maniburguer.Classes.Usuario;
import com.maniburguer.hamburgueria.maniburguer.R;
import com.maniburguer.hamburgueria.maniburguer.Util.TestesIniciais;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnviarFragment extends Fragment {



    private Button enviar;
        View v;
    public EnviarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_enviar, container, false);
        enviar = (Button) v.findViewById(R.id.btEnviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario.addHamburguer(new Hamburguer());
                TestesIniciais.goCarrinhoScreen(getContext());

            }
        });
        return v;
    }

}
