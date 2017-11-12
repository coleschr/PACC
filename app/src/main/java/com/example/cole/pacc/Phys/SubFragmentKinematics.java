package com.example.cole.pacc.Phys;

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
 * Created by cathy on 11/11/2017.
 */

public class SubFragmentKinematics extends Fragment implements View.OnClickListener {
    private EditText initialV, accl, time, distAnswer, initialV2, accl2, time2, velocityAnswer;
    private Button calculateDist, calculateVelocity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.phys_fragment_kinematics, container, false);
        wireWidgets(rootView);
        calculateDist.setOnClickListener(this);
        calculateVelocity.setOnClickListener(this);
        
        solveDistance();
        solveVelocity();
        return rootView;
    }



    private void wireWidgets(View rootView) {
        initialV = (EditText) rootView.findViewById(R.id.editText_velocity0);
        accl = (EditText) rootView.findViewById(R.id.editText_accl);
        time = (EditText) rootView.findViewById(R.id.editText_time);
        distAnswer = (EditText) rootView.findViewById(R.id.editText_answer_d);
        calculateDist = (Button) rootView.findViewById(R.id.button_solve_d);
        initialV2 = (EditText) rootView.findViewById(R.id.editText_v0);
        accl2 = (EditText) rootView.findViewById(R.id.editText_a);
        time2 = (EditText) rootView.findViewById(R.id.editText_t);
        velocityAnswer = (EditText) rootView.findViewById(R.id.editText_answer_v);
        calculateVelocity = (Button) rootView.findViewById(R.id.button_solve_v);
    }

    private void solveDistance() {
        try {
            double vi = Double.parseDouble(initialV.getText().toString());
            double a = Double.parseDouble(accl.getText().toString());
            double t = Double.parseDouble(time.getText().toString());

            distAnswer.setText("" + (vi * t + 0.5 * a * t * t));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void solveVelocity() {
        try {
            double vi = Double.parseDouble(initialV2.getText().toString());
            double a = Double.parseDouble(accl2.getText().toString());
            double t = Double.parseDouble(time2.getText().toString());

            velocityAnswer.setText("" + (vi + a * t));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_solve_d:
                solveDistance();
                break;
            case R.id.button_solve_v:
                solveVelocity();
                break;
        }
    }
}
