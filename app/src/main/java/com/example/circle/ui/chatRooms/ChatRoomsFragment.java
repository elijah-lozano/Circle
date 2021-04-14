package com.example.circle.ui.chatRooms;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.circle.R;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.circle.R;
import com.example.circle.ui.chatRooms.chats.ChatFragment;
import com.example.circle.ui.courses.CoursesFragmentAdapter;

public class ChatRoomsFragment extends Fragment {

    String s1[], s2[];

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_chat_rooms, container, false);

        RecyclerView rv = (RecyclerView) root.findViewById(R.id.chatroom_recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        int images[] = {R.drawable.meditate,};
        s1 = getResources().getStringArray(R.array.chatroom_subjects);
       
        s2 = getResources().getStringArray(R.array.chatroom_descs);

        ChatroomFragmentAdapter chatroomFragmentAdapter = new ChatroomFragmentAdapter(getContext(),s1,s2,images);
        rv.setAdapter(chatroomFragmentAdapter);
        return root;
    }
}