package com.maniburguer.hamburgueria.maniburguer.Classes;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.maniburguer.hamburgueria.maniburguer.R;

import java.util.ArrayList;


public class MonteSeuHamburguer {

    public static TableLayout distribuiIngrediente(final ArrayList<Ingrediente> ingredientes, final ArrayList<Ingrediente> moldeHamburguer, View v){

        TableLayout tableLayout = new TableLayout(v.getContext());

        for(int i=0;i<ingredientes.size();i++) {

            TableRow row = new TableRow(v.getContext());

            for(int j=0;j<2;j++) {

                final RelativeLayout newlayout = new RelativeLayout(v.getContext());
                ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                newlayout.setPadding(5,5,5,5);

                final ImageView imageview = new ImageView(v.getContext());
                imageview.setLayoutParams(lp);
                imageview.setImageResource(R.drawable.sandwich);
                if(moldeHamburguer.contains(ingredientes.get(i+j))){
                    imageview.setBackgroundResource(R.color.amarelo);
                }else{
                    imageview.setBackgroundResource(R.color.mainBloco);
                }
                TextView nome = new TextView(v.getContext());
                nome.setText(ingredientes.get(i+j).getNome());

                TextView preco = new TextView(v.getContext());
                preco.setText(String.valueOf(ingredientes.get(i+j).getPreco()));


                newlayout.addView(imageview);
                newlayout.addView(nome);
                newlayout.addView(preco);

                final int finalJ = j;
                final int finalI = i;
                newlayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(moldeHamburguer.contains(ingredientes.get(finalI + finalJ))) {
                            imageview.setBackgroundResource(R.color.mainBloco);
                            moldeHamburguer.remove(ingredientes.get(finalI + finalJ));
                            MoldeHamburguer.removePreco(ingredientes.get(finalI + finalJ).getPreco());
                              }else{
                            imageview.setBackgroundResource(R.color.amarelo);
                            moldeHamburguer.add(ingredientes.get(finalI + finalJ));
                            MoldeHamburguer.adicionaPreco(ingredientes.get(finalI + finalJ).getPreco());
                             }

                    }
                });
                row.addView(newlayout);

            }
            i++;

            tableLayout.addView(row);
        }
        return tableLayout;
    }
}
