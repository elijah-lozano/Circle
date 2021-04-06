package com.example.circle_browsetherapists;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

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
    }
}