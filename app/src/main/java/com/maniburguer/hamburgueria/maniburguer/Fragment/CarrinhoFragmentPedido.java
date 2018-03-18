package com.maniburguer.hamburgueria.maniburguer.Fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.maniburguer.hamburgueria.maniburguer.Classes.EnviarCarrinho;
import com.maniburguer.hamburgueria.maniburguer.Classes.Pedido;
import com.maniburguer.hamburgueria.maniburguer.Classes.Usuario;
import com.maniburguer.hamburgueria.maniburguer.R;
import com.maniburguer.hamburgueria.maniburguer.Util.TestesIniciais;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarrinhoFragmentPedido extends Fragment {

    private ScrollView scroll;
    private Button frente;
    private TextView precoTotal;
    private Button limparCarrinho;

    private View v;

    public CarrinhoFragmentPedido() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_carrinho_fragment_pedido, container, false);


        scroll = (ScrollView) v.findViewById(R.id.scroll);
        TableLayout tableLayout = new TableLayout(v.getContext());



        for(int i=0; i<Usuario.getPedido().getHamburguers().size();i++) {//para todos os hamburguers
            //CRIA E CONFIGURA O NOME DO HAMBURGUER
            TextView nome = new TextView(v.getContext());
            nome.setText("Nome do hamburguer: "+ Usuario.getPedido().getHamburguers().get(i).getDados().getNomeDoHamburguer());
            nome.setTextSize(20);
            Log.d("TAG",String.valueOf(Usuario.getPedido().getHamburguers().size()));
            tableLayout.addView(nome); //add nome do hamb


            //LAYOUT PARA DIVIDIR NOME:PRECO
            LinearLayout linearLayout = new LinearLayout(v.getContext());
            LinearLayout.LayoutParams linearLayoutlp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            linearLayout.setLayoutParams(linearLayoutlp);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayoutlp.setMargins(0,10,0,10);

            LinearLayout ll1 = new LinearLayout(v.getContext());
            LinearLayout.LayoutParams ll1P = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,0.2f);
            ll1.setLayoutParams(ll1P);
            ll1.setOrientation(LinearLayout.VERTICAL);

            LinearLayout ll2 = new LinearLayout(v.getContext());
            LinearLayout.LayoutParams ll2P = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,0.8f);
            ll2.setLayoutParams(ll2P);
            ll2.setOrientation(LinearLayout.VERTICAL);

                //nome do ingrediente
                TextView getPao = new TextView(v.getContext());
            getPao.setText(Usuario.getPedido().getHamburguers().get(i).getPao().getNome());
                ll1.addView(getPao);
                //preco do ingrediente
                TextView preco1 = new TextView(v.getContext());
                preco1.setText(String.valueOf(Usuario.getPedido().getHamburguers().get(i).getPao().getPreco()));
                ll2.addView(preco1);


            for(int j=0;j<Usuario.getPedido().getHamburguers().get(i).getCarne().size();j++){
                //nome do ingrediente
                TextView carne = new TextView(v.getContext());
                carne.setText(Usuario.getPedido().getHamburguers().get(i).getCarne().get(j).getNome());
                ll1.addView(carne);
                //preco do ingrediente
                TextView preco = new TextView(v.getContext());
                preco.setText(String.valueOf(Usuario.getPedido().getHamburguers().get(i).getCarne().get(j).getPreco()));
                ll2.addView(preco);
            }

            for(int j=0;j<Usuario.getPedido().getHamburguers().get(i).getQueijo().size();j++){
                //nome do ingrediente
                TextView queijo = new TextView(v.getContext());
                queijo.setText(Usuario.getPedido().getHamburguers().get(i).getQueijo().get(j).getNome());
                ll1.addView(queijo);
                //preco do ingrediente
                TextView preco = new TextView(v.getContext());
                preco.setText(String.valueOf(Usuario.getPedido().getHamburguers().get(i).getQueijo().get(j).getPreco()));
                ll2.addView(preco);
            }
            for(int j=0;j<Usuario.getPedido().getHamburguers().get(i).getAcrescimos().size();j++){
                //nome do ingrediente
                TextView getAcrescimos = new TextView(v.getContext());
                getAcrescimos.setText(Usuario.getPedido().getHamburguers().get(i).getAcrescimos().get(j).getNome());
                ll1.addView(getAcrescimos);
                //preco do ingrediente
                TextView preco = new TextView(v.getContext());
                preco.setText(String.valueOf(Usuario.getPedido().getHamburguers().get(i).getAcrescimos().get(j).getPreco()));
                ll2.addView(preco);
            }
            for(int j=0;j<Usuario.getPedido().getHamburguers().get(i).getSalada().size();j++){
                //nome do ingrediente
                TextView getSalada = new TextView(v.getContext());
                getSalada.setText(Usuario.getPedido().getHamburguers().get(i).getSalada().get(j).getNome());
                ll1.addView(getSalada);
                //preco do ingrediente
                TextView preco = new TextView(v.getContext());
                preco.setText(String.valueOf(Usuario.getPedido().getHamburguers().get(i).getSalada().get(j).getPreco()));
                ll2.addView(preco);
            }

            for(int j=0;j<Usuario.getPedido().getHamburguers().get(i).getMolhos().size();j++){
                //nome do ingrediente
                TextView getMolhos = new TextView(v.getContext());
                getMolhos.setText(Usuario.getPedido().getHamburguers().get(i).getMolhos().get(j).getNome());
                ll1.addView(getMolhos);
                //preco do ingrediente
                TextView preco = new TextView(v.getContext());
                preco.setText(String.valueOf(Usuario.getPedido().getHamburguers().get(i).getMolhos().get(j).getPreco()));
                ll2.addView(preco);
            }

            //nome do ingrediente
            TextView precoGeral = new TextView(v.getContext());
            precoGeral.setText("preço do hamburguer:");
            ll1.addView(precoGeral);
            //preco do ingrediente
            TextView preco2 = new TextView(v.getContext());
            preco2.setText(String.valueOf(Usuario.getPedido().getHamburguers().get(i).getDados().getPrecoDoHamburguer()));
            ll2.addView(preco2);


            linearLayout.addView(ll1);
            linearLayout.addView(ll2);
        tableLayout.addView(linearLayout);
        }



        LinearLayout ll;
        ll = (LinearLayout) v.findViewById(R.id.ll);
        ll.addView(tableLayout);


        precoTotal = (TextView) v.findViewById(R.id.precoTotal);
        precoTotal.setText(Usuario.getPedido().getPrecoGeral().toString());

        limparCarrinho = (Button) v.findViewById(R.id.btLimparPedido);
        limparCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pedido x = new Pedido();
                Usuario.setPedido(x);
                TestesIniciais.goMainScreen(getContext());
            }
        });

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
