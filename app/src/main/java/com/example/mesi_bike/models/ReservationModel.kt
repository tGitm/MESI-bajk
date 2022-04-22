package com.example.mesi_bike.models

import android.text.Editable


data class ReservationModel(
    var Id: String,
    var Name: String,
    var Sector: String,
    var Bike: String,
    var RentPurpose: String,
    var Distance: Float,
    var Time: String
)