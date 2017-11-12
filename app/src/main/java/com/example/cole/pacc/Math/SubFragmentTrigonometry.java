package com.example.cole.pacc.Math;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cole.pacc.MainActivity;
import com.example.cole.pacc.R;

import java.util.ArrayList;

/**
 * Created by phoebekim on 11/11/17.
 */

public class SubFragmentTrigonometry extends Fragment {

    private EditText x;
    private TextView sin, cos, tan, csc, sec, cot, error;
    private Button solve;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.math_subfragment_trigonometry, container, false);

        x = (EditText) rootView.findViewById(R.id.x);
        sin = (TextView) rootView.findViewById(R.id.sin);
        cos = (TextView) rootView.findViewById(R.id.cos);
        tan = (TextView) rootView.findViewById(R.id.tan);
        csc = (TextView) rootView.findViewById(R.id.csc);
        sec = (TextView) rootView.findViewById(R.id.sec);
        cot = (TextView) rootView.findViewById(R.id.cot);
        error = (TextView) rootView.findViewById(R.id.error);
        solve = (Button) rootView.findViewById(R.id.solve);

        solve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x.getText().equals(""))
                {
                    error();
                }
                else {
                    sin();
                    cos();
                    tan();
                    csc();
                    sec();
                    cot();
                }
            }
        });

        //wire any widgets -- must use rootView.findViewById

        //get any other initial set up done

        //return the view that we inflated
        return rootView;
    }

    private void sin() {
        String string = x.getText().toString();
        double a = Double.parseDouble(string);
        sin.setText("sinx = " + java.lang.Math.sin(a));
    }

    private void cos() {
        String string = x.getText().toString();
        double a = Double.parseDouble(string);
        cos.setText("cosx = " + java.lang.Math.cos(a));
    }

    private void tan() {
        String string = x.getText().toString();
        double a = Double.parseDouble(string);
        if (java.lang.Math.cos(a)==0) {
            tan.setText("tanx does not exist");
        }
        else{
            tan.setText("tanx = " + (java.lang.Math.sin(a))/(java.lang.Math.cos(a)));
        }
    }

    private void csc() {
        String string = x.getText().toString();
        double a = Double.parseDouble(string);
        if (java.lang.Math.sin(a)==0) {
            csc.setText("cscx does not exist");
        }
        else{
            csc.setText("cscx = " + 1.0/(java.lang.Math.sin(a)));
        }
    }

    private void sec() {
        String string = x.getText().toString();
        double a = Double.parseDouble(string);
        if (java.lang.Math.cos(a)==0) {
            sec.setText("secx does not exist");
        }
        else{
            sec.setText("secx = " + 1.0/(java.lang.Math.cos(a)));
        }
    }

    private void cot() {
        String string = x.getText().toString();
        double a = Double.parseDouble(string);
        if (java.lang.Math.sin(a)==0) {
            cot.setText("cotx does not exist");
        }
        else{
            cot.setText("tanx = " + (java.lang.Math.cos(a))/(java.lang.Math.sin(a)));
        }
    }

    private void error() {
        error.setText("Please enter a valid value for x");
    }

}
