package com.example.circle.ui.chatRooms.chats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.circle.R;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ChatFragment extends Fragment {

    String s1[], s2[];
    int images[];

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_chat, container, false);

        RecyclerView rv = (RecyclerView) root.findViewById(R.id.chat_recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        int images[] = {R.drawable.sandy_zamora, R.drawable.richard_walla};

        s1 = new String[]{"Jane Doe", "John Doe"};
        s2 = new String[]{"This is the chatroom for meditation!", "Interact with others who are open to share!"};

        ChatFragmentAdapter chatFragmentAdapterTemp = new ChatFragmentAdapter(this.getActivity(),s1,s2,images);
        rv.setAdapter(chatFragmentAdapterTemp);
        return root;
    }
}