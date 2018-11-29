package com.example.tjorv.hackthefuture.model

import android.arch.lifecycle.MutableLiveData
import com.github.kittinunf.fuel.httpGet
import org.json.JSONObject
import kotlin.collections.ArrayList
import android.arch.lifecycle.LiveData



class HtfApi {
    private val suppliesListObservable: LiveData<List<Supply>>? = null

    fun getSupplies(token : String) : MutableLiveData<List<Supply>>{
        val suppliesList: ArrayList<Supply> = ArrayList()

        val (_, _, result) = "https://htf2018.now.sh/supplies".httpGet()
            .header(mapOf("Content-Type" to "application/json"))
            .responseObject(Supply.Deserializer())
        val (supplies, err) = result
        if (err != null){
            throw err.exception
        }
        supplies!!.forEach { supply ->
            suppliesList.add(supply)
        }

        return MutableLiveData()
    }
}