package com.example.mesi_bike.models

class BikesList {
    var bikeId: Int
    var bikeName: String? = null
    var bikeStatus: Int

    constructor(bikeId: Int, bikeName: String?, bikeStatus: Int) {
        this.bikeId = bikeId
        this.bikeName = bikeName
        this.bikeStatus = bikeStatus
    }
}