package com.example.cole.pacc.Math;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.cole.pacc.R;

import java.util.ArrayList;

/**
 * Created by phoebekim on 11/11/17.
 */

public class TrigFunctions extends Fragment {

    private EditText anglea, sidea, angleb, sideb, anglec, sidec;
    private double banglea, vsidea, vangleb, vsideb, vanglec, vsidec;
    private Button solve;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.functions_trig, container, false);

        anglea = (EditText) rootView.findViewById(R.id.anglea);
        sidea = (EditText) rootView.findViewById(R.id.sidea);
        angleb = (EditText) rootView.findViewById(R.id.angleb);
        sideb = (EditText) rootView.findViewById(R.id.sideb);
        anglec = (EditText) rootView.findViewById(R.id.anglec);
        sidec = (EditText) rootView.findViewById(R.id.sidec);
        solve = (Button) rootView.findViewById(R.id.solve);

        ArrayList<EditText> values = new ArrayList<EditText>() {{
            add(anglea);
            add(sidea);
            add(angleb);
            add(sideb);
            add(anglec);
            add(sidec);
        }};

        for (int i = 0; i < 6; i++)
        {
            int enoughinfo = 0;
            if (values.get(i).getText().equals(""))
            {
               enoughinfo = enoughinfo;
            }
        }

        //wire any widgets -- must use rootView.findViewById

        //get any other initial set up done

        //return the view that we inflated
        return rootView;
    }

}
