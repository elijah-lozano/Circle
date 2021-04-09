package com.example.circle.ui.courses;

import android.Manifest;
import android.content.ContentUris;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.circle.R;

import java.util.ArrayList;
import java.util.Locale;


public class CourseVideosFragment extends Fragment {


    private ArrayList<ModelVideo> videosList = new ArrayList<ModelVideo>();
    private AdapterVideoList adapterVideoList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_course_videos, container, false);

        initializeViews(view);


        checkPermissions();
        // Inflate the layout for this fragment
        return view;
    }


    private void initializeViews(View view){
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_videos);


        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        adapterVideoList = new AdapterVideoList(getContext(), videosList);
        recyclerView.setAdapter(adapterVideoList);

    }

    private void checkPermissions(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 123);
            }
            else {
                loadVideos();
            }
        }
        else {
                loadVideos();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode==123){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                loadVideos();
            } else {
                Toast.makeText(getContext(), "Permission was not granted", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void loadVideos(){
            new Thread(){
                @Override
                public void run() {
                    super.run();

                    String[] projection  = {MediaStore.Video.Media._ID, MediaStore.Video.Media.DISPLAY_NAME, MediaStore.Video.Media.DURATION};
                    String sortOrder = MediaStore.Video.Media.DATE_ADDED + "DESC";

                    Cursor cursor = getActivity().getApplication().getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, projection, null, null, sortOrder);
                    if(cursor!=null){
                        int idColumn = cursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID);
                        int titleCol = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME);
                        int durationCol = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION);

                        while(cursor.moveToNext()){
                            long id = cursor.getLong(idColumn);
                            String title = cursor.getString(titleCol);
                            int duration = cursor.getInt(durationCol);

                            Uri data = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, id);

                            String duration_formatted;
                            int sec = (duration/1000)%60;
                            int min= (duration/(1000*60))%60;
                            int hrs = (duration/(1000*60*60));

                            if(hrs == 0){
                                duration_formatted = String.valueOf(min).concat(":".concat(String.format(Locale.US, "%02d", sec)));
                            }else {
                                duration_formatted = String.valueOf(hrs).concat(":".concat(String.format(Locale.US, "%02d", min).concat(":".concat(String.format(Locale.US, "%02d", sec)))));
                            }

                            videosList.add(new ModelVideo(id, data, title, duration_formatted));

                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    adapterVideoList.notifyItemInserted(videosList.size()-1);
                                }
                            });


                        }

                    }


                }
            }.start();
    }




}

