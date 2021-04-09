package com.example.circle.ui.therapists;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.circle.R;
import com.example.circle.TherapistsAdapter;

public class TherapistsFragment extends Fragment {

    RecyclerView recyclerView;

    String s1[], s2[];
    int images[] = {R.drawable.amber_bailey,
            R.drawable.shawndel_springer,
            R.drawable.bob_stead,
            R.drawable.stephen_garcia,
            R.drawable.deborah_lane,
            R.drawable.april_boreham,
            R.drawable.george_cox,
            R.drawable.ashley_logan,
            R.drawable.richard_walla,
            R.drawable.sandy_zamora};


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_therapists, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.therapists_recyclerView);
        recyclerView.setNestedScrollingEnabled(false);

        s1 = getResources().getStringArray(R.array.therapist_profiles);
        s2 = getResources().getStringArray(R.array.therapist_descriptions);

        TherapistsAdapter therapistsAdapterTemp = new TherapistsAdapter(getContext(), s1, s2, images);
        recyclerView.setAdapter(therapistsAdapterTemp);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}