package com.example.tjorv.hackthefuture.model

import android.arch.lifecycle.MutableLiveData
import java.util.*
import kotlin.collections.ArrayList

class HtfApi {
    fun getSupplies(token : String) : MutableLiveData<List<Supply>>{
        val tempList = ArrayList<Supply>()
        val returnList = MutableLiveData<List<Supply>>()

        tempList.add(Supply(0,"Test", 0F,0F,"Test","Test","Test"))
        returnList.value = tempList
        return returnList
    }
}