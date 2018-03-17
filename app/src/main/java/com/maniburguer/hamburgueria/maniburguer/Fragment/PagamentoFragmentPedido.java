package com.maniburguer.hamburgueria.maniburguer.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.maniburguer.hamburgueria.maniburguer.Classes.Endereco;
import com.maniburguer.hamburgueria.maniburguer.Classes.EnviarCarrinho;
import com.maniburguer.hamburgueria.maniburguer.Classes.Usuario;
import com.maniburguer.hamburgueria.maniburguer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PagamentoFragmentPedido extends Fragment {


    private View v;
    private Button enviar;


    private Button traz;

    public PagamentoFragmentPedido() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_pagamento_fragment_pedido, container, false);



        enviar = (Button) v.findViewById(R.id.btConfirmarPedido);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EnviarCarrinho.enviarHamburguers();

            }
        });


        traz = (Button) v.findViewById(R.id.traz);
        traz.setOnClickListener(new View.OnClickListener() {
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
