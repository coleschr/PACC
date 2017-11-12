package com.example.cole.pacc.Chem;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.cole.pacc.R;

/**
 * Created by Cole on 11/12/17.
 */

public class SubFragmentThermoElectro extends Fragment implements View.OnClickListener {
        private EditText enthalpy, temperature, entropy, gibbsAnswer, temp2, eqconst, getGibbsAnswer;
        private Button calculateGibbs, calculateGibbs2;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);
            View rootView = inflater.inflate(R.layout.chem_subfragment_thermoelectro, container, false);
            wireWidgets(rootView);
            calculateGibbs.setOnClickListener(this);
            calculateGibbs2.setOnClickListener(this);
            solveGibbs();
            solveGibbs2();
            return rootView;
        }




    private void wireWidgets(View rootView) {
            enthalpy = (EditText) rootView.findViewById(R.id.editText_enthalpy);
            temperature = (EditText) rootView.findViewById(R.id.editText_temp);
            entropy = (EditText) rootView.findViewById(R.id.editText_entropy);
            gibbsAnswer = (EditText) rootView.findViewById(R.id.editText_answer_gibbs);
            calculateGibbs = (Button) rootView.findViewById(R.id.button_solve_gibbs);
            temp2 = (EditText) rootView.findViewById(R.id.editText_temp2);
            eqconst = (EditText) rootView.findViewById(R.id.editText_equilibriumConstant);
            getGibbsAnswer = (EditText) rootView.findViewById(R.id.editText_answer_gibbs2);
            calculateGibbs2= (Button) rootView.findViewById(R.id.button_solve_gibbs3);
        }

        private void solveGibbs() {
            try {
                double h = Double.parseDouble(enthalpy.getText().toString());
                double t = Double.parseDouble(temperature.getText().toString());
                double s = Double.parseDouble(entropy.getText().toString());

                gibbsAnswer.setText("" + (h-t*s));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

    private void solveGibbs2() {
        try {
            double t = Double.parseDouble(temp2.getText().toString());
            double k = Double.parseDouble(eqconst.getText().toString());

            getGibbsAnswer.setText("" + (-1 * 0.0831 * t * Math.log(k)));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_solve_gibbs:
                    solveGibbs();
                    break;
                case R.id.button_solve_gibbs3:
                    solveGibbs2();
                    break;
            }
        }
    }


