package com.maniburguer.hamburgueria.maniburguer.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.maniburguer.hamburgueria.maniburguer.Classes.Estoque;
import com.maniburguer.hamburgueria.maniburguer.Classes.MoldeHamburguer;
import com.maniburguer.hamburgueria.maniburguer.Classes.Ingrediente;
import com.maniburguer.hamburgueria.maniburguer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarneFragment extends Fragment {


    private Button carneBovina100;
    private Button carneBovina150;
    private Ingrediente in;
    private View v;

    public CarneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_carne, container, false);


        carneBovina100 = (Button) v.findViewById(R.id.cBovina100);
        carneBovina100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                in = Estoque.getCarne().get(0);
               troca(carneBovina100, in, "100g");
            }
        });


        carneBovina150 = (Button) v.findViewById(R.id.cBovina150);
        carneBovina150.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                in = Estoque.getCarne().get(1);
                troca(carneBovina150,in,"150g");
            }
        });


        return v;
    }


    public void troca(Button x, Ingrediente in, String a){
        if(MoldeHamburguer.getCarne().contains(in)){
            MoldeHamburguer.removeCarne(in);
            x.setBackgroundResource(R.color.mainBloco);
            Toast.makeText(v.getContext(), "Carne bovina"+a+" removida.", Toast.LENGTH_SHORT).show();
        }else{
            MoldeHamburguer.adicionarCarne(in);
            x.setBackgroundResource(R.color.amarelo);
            Toast.makeText(v.getContext(), "Carne bovina "+a+" adicionado.", Toast.LENGTH_SHORT).show();
        }

    }



}
