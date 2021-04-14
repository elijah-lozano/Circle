package com.example.circle.ui.aiChatRoom;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

import com.example.circle.R;
import com.example.circle.ui.aiChatRoom.ResponseMessage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int i = 0;
    EditText userInput;
    RecyclerView recyclerView;
    List<ResponseMessage> responseMessageList;
    MessageAdapter messageAdapter;
    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ai_chat_room);
        userInput = findViewById(R.id.userInput);
        recyclerView = findViewById(R.id.conversation);
        ArrayList<String> botResponseList = new  ArrayList<String>(
                List.of("Hello! I am Bob the bot. What is your name?",
                        "Nice to meet you! How are you doing today?",
                        "That's good. I'm feeling pretty good myself. But I am just a robot, so who cares?",
                        "Unfortunately, I can't really react appropriately as I do not have a database. Sorry.",
                        "Maybe I will one day, Maybe I'll have a user dependent response.",
                        "Until then, I guess i'll just stay as a hardcoded response bot."));
        responseMessageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(responseMessageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
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
                    if (!isVisible()) {
                        recyclerView.smoothScrollToPosition(messageAdapter.getItemCount()-1);
                    }
                }
                return true;
            }
        });
    }

    public boolean isVisible() {
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int lastItemPos = linearLayoutManager.findLastCompletelyVisibleItemPosition();
        int itemCount = recyclerView.getAdapter().getItemCount();
        return (lastItemPos >= itemCount);
    }
}