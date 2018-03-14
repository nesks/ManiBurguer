package com.maniburguer.hamburgueria.maniburguer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;

import com.maniburguer.hamburgueria.maniburguer.Classes.EnviarCarrinho;
import com.maniburguer.hamburgueria.maniburguer.Classes.Hamburguer;
import com.maniburguer.hamburgueria.maniburguer.Classes.Usuario;

import java.util.ArrayList;

public class CarrinhoActivity extends AppCompatActivity {

    private ScrollView scroll;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        scroll = (ScrollView) findViewById(R.id.scroll);
       enviar = (Button) findViewById(R.id.btEnviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnviarCarrinho.enviarHamburguers();
            }
        });



    }


}
