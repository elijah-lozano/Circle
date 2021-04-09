package com.example.circle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.therapist_row, parent, false);

        return new therapistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull therapistViewHolder holder, int position) {
        holder.nameTextView.setText(therapistNames[position]);
        holder.descTextView.setText(therapistDescs[position]);
        holder.therapistImg.setImageResource(therapistImages[position]);
    }

    @Override
    public int getItemCount() {
        return therapistNames.length;
    }

    public class therapistViewHolder extends RecyclerView.ViewHolder{

        TextView nameTextView, descTextView;
        ImageView therapistImg;

        public therapistViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.therapist_name_txt);
            descTextView = itemView.findViewById(R.id.therapist_desc_txt);
            therapistImg = itemView.findViewById(R.id.therapist_img_view);
        }
    }
}
