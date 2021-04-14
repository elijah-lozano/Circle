package com.example.circle.ui.chatRooms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.circle.R;
import com.example.circle.ui.chatRooms.chats.ChatFragment;
import com.example.circle.ui.chatRooms.ChatRoomsFragment;

public class ChatroomFragmentAdapter extends RecyclerView.Adapter<ChatroomFragmentAdapter.ViewHolder> {



    Context context;
    String courseNames[], courseDescriptions[];
    int userImages[];
    public ChatroomFragmentAdapter(Context c, String s1[], String s2[],int images[]) {
        context = c;
        courseNames = s1;
        courseDescriptions = s2;
        userImages = images;
    }

    @NonNull
    @Override
    public com.example.circle.ui.chatRooms.ChatroomFragmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chatroom_row, parent, false);
        return new com.example.circle.ui.chatRooms.ChatroomFragmentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.chatroomName.setText(courseNames[position]);
        holder.chatroomDesc.setText(courseDescriptions[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Joined chatroom : " + courseNames[position], Toast.LENGTH_SHORT).show();
                //AppCompatActivity activity = (AppCompatActivity)v.getContext();
                //ChatFragment chatfrag = new ChatFragment();
                //activity.getSupportFragmentManager().beginTransaction().replace(R.id.rec,chatfrag).commit();
                Navigation.findNavController(v).navigate(R.id.action_navigation_chat_rooms_to_chatFragment);
            }
        });
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
            chatroomName = view.findViewById(R.id.chatroom_title);
            chatroomDesc = view.findViewById(R.id.chatroom_description);
            userImages = view.findViewById(R.id.chatroom_icon);
        }
    }

}