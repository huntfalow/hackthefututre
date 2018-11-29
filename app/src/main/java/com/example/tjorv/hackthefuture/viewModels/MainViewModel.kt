package com.example.tjorv.hackthefuture.viewModels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.tjorv.hackthefuture.model.HtfApi
import com.example.tjorv.hackthefuture.model.Supply
import android.arch.lifecycle.LiveData



class MainViewModel : ViewModel() {

    fun getSupplyListObservable(token : String): LiveData<List<Supply>> {
        return HtfApi().getSupplies(token)
    }
}