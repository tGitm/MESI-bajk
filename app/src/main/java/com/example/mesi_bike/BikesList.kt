package com.example.mesi_bike

class BikesList {
    var bikeName: String? = null
    var bikeStatus: Boolean = true

    constructor(bikeName: String?, bikeStatus: Boolean) {
        this.bikeName = bikeName
        this.bikeStatus = bikeStatus
    }
}