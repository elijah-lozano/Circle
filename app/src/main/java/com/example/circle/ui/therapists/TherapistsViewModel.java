package com.example.circle.ui.therapists;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TherapistsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TherapistsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is therapists fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}