package com.maniburguer.hamburgueria.maniburguer.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.maniburguer.hamburgueria.maniburguer.Classes.Hamburguer;
import com.maniburguer.hamburgueria.maniburguer.Classes.MoldeHamburguer;
import com.maniburguer.hamburgueria.maniburguer.Classes.Pedido;
import com.maniburguer.hamburgueria.maniburguer.Classes.Usuario;
import com.maniburguer.hamburgueria.maniburguer.R;
import com.maniburguer.hamburgueria.maniburguer.Util.TestesIniciais;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnviarFragment extends Fragment {


    private EditText nomeHamburguer;
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

        nomeHamburguer = (EditText) v.findViewById(R.id.eTNome);

        enviar = (Button) v.findViewById(R.id.btEnviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hamburguer x = new Hamburguer(String.valueOf(nomeHamburguer.getText()), Usuario.getNome());
                Usuario.getPedido().addHamburguer(x);
                Usuario.getPedido().atualizarPrecoGeral();
                TestesIniciais.goCarrinhoScreen(getContext());
            }
        });
        return v;
    }

}
