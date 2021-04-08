package com.example.circle.ui.chatRooms;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ChatRoomsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ChatRoomsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is chat rooms fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}