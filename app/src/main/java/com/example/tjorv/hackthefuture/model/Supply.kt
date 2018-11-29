package com.example.tjorv.hackthefuture.model

data class Supply(var _id : Int,
                  var name : String,
                  var lat : Float,
                  var lng : Float,
                  var image : String,
                  var author : String,
                  var destined_user : String)