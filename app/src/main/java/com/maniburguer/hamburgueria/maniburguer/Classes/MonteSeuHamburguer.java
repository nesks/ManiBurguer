package com.maniburguer.hamburgueria.maniburguer.Classes;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.maniburguer.hamburgueria.maniburguer.R;

import java.util.ArrayList;


public class MonteSeuHamburguer {



    public static void distribuiIngrediente(final ArrayList<Ingrediente> ingredientes, final ArrayList<Ingrediente> moldeHamburguer, View v){

        TableLayout tableLayout = new TableLayout(v.getContext());
        final TextView precoAtualizado;
        precoAtualizado = (TextView) v.findViewById(R.id.preco);
        atualizaPreco(precoAtualizado);

        for(int i=0;i<ingredientes.size();i++) {

            TableRow row = new TableRow(v.getContext());
            TableRow.LayoutParams rowLP = new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            rowLP.bottomMargin = 5;
            row.setLayoutParams(rowLP);

            //configurar  2 relativelayout (cada bloco de ingrediente)
            final FrameLayout[] newlayout = new FrameLayout[2];
            FrameLayout.LayoutParams newlayoutLP = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);

            for(int j=0;j<2;j++) {
                newlayout[j] = new FrameLayout(v.getContext());
                newlayout[j].setBackgroundResource(R.color.mainBloco);
                // newlayout[j].setLayoutParams(newlayoutLP); erro <-

                //cria e configura cada imagem dos ingredientes q fica no bloco
                final ImageView imageview = new ImageView(v.getContext());
                imageview.setImageResource(R.drawable.sandwich);

                //VERIFICA SE ALGO JA FOI SELECIONADO
                if(moldeHamburguer.contains(ingredientes.get(i+j))){
                    newlayout[j].setBackgroundResource(R.color.amarelo);
                }else{
                    newlayout[j].setBackgroundResource(R.color.mainBloco);
                }


                //CRIA E CONFIGURA O NOME DO INGREDIENTE
                TextView nome = new TextView(v.getContext());
                nome.setText(ingredientes.get(i+j).getNome());

                //CRIA E CONFIGURA O PREÇO DO INGREDIENTE
                TextView preco = new TextView(v.getContext());
                preco.setText(String.valueOf(ingredientes.get(i+j).getPreco()));

                //ADICIONA TUDO NO BLOCO
                newlayout[j].addView(imageview);
                newlayout[j].addView(nome);
                newlayout[j].addView(preco);

                final int finalJ = j;
                final int finalI = i;
                newlayout[j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(moldeHamburguer.contains(ingredientes.get(finalI + finalJ))) {
                            newlayout[finalJ].setBackgroundResource(R.color.mainBloco);
                            moldeHamburguer.remove(ingredientes.get(finalI + finalJ));
                            MoldeHamburguer.removePreco(ingredientes.get(finalI + finalJ).getPreco());
                              }else{
                            newlayout[finalJ].setBackgroundResource(R.color.amarelo);
                            moldeHamburguer.add(ingredientes.get(finalI + finalJ));
                            MoldeHamburguer.adicionaPreco(ingredientes.get(finalI + finalJ).getPreco());
                             }
                        atualizaPreco(precoAtualizado);

                    }
                });

            }
            row.setWeightSum(1f);
            row.addView(newlayout[0]);
            row.addView(newlayout[1]);

            i++;

            tableLayout.addView(row);
        }
        LinearLayout ll;
        ll = (LinearLayout) v.findViewById(R.id.ll);
        ll.addView(tableLayout);
    }

    public static void atualizaPreco(TextView preco){
        preco.setText("PREÇO: "+ String.valueOf(MoldeHamburguer.getPreco()));

    }

}
