package com.example.circle.ui.therapists;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.circle.R;

public class TherapistsFragment extends Fragment {

    private TherapistsViewModel therapistsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        therapistsViewModel =
                new ViewModelProvider(this).get(TherapistsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_therapists, container, false);
        final TextView textView = root.findViewById(R.id.text_therapists);
        therapistsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}