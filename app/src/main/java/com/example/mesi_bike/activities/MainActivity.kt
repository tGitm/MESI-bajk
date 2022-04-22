package com.example.mesi_bike.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mesi_bike.R
import com.example.mesi_bike.models.BikesList
import com.example.mesi_bike.models.BikesModel
import com.example.mesi_bike.models.SQLiteHelper

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private lateinit var recycleView: RecyclerView
    private var adapter: BikesListAdapters? = null
    private var db: SQLiteHelper = SQLiteHelper(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        // adding new bikes
        db.insertBike(BikesModel(Id = 1, Name = "mBajk1", Status = 0))
        db.insertBike(BikesModel(Id = 2, Name = "mBajk2", Status = 0))
        db.insertBike(BikesModel(Id = 3, Name = "mBajk3", Status = 0))
        db.insertBike(BikesModel(Id = 4, Name = "mBajk4", Status = 0))
        db.insertBike(BikesModel(Id = 5, Name = "mBajk5", Status = 0))
        db.insertBike(BikesModel(Id = 6, Name = "mBajk6", Status = 0))
        db.insertBike(BikesModel(Id = 7, Name = "mBajk7", Status = 0))
*/
        // getting view from layout
        initView()
        initRecycleView()
        getBikes()

        //button clicked
        val buttonClick = findViewById<Button>(R.id.add_bike_button)
        buttonClick.setOnClickListener {
            val intent = Intent(this, RentBikeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getBikes() {
        val bikesList = db.getBikes()
        adapter?.addItems(bikesList)
    }

    private fun initRecycleView() {
        recycleView.layoutManager = LinearLayoutManager(this)
        adapter = BikesListAdapters()
        recycleView.adapter = adapter
    }

    private fun initView() {
        recycleView = findViewById(R.id.bike_list)
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("za vsako kolo naj bo omogočen pregled zadnje in predhodnje rezervacije, število vseh prevoženih\n" +
                    "kilometrov in število rezervacij glede na namen izposoje in sektor podjetja -> PopUp z informacijami o kolesu")
    }
}