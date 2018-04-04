package com.maniburguer.hamburgueria.maniburguer.Fragment;


import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
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


    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_carrinho_fragment_pedido, container, false);



        precoTotal = (TextView) v.findViewById(R.id.precoTotal);
        precoTotal.setText(Usuario.getPedido().getPrecoGeral().toString());

        scroll = (ScrollView) v.findViewById(R.id.scroll);
        TableLayout tableLayout = new TableLayout(v.getContext());


        for(int i=0; i<Usuario.getPedido().getHamburguers().size();i++) {//para todos os hamburguers


            //LAYOUT PARA DIVIDIR NOME:PRECO
            LinearLayout relativeLayout = new LinearLayout(v.getContext());
            LinearLayout.LayoutParams linearLayoutlp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            relativeLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayoutlp.setMargins(5,5,5,5);
            relativeLayout.setLayoutParams(linearLayoutlp);
            relativeLayout.setBackgroundResource(R.color.mainBloco);


            LinearLayout ll1 = new LinearLayout(v.getContext());
            LinearLayout.LayoutParams ll1P = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,0.2f);
            ll1P.setMargins(15,0,0,0);
            ll1.setLayoutParams(ll1P);
            ll1.setOrientation(LinearLayout.VERTICAL);

            LinearLayout ll2 = new LinearLayout(v.getContext());
            LinearLayout.LayoutParams ll2P = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,0.8f);
            ll2P.setMargins(0,0,15,0);
            ll2.setLayoutParams(ll2P);
            ll2.setOrientation(LinearLayout.VERTICAL);

            //CRIA E CONFIGURA O NOME DO HAMBURGUER
            TextView nome = new TextView(v.getContext());
            nome.setText(Usuario.getPedido().getHamburguers().get(i).getDados().getNomeDoHamburguer());
            nome.setTextSize(20);
            nome.setGravity(View.TEXT_ALIGNMENT_CENTER);
            nome.setTextColor(getContext().getColor(R.color.colorAccent));
            ll1.addView(nome);


            //CRIA O BOTAO DE EXCLUIR HAMB
            TextView x = new TextView(v.getContext());
            x.setText("x");
            x.setTextSize(20);
            x.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
            x.setTextColor(getContext().getColor(R.color.amarelo));
            ll2.addView(x);
            final int finalI = i;
            x.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Usuario.getPedido().removeHamburguer(finalI);


                    Usuario.getPedido().atualizarPrecoGeral();

                    CarrinhoFragmentPedido fr = new CarrinhoFragmentPedido();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_exemplo, fr);
                    fragmentTransaction.commit();
                }
            });




            for(int j=0;j<Usuario.getPedido().getHamburguers().get(i).getPao().size();j++){
                //nome do ingrediente
                TextView pao = new TextView(v.getContext());
                pao.setText(Usuario.getPedido().getHamburguers().get(i).getPao().get(j).getNome());
                ll1.addView(pao);
                //preco do ingrediente
                TextView preco = new TextView(v.getContext());
                preco.setText(String.valueOf(Usuario.getPedido().getHamburguers().get(i).getPao().get(j).getPreco()));
                ll2.addView(preco);
                preco.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
            }


            for(int j=0;j<Usuario.getPedido().getHamburguers().get(i).getCarne().size();j++){
                //nome do ingrediente
                TextView carne = new TextView(v.getContext());
                carne.setText(Usuario.getPedido().getHamburguers().get(i).getCarne().get(j).getNome());
                ll1.addView(carne);
                //preco do ingrediente
                TextView preco = new TextView(v.getContext());
                preco.setText(String.valueOf(Usuario.getPedido().getHamburguers().get(i).getCarne().get(j).getPreco()));
                ll2.addView(preco);
                preco.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
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
                preco.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
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
                preco.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
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
                preco.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
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
                preco.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
            }

            //nome do ingrediente
            TextView precoGeral = new TextView(v.getContext());
            precoGeral.setText("preço do hamburguer:");
            precoGeral.setTextColor(getContext().getColor(R.color.cinza));
            ll1.addView(precoGeral);
            //preco do ingrediente
            TextView preco2 = new TextView(v.getContext());
            preco2.setTextColor(getContext().getColor(R.color.cinza));
            preco2.setText(String.valueOf(Usuario.getPedido().getHamburguers().get(i).getDados().getPrecoDoHamburguer()));
            ll2.addView(preco2);
            preco2.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);


            relativeLayout.addView(ll1);
            relativeLayout.addView(ll2);
        tableLayout.addView(relativeLayout);
        }



        LinearLayout ll;
        ll = (LinearLayout) v.findViewById(R.id.ll);
        ll.addView(tableLayout);



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
