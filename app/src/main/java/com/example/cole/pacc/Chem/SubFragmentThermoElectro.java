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
        private EditText enthalpy, temperature, entropy, gibbsAnswer;
        private Button calculateGibbs;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);
            View rootView = inflater.inflate(R.layout.chem_subfragment_thermoelectro, container, false);
            wireWidgets(rootView);
            calculateGibbs.setOnClickListener(this);
            solveDistance();
            return rootView;
        }


        private void wireWidgets(View rootView) {
            enthalpy = (EditText) rootView.findViewById(R.id.editText_enthalpy);
            temperature = (EditText) rootView.findViewById(R.id.editText_temp);
            entropy = (EditText) rootView.findViewById(R.id.editText_entropy);
            gibbsAnswer = (EditText) rootView.findViewById(R.id.editText_answer_gibbs);
            calculateGibbs = (Button) rootView.findViewById(R.id.button_solve_gibbs);
        }

        private void solveDistance() {
            try {
                double h = Double.parseDouble(enthalpy.getText().toString());
                double t = Double.parseDouble(temperature.getText().toString());
                double s = Double.parseDouble(entropy.getText().toString());

                gibbsAnswer.setText("" + (h-t*s));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_solve_gibbs:
                    solveDistance();
                    break;
            }
        }
    }


