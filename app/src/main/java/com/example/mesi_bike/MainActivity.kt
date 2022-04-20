package com.example.mesi_bike

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private var listView: ListView? = null
    private var bikesListAdapters: BikesListAdapters? = null
    private var bikes: ArrayList<BikesList>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.bikes_list_view)
        bikes = ArrayList()
        bikes = setDataArrayList()
        bikesListAdapters = BikesListAdapters(applicationContext, bikes!!)
        listView?.adapter = bikesListAdapters
    }

    private fun setDataArrayList(): ArrayList<BikesList> {

        var bikes: ArrayList<BikesList> = ArrayList()

        bikes.add(
            BikesList("mBajk 1", true)
        )
        bikes.add(
            BikesList("mBajk 2", false)
        )
        bikes.add(
            BikesList("mBajk 3", false)
        )
        bikes.add(
            BikesList("mBajk 4", true)
        )
        bikes.add(
            BikesList("mBajk 5", true)
        )
        bikes.add(
            BikesList("mBajk 6", false)
        )
        bikes.add(
            BikesList("mBajk 7", true)
        )
        return bikes!!

        TODO("kolesa se morajo prebrati iz SQLite baze")
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("za vsako kolo naj bo omogočen pregled zadnje in prihodnje rezervacije, število vseh prevoženih\n" +
                    "kilometrov in število rezervacij glede na namen izposoje in sektor podjetja -> PopUp z informacijami o kolesu")
    }
}