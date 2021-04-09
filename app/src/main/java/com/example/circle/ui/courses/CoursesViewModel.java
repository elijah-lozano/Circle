package com.example.circle.ui.courses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.circle.R;

public class CoursesViewModel extends RecyclerView.Adapter<CoursesViewModel.coursesViewHolder> {

    private TextView view;
    Context context;
    String courseTitles[], courseDescriptions[];

    public CoursesViewModel(String s1[], String s2[]){
        courseTitles = s1;
        courseDescriptions= s2;
    }

    @NonNull
    @Override
    public coursesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);

        return new coursesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull coursesViewHolder holder, int position) {
        holder.titleTextView.setText(courseTitles[position]);
        holder.descTextView.setText(courseDescriptions[position]);
    }

    @Override
    public int getItemCount() {
        return courseTitles.length;
    }

    public class coursesViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView, descTextView;;

        public coursesViewHolder(@NonNull View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.course_title);
            descTextView = itemView.findViewById(R.id.course_description);
        }
    }
    /*private MutableLiveData<String> mText;

    public CoursesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is courses fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }*/
}