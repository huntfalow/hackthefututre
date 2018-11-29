package com.example.tjorv.hackthefuture.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable

data class Supply(var _id : Int,
                  var name : String,
                  var lat : Float,
                  var lng : Float,
                  var image : String,
                  var author : String,
                  var destined_user : String) : Serializable {

    class Token : TypeToken<List<Supply>>()

    class Deserializer : ResponseDeserializable<ArrayList<Supply>> {
        override fun deserialize(content: String): ArrayList<Supply>? = Gson().fromJson(content, Token().type)
    }
}