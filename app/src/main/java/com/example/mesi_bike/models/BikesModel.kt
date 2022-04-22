package com.example.mesi_bike.models
import java.util.*

data class BikesModel (
    var Id: Int,
    var Name: String = "",
    var Status: Int = 0
){
    companion object {
        fun getAutoId(): Int {
            val random = Random()
            return random.nextInt(100)
        }
    }
}