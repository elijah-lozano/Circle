package com.example.circle.ui.chatRooms.chats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.circle.R;


public class ChatFragmentAdapter extends RecyclerView.Adapter<ChatFragmentAdapter.ViewHolder> {



    Context context;
    String courseNames[], courseDescriptions[];
    int userImages[];
    public ChatFragmentAdapter(Context c, String s1[], String s2[],int images[]) {
        context = c;
        courseNames = s1;
        courseDescriptions = s2;
        userImages = images;
    }

    @NonNull
    @Override
    public com.example.circle.ui.chatRooms.chats.ChatFragmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chat_row, parent, false);
        return new com.example.circle.ui.chatRooms.chats.ChatFragmentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.chatroomName.setText(courseNames[position]);
        holder.chatroomDesc.setText(courseDescriptions[position]);
        holder.userImages.setImageResource(userImages[position]);
    }

    @Override
    public int getItemCount() {
        return courseNames.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView chatroomName, chatroomDesc;
        ImageView userImages;

        public ViewHolder(View view) {
            super(view);
            chatroomName = view.findViewById(R.id.chat_name);
            chatroomDesc = view.findViewById(R.id.chat_value);
            userImages = view.findViewById(R.id.chat_image);
        }
    }

}