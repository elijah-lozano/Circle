package com.example.circle.ui.aiChatRoom;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.example.circle.R;

import java.util.ArrayList;
import java.util.List;


public class AIChatroomFragment extends Fragment {

    int i = 0;
    EditText userInput;
    RecyclerView recyclerView;
    List<ResponseMessage> responseMessageList;
    MessageAdapter messageAdapter;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ai_chatroom, container, false);

        userInput = view.findViewById(R.id.userInput);
        recyclerView = view.findViewById(R.id.conversation);

        ArrayList<String> botResponseList = new  ArrayList<String>(
                List.of("Hello! I am Bob the bot. What is your name?",
                        "Nice to meet you! How are you doing today?",
                        "That's good. I'm feeling pretty good myself. But I am just a robot, so who cares?",
                        "Unfortunately, I can't really react appropriately as I do not have a database. Sorry.",
                        "Maybe I will one day, Maybe I'll have a user dependent response.",
                        "Until then, I guess i'll just stay as a hardcoded response bot."));

        responseMessageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(responseMessageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(messageAdapter);

        userInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    ResponseMessage message = new ResponseMessage(userInput.getText().toString(), true);
                    responseMessageList.add(message);
                    ResponseMessage message2 = new ResponseMessage(botResponseList.get(i), false);
                    i++;
                    if (i == 6)
                        i = 0;
                    responseMessageList.add(message2);
                    messageAdapter.notifyDataSetChanged();
                    if (!isVisibleX()) {
                        recyclerView.smoothScrollToPosition(messageAdapter.getItemCount()-1);
                    }
                }
                return true;
            }
        });

        // Inflate the layout for this fragment
        return view;
    }


    public boolean isVisibleX() {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int lastItemPos = linearLayoutManager.findLastCompletelyVisibleItemPosition();
        int itemCount = recyclerView.getAdapter().getItemCount();
        return (lastItemPos >= itemCount);
    }
}