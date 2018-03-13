package com.maniburguer.hamburgueria.maniburguer.Classes;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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



    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void distribuiIngrediente(final ArrayList<Ingrediente> ingredientes, final ArrayList<Ingrediente> moldeHamburguer, View v){

        TableLayout tableLayout = new TableLayout(v.getContext());
        final TextView precoAtualizado;
        precoAtualizado = (TextView) v.findViewById(R.id.preco);
        atualizaPreco(precoAtualizado);

        for(int i=0;i<ingredientes.size();i++) {

            LinearLayout linearLayout = new LinearLayout(v.getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(LinearLayout.VERTICAL);

            //configurar  2 relativelayout (cada bloco de ingrediente)
            final Button[] buttons = new Button[2];
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            for (int j = 0; j < 2; j++)
                if (i + j < ingredientes.size()) {

                    buttons[j] = new Button(v.getContext());
                    buttons[j].setLayoutParams(lp);

                    //cria e configura cada imagem dos ingredientes q fica no bloco
                    buttons[j].setBackground(v.getResources().getDrawable(R.drawable.sandwich));

                    //VERIFICA SE ALGO JA FOI SELECIONADO
                    if (moldeHamburguer.contains(ingredientes.get(i + j))) {
                        buttons[j].setBackgroundColor(v.getResources().getColor(R.color.amarelo));
                    } else {
                        buttons[j].setBackgroundColor(v.getResources().getColor(R.color.mainBloco));
                    }


                    //CRIA E CONFIGURA O NOME E PRECO DO INGREDIENTE
                    buttons[j].setText(ingredientes.get(i + j).getNome()+" R$"+ingredientes.get(i+j).getPreco());


                    final int finalJ = j;
                    final int finalI = i;
                    buttons[j].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (moldeHamburguer.contains(ingredientes.get(finalI + finalJ))) {
                                buttons[finalJ].setBackgroundColor(v.getResources().getColor(R.color.mainBloco));
                                moldeHamburguer.remove(ingredientes.get(finalI + finalJ));
                                MoldeHamburguer.removePreco(ingredientes.get(finalI + finalJ).getPreco());
                            } else {
                                buttons[finalJ].setBackgroundColor(v.getResources().getColor(R.color.amarelo));
                                moldeHamburguer.add(ingredientes.get(finalI + finalJ));
                                MoldeHamburguer.adicionaPreco(ingredientes.get(finalI + finalJ).getPreco());
                            }
                            atualizaPreco(precoAtualizado);

                        }
                    });
                    linearLayout.addView(buttons[j]);
                }
            i++;

            tableLayout.addView(linearLayout);
        }


        LinearLayout ll;
        ll = (LinearLayout) v.findViewById(R.id.ll);
        ll.addView(tableLayout);
    }

    public static void atualizaPreco(TextView preco){
        preco.setText("PREÇO: "+ String.valueOf(MoldeHamburguer.getPreco()));

    }

}
