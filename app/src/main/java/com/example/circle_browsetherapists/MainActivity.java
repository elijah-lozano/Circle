package com.example.circle_browsetherapists;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.therapist_profiles);
        s2 = getResources().getStringArray(R.array.therapist_descriptions);

        TherapistsAdapter therapistsAdapter = new TherapistsAdapter(this, s1, s2, images);


    }
}