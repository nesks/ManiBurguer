package com.maniburguer.hamburgueria.maniburguer.Fragment;


import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.maniburguer.hamburgueria.maniburguer.Classes.Estoque;
import com.maniburguer.hamburgueria.maniburguer.Classes.MoldeHamburguer;
import com.maniburguer.hamburgueria.maniburguer.Classes.Ingrediente;
import com.maniburguer.hamburgueria.maniburguer.Classes.MonteSeuHamburguer;
import com.maniburguer.hamburgueria.maniburguer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarneFragment extends Fragment {

    private View v;
    private ScrollView sc;

    public CarneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_carne, container, false);

      sc = (ScrollView) v.findViewById(R.id.scroll);

            sc.addView(MonteSeuHamburguer.distribuiIngrediente(
                    Estoque.getCarne(),
                    MoldeHamburguer.getCarne(),
                    v));

        return v;
    }


}
