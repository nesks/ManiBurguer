package com.maniburguer.hamburgueria.maniburguer.Fragment;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.maniburguer.hamburgueria.maniburguer.Classes.Estoque;
import com.maniburguer.hamburgueria.maniburguer.Classes.Ingrediente;
import com.maniburguer.hamburgueria.maniburguer.Classes.MoldeHamburguer;
import com.maniburguer.hamburgueria.maniburguer.Classes.MonteSeuHamburguer;

import com.maniburguer.hamburgueria.maniburguer.R;
import com.maniburguer.hamburgueria.maniburguer.Util.TestesIniciais;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaoFragment extends Fragment {


    private View v;


    public PaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         v= inflater.inflate(R.layout.fragment_pao, container, false);

    distribuiIngrediente();

return v;
    }



    @TargetApi(Build.VERSION_CODES.M)
    public void distribuiIngrediente(){

        TableLayout tableLayout = new TableLayout(v.getContext());
        TestesIniciais.atualizaPreco();

        for(int i=0;i<Estoque.getPao().size();i++) {

            LinearLayout linearLayout = new LinearLayout(v.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);

            //configurar  2 relativelayout (cada bloco de ingrediente)
            final LinearLayout[] newlayout = new LinearLayout[2];
            LinearLayout.LayoutParams newlayoutLP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,0.5f);
            newlayoutLP.setMargins(5,5,5,5);

            for (int j = 0; j < 2; j++) {

                if(i+j<Estoque.getPao().size()){

                    newlayout[j] = new LinearLayout(v.getContext());
                    newlayout[j].setOrientation(LinearLayout.VERTICAL);
                    newlayout[j].setLayoutParams(newlayoutLP);



                    //cria e configura cada imagem dos Estoque.getPao() q fica no bloco
                    final ImageView imageview = new ImageView(v.getContext());
                    imageview.setImageResource(Estoque.getPao().get(i+j).getImage());



                    //CRIA E CONFIGURA O PREÇO DO INGREDIENTE
                    final TextView preco = new TextView(v.getContext());
                    preco.setText("R$ "+String.valueOf(Estoque.getPao().get(i + j).getPreco())+"0");
                    preco.setTextColor(v.getContext().getColor(R.color.amarelo));
                    preco.setTextSize(20);
                    preco.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                    //CRIA E CONFIGURA O NOME DO INGREDIENTE
                    TextView nome = new TextView(v.getContext());
                    nome.setText(Estoque.getPao().get(i + j).getNome());
                    nome.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                    //VERIFICA SE ALGO JA FOI SELECIONADO
                    if (MoldeHamburguer.getPao().contains(Estoque.getPao().get(i + j))) {
                        newlayout[j].setBackgroundResource(R.color.amarelo);
                        preco.setTextColor(v.getContext().getColor(R.color.branco));

                    } else {
                        newlayout[j].setBackgroundResource(R.color.mainBloco);
                        preco.setTextColor(v.getContext().getColor(R.color.amarelo));

                    }

                    //ADICIONA TUDO NO BLOCO
                    newlayout[j].addView(imageview);
                    newlayout[j].addView(preco);
                    newlayout[j].addView(nome);



                    final int finalJ = j;
                    final int finalI = i;
                    newlayout[j].setOnClickListener(new View.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.M)
                        @Override
                        public void onClick(View v) {

                            if(!MoldeHamburguer.getPao().isEmpty()){
                                if (MoldeHamburguer.getPao().contains(Estoque.getPao().get(finalI + finalJ))) {
                                    newlayout[finalJ].setBackgroundResource(R.color.mainBloco);
                                    preco.setTextColor(v.getContext().getColor(R.color.amarelo));
                                    MoldeHamburguer.removerIngrediente(MoldeHamburguer.getPao(), Estoque.getPao().get(finalI + finalJ));
                                    MoldeHamburguer.removePreco(Estoque.getPao().get(finalI + finalJ).getPreco());
                                     }else {
                                    Toast.makeText(getContext(), "Só pode se escolher 1 pão!", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                newlayout[finalJ].setBackgroundResource(R.color.amarelo);
                                preco.setTextColor(v.getContext().getColor(R.color.branco));
                                MoldeHamburguer.adicionarIngrediente(MoldeHamburguer.getPao(), Estoque.getPao().get(finalI + finalJ));
                                MoldeHamburguer.adicionaPreco(Estoque.getPao().get(finalI + finalJ).getPreco());
                            }
                            TestesIniciais.atualizaPreco();

                        }
                    });
                    linearLayout.addView(newlayout[j]);
                }
            }
            i++;

            tableLayout.addView(linearLayout);
        }


        LinearLayout ll;
        ll = (LinearLayout) v.findViewById(R.id.ll);
        ll.addView(tableLayout);
    }


}
