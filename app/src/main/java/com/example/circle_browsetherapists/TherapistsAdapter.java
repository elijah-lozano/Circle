package com.example.circle_browsetherapists;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TherapistsAdapter extends RecyclerView.Adapter<TherapistsAdapter.therapistViewHolder> {

    String therapistNames[], therapistDescs[];
    int therapistImages[];
    Context context;

    public TherapistsAdapter(Context ct, String s1[], String s2[], int images[]){
        context = ct;
        therapistNames = s1;
        therapistDescs = s2;
        therapistImages = images;

    }

    @NonNull
    @Override
    public therapistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull therapistViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class therapistViewHolder extends RecyclerView.ViewHolder{

        public therapistViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
