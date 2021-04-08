package com.example.circle.ui.chatRooms;

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

public class ChatRoomsFragment extends Fragment {

    private ChatRoomsViewModel chatRoomsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        chatRoomsViewModel =
                new ViewModelProvider(this).get(ChatRoomsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_chat_rooms, container, false);
        final TextView textView = root.findViewById(R.id.text_chat_rooms);
        chatRoomsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}