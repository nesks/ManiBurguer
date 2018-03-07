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
import com.maniburguer.hamburgueria.maniburguer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaoFragment extends Fragment {

    private Button paoComum;
    private Button select;
    private View v;


    public PaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         v= inflater.inflate(R.layout.fragment_pao, container, false);

        paoComum = (Button) v.findViewById(R.id.pComum);
        paoComum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoldeHamburguer.setPao(Estoque.getPao());
                trocaCor(v);
            }
        });
return v;
    }


    public void trocaCor(View view){
        if(select!=null){
            select.setBackgroundResource(R.color.mainBloco);
            Toast.makeText(v.getContext(), "Pão trocado.", Toast.LENGTH_SHORT).show();

        }
        select = (Button) v.findViewById(view.getId());
        select.setBackgroundResource(R.color.amarelo);

        Toast.makeText(v.getContext(), "Pão selecionado.", Toast.LENGTH_SHORT).show();
    }


}
