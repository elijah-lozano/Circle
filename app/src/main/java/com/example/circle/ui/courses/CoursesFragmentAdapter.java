package com.example.circle.ui.courses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.circle.R;

public class CoursesFragmentAdapter extends RecyclerView.Adapter<CoursesFragmentAdapter.ViewHolder> {

    Context context;
    String courseNames[], courseDescriptions[];
    public CoursesFragmentAdapter(Context c, String s1[], String s2[]) {
        context = c;
        courseNames = s1;
        courseDescriptions = s2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.courses_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.courseName.setText(courseNames[position]);
        holder.courseDesc.setText(courseDescriptions[position]);
    }

    @Override
    public int getItemCount() {
        return courseNames.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView courseName, courseDesc;

        public ViewHolder(View view) {
            super(view);
            courseName = view.findViewById(R.id.course_title);
            courseDesc = view.findViewById(R.id.course_description);
        }
    }
}