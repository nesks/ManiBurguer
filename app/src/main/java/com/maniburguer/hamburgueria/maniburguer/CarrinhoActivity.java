package com.maniburguer.hamburgueria.maniburguer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;

import com.maniburguer.hamburgueria.maniburguer.Classes.Hamburguer;
import com.maniburguer.hamburgueria.maniburguer.Classes.Usuario;

import java.util.ArrayList;

public class CarrinhoActivity extends AppCompatActivity {

    private ScrollView scroll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        scroll = (ScrollView) findViewById(R.id.scroll);
        imprimeHamburguers();

    }


    private void imprimeHamburguers(){
        for(int i=0; i<Usuario.getCarrinho().size();i++) {
            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
            scroll.addView(row);
            TextView tv = new TextView(this);
            tv.setGravity(TextView.TEXT_ALIGNMENT_CENTER);
            tv.setText(Usuario.getCarrinho().get(i).toString());
            row.addView(tv);


        }
    }
}
