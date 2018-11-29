package com.example.tjorv.hackthefuture.viewModels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.tjorv.hackthefuture.model.HtfApi
import com.example.tjorv.hackthefuture.model.Supply
import android.arch.lifecycle.LiveData



class MainViewModel(token : String) : ViewModel() {
    private var supplyList = MutableLiveData<List<Supply>>()

    init {
        supplyList = HtfApi().getSupplies(token)
    }

    fun getSupplyListObservable(): LiveData<List<Supply>> {
        return supplyList
    }
}