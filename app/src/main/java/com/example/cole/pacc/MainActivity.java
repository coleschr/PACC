package com.example.cole.pacc;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.cole.pacc.Chem.FragmentChem;
import com.example.cole.pacc.Math.FragmentMath;
import com.example.cole.pacc.Phys.FragmentPhys;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton[] icon;
    private int screen;
    private Fragment currentFragment;
    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        wireWidgets();
        setOnClickListeners();
        setUpHomeScreen();
    }

    private void setUpHomeScreen() {
        screen = 0;
        currentFragment = new FragmentMath();
        switchToNewScreen();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            layout.setBackgroundColor(getColor(R.color.colorBackground));
        } else { //ECEFF1
            layout.setBackgroundColor(Color.rgb(236, 239, 241));
        }
    }

    private void wireWidgets() {
        icon = new ImageButton[5];
        icon[0] = (ImageButton) findViewById(R.id.math);
        icon[1] = (ImageButton) findViewById(R.id.chem);
        icon[2] = (ImageButton) findViewById(R.id.phys);


        layout = (ConstraintLayout) findViewById(R.id.layout_main_background);
    }

    private void setOnClickListeners() {
        icon[0].setOnClickListener(this);
        icon[1].setOnClickListener(this);
        icon[2].setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.math:
                currentFragment = new FragmentMath();
                switchToNewScreen();
                changeIconColors(0);
                break;
            case R.id.chem:
                currentFragment = new FragmentChem();
                switchToNewScreen();
                changeIconColors(1);
                break;
            case R.id.phys:
                currentFragment = new FragmentPhys();
                switchToNewScreen();
                changeIconColors(2);
                break;

        }
    }

    private void switchToNewScreen() {
        //tell the fragment manager that if our current fragment isn't null, to replace whatever is there with it
        FragmentManager fm = getSupportFragmentManager();
        if (currentFragment != null) {
            fm.beginTransaction()
                    .replace(R.id.fragment_container, currentFragment)
                    .commit();
        }
    }

    private void changeIconColors(int newScreen) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            icon[screen].setColorFilter(getColor(R.color.colorNotClicked));
            screen = newScreen;
            icon[screen].setColorFilter(getColor(R.color.colorAccent));
        } else { //7C4DFF
            icon[screen].setColorFilter(Color.rgb(96, 125, 139)); //colorNotClicked
            screen = newScreen;
            icon[screen].setColorFilter(Color.rgb(124, 61, 255)); //colorAccent
        }
    }
}
