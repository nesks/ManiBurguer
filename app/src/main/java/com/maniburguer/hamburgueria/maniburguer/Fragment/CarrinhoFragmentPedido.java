package com.maniburguer.hamburgueria.maniburguer.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;

import com.maniburguer.hamburgueria.maniburguer.Classes.EnviarCarrinho;
import com.maniburguer.hamburgueria.maniburguer.Classes.Usuario;
import com.maniburguer.hamburgueria.maniburguer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarrinhoFragmentPedido extends Fragment {

    private ScrollView scroll;
    private Button frente;
    View v;

    public CarrinhoFragmentPedido() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_carrinho_fragment_pedido, container, false);
frente = (Button) v.findViewById(R.id.frente);

        frente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnderecoFragmentPedido fr = new EnderecoFragmentPedido();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_exemplo, fr);
                fragmentTransaction.commit();
            }
        });


return v;
    }

}
