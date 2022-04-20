package com.example.mesi_bike

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class BikesListAdapters(var context: Context, var arrayList: ArrayList<BikesList>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(p0: Int): Any {
        return arrayList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    //get the needed items from view
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View = View.inflate(context, R.layout.bikes_list_view, null)

        var bikeName: TextView = view.findViewById(R.id.bike_name)
        var bikeStatus: TextView = view.findViewById(R.id.bike_status)
        var bikesList: BikesList = arrayList.get(p0)

        bikeName.text = bikesList.bikeName
        bikeStatus.text = bikesList.bikeStatus.toString()

        return view

    }

}