package com.example.circle;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivityTemp extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        recyclerView = findViewById(R.id.therapists_recyclerView);

        s1 = getResources().getStringArray(R.array.therapist_profiles);
        s2 = getResources().getStringArray(R.array.therapist_descriptions);

        TherapistsAdapterTemp therapistsAdapterTemp = new TherapistsAdapterTemp(this, s1, s2, images);
        recyclerView.setAdapter(therapistsAdapterTemp);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}