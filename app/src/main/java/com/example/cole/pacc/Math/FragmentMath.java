package com.example.cole.pacc.Math;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cole.pacc.R;

import java.util.ArrayList;

/**
 * Created by Cole on 11/11/17.
 */

public class FragmentMath extends Fragment {
    private ListView topicsListView;
    private ArrayList<String> topics;
    private ArrayAdapter<String> adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.math_fragment, container, false);

        //wire any widgets -- must use rootView.findViewById
        wireWidgets(rootView);

        //get any other initial set up done
        createTopics();

        adapter =
                new ArrayAdapter<String>(getActivity(), //context
                        R.layout.list_item_topic,   //textView layout for the l
                        topics); //the list to d
        //set the adapter to the listView
        topicsListView.setAdapter(adapter);
        topicsListView.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) { //int i used to be pos (position in list)

                //Intent i = new Intent(MainActivity.this, StarDescriptionActivity.class);

                //i.putExtra(STAR, stars.get(pos));

                //startActivity(i);
            }
        });

        //return the view that we inflated
        return rootView;
    }

    private void wireWidgets(View rootView) {
        topicsListView = (ListView) rootView.findViewById(R.id.listView_math);
    }

    private void createTopics() {
        topics = new ArrayList<>();
        topics.add("Trig Functions");
        topics.add("Kinetics");
        topics.add("Gases, Liquids, and Solutions");
        topics.add("Thermochemistry/Electrochemistry");

    }
}
