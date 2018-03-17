package com.maniburguer.hamburgueria.maniburguer.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.maniburguer.hamburgueria.maniburguer.Classes.Endereco;
import com.maniburguer.hamburgueria.maniburguer.Classes.Usuario;
import com.maniburguer.hamburgueria.maniburguer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnderecoFragmentPedido extends Fragment {


   private EditText bairro;
   private EditText numero;
   private EditText rua;
   private EditText referencia;
   private EditText complemento;




    private Button traz;
    private Button frente;
    private View v;

    public EnderecoFragmentPedido() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_endereco_fragment_pedido, container, false);


        bairro = (EditText) v.findViewById(R.id.eTBairro);
        rua = (EditText) v.findViewById(R.id.eTRua);
        numero = (EditText) v.findViewById(R.id.eTNumero);
        referencia = (EditText) v.findViewById(R.id.eTReferencia);
        complemento = (EditText) v.findViewById(R.id.eTComplemento);





        frente = (Button) v.findViewById(R.id.frente);
        traz = (Button) v.findViewById(R.id.traz);

        traz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarrinhoFragmentPedido fr = new CarrinhoFragmentPedido();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_exemplo, fr);
                fragmentTransaction.commit();
            }
        });
        frente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Usuario.getPedido()!=null)


                    if(String.valueOf(bairro.getText()).equals("")){
                        Toast.makeText(getContext(),"Digite o bairro corretamente",Toast.LENGTH_LONG);
                        bairro.setFocusable(bairro.getFreezesText());
                    }else if(String.valueOf(rua.getText()).equals("")){
                        Toast.makeText(getContext(),"Digite a rua corretamente",Toast.LENGTH_LONG);
                        rua.setFocusable(rua.getFreezesText());
                    }else if(String.valueOf(numero.getText()).equals("")){
                        Toast.makeText(getContext(),"Digite o numero corretamente",Toast.LENGTH_LONG);
                        numero.setFocusable(numero.getFreezesText());
                    }else {

                        Endereco endereco = new Endereco();
                        endereco.setCidade("João Monlevade");
                        endereco.setBairro(String.valueOf(bairro.getText()));
                        endereco.setRua(String.valueOf(rua.getText()));
                        endereco.setNumero(String.valueOf(numero.getText()));
                        if(!referencia.getText().equals("")) {
                            endereco.setReferencia(String.valueOf(referencia.getText()));
                        }
                        if(!complemento.getText().equals("")){
                            endereco.setComplemento(String.valueOf(complemento.getText()));
                        }

                        if(!Usuario.getPedido().getHamburguers().isEmpty()) {
                            for (int i = 0; i < Usuario.getPedido().getHamburguers().size(); i++) {
                                Usuario.getPedido().getHamburguers().get(i).getDados().setEndereco(endereco);
                            }
                        }}

                PagamentoFragmentPedido fr = new PagamentoFragmentPedido();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_exemplo, fr);
                fragmentTransaction.commit();
            }
        });


        return v;
    }


}
