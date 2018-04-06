package com.maniburguer.hamburgueria.maniburguer.Classes;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.maniburguer.hamburgueria.maniburguer.R;
import com.maniburguer.hamburgueria.maniburguer.Util.TestesIniciais;

import java.util.ArrayList;


public class MonteSeuHamburguer {





    @TargetApi(Build.VERSION_CODES.M)
    public static void distribuiIngrediente(final ArrayList<Ingrediente> ingredientes, final ArrayList<Ingrediente> moldeHamburguer, View v){

        TableLayout tableLayout = new TableLayout(v.getContext());
          TestesIniciais.atualizaPreco();

        for(int i=0;i<ingredientes.size();i++) {

            LinearLayout linearLayout = new LinearLayout(v.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);

            //configurar  2 relativelayout (cada bloco de ingrediente)
            final LinearLayout[] newlayout = new LinearLayout[2];
            LinearLayout.LayoutParams newlayoutLP = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,0.5f);
            newlayoutLP.setMargins(5,5,5,5);

            for (int j = 0; j < 2; j++) {

                if(i+j<ingredientes.size()){

                    newlayout[j] = new LinearLayout(v.getContext());
                    newlayout[j].setOrientation(LinearLayout.VERTICAL);
                    newlayout[j].setLayoutParams(newlayoutLP);



                    //cria e configura cada imagem dos ingredientes q fica no bloco
                    final ImageView imageview = new ImageView(v.getContext());
                    imageview.setImageResource(ingredientes.get(i+j).getImage());


                    //CRIA E CONFIGURA O PREÇO DO INGREDIENTE
                    final TextView preco = new TextView(v.getContext());
                    preco.setText("R$ "+String.valueOf(ingredientes.get(i + j).getPreco())+"0");
                    preco.setTextColor(v.getContext().getColor(R.color.amarelo));
                    preco.setTextSize(20);
                    preco.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                    //CRIA E CONFIGURA O NOME DO INGREDIENTE
                    TextView nome = new TextView(v.getContext());
                    nome.setText(ingredientes.get(i + j).getNome());
                    nome.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                    //VERIFICA SE ALGO JA FOI SELECIONADO
                    if (moldeHamburguer.contains(ingredientes.get(i + j))) {
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
                        @Override
                        public void onClick(View v) {
                            if (moldeHamburguer.contains(ingredientes.get(finalI + finalJ))) {
                                newlayout[finalJ].setBackgroundResource(R.color.mainBloco);
                                preco.setTextColor(v.getContext().getColor(R.color.amarelo));
                                MoldeHamburguer.removerIngrediente(moldeHamburguer, ingredientes.get(finalI + finalJ));
                                MoldeHamburguer.removePreco(ingredientes.get(finalI + finalJ).getPreco());
                            } else {
                                newlayout[finalJ].setBackgroundResource(R.color.amarelo);
                                preco.setTextColor(v.getContext().getColor(R.color.branco));
                                MoldeHamburguer.adicionarIngrediente(moldeHamburguer, ingredientes.get(finalI + finalJ));
                                MoldeHamburguer.adicionaPreco(ingredientes.get(finalI + finalJ).getPreco());
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
