package com.example.cole.pacc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Cole on 11/11/17.
 */

public class FragmentPhys extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.phys_fragment, container, false);

        //wire any widgets -- must use rootView.findViewById

        //get any other initial set up done

        //return the view that we inflated
        return rootView;
    }
}
