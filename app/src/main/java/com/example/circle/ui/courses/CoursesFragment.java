package com.example.circle.ui.courses;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.circle.R;

public class CoursesFragment extends Fragment {

    String s1[], s2[];
    int images[] = {R.drawable.depression, R.drawable.mental_health, R.drawable.anxtiety,
            R.drawable.wellness_growth, R.drawable.suicide_prevention, R.drawable.stress,
            R.drawable.digital, R.drawable.covid19};
    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_courses, container, false);

        RecyclerView rv = (RecyclerView) root.findViewById(R.id.courses_recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        s1 = new String[]{"Depression", "Understanding Mental Health", "Symptoms of Anxiety",
                "Mental Wellness Growth", "Suicide Prevention", "Thrive in Stressful Conditions",
                "Digital Wellbeing", "Coping During COVID-19"};
        s2 = new String[]{"This is the description for course 1.", "This is the description for course 2.",
                "This is the description for course 3.","This is the description for course 4.","This is the description for course 5.",
                "This is the description for course 6.","This is the description for course 7.", "This is the description for course 8."};

        CoursesFragmentAdapter therapistsAdapterTemp = new CoursesFragmentAdapter(this.getActivity(),s1,s2, images);
        rv.setAdapter(therapistsAdapterTemp);
        return root;
    }
}