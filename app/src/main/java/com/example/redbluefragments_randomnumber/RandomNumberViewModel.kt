package com.example.redbluefragments_randomnumber

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RandomNumberViewModel: ViewModel() {
    var randomNumber = MutableLiveData(0) // MutableLiveData<T>()
}