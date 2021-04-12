package com.example.circle.ui.courses;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.circle.R;
import java.util.ArrayList;

public class AdapterVideoList extends RecyclerView.Adapter<AdapterVideoList.VideoViewHolder> {


    ArrayList<ModelVideo> videosList = new ArrayList<ModelVideo>();
    Context context;

    AdapterVideoList(Context context, ArrayList<ModelVideo> videosList){
        this.context = context;
        this.videosList = videosList;
    }

    @NonNull
    @Override
    public AdapterVideoList.VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_video, parent, false);

        return new VideoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterVideoList.VideoViewHolder holder, int position) {
        final ModelVideo item = videosList.get(position);
        holder.tv_title.setText(item.getTitle());
        holder.tv_duration.setText(item.getDuration());
        Glide.with(context).load(item.getData()).into(holder.imgView_thumbnail);

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Activity_Player.class);
                intent.putExtra("videoId", item.getId());
                v.getContext().startActivity(intent);
            }

        });


    }

    @Override
    public int getItemCount() {
        return videosList.size();
    }


    static class VideoViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView_thumbnail;
        TextView tv_title, tv_duration;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.textView_vid_title);
            tv_duration = itemView.findViewById(R.id.textView_duration);
            imgView_thumbnail = itemView.findViewById(R.id.imageView_thumbnail);
        }
    }
}
