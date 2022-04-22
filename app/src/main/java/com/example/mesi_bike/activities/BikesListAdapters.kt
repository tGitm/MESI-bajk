package com.example.mesi_bike.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mesi_bike.R
import com.example.mesi_bike.models.BikesModel

class BikesListAdapters : RecyclerView.Adapter<BikesListAdapters.BikeViewHolder>() {
    private var bikesList: ArrayList<BikesModel> = ArrayList()

    fun addItems(items: ArrayList<BikesModel>) {
        this.bikesList = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BikeViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.bikes_list_view, parent, false)
    )

    override fun onBindViewHolder(holder: BikeViewHolder, position: Int) {
        val bike = bikesList[position]
        holder.bindView(bike)
    }

    override fun getItemCount(): Int {
        return bikesList.size
    }

    class BikeViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        private var bikeId: TextView = view.findViewById(R.id.bike_id)
        private var bikeName: TextView = view.findViewById(R.id.bike_name)
        private var bikeStatus: TextView = view.findViewById(R.id.bike_status)

        fun bindView(bike: BikesModel) {
            bikeId.text = "#" + bike.Id.toString()
            bikeName.text = bike.Name

            var status = ""
            if (bike.Status == 1)
                status = "Izposojeno"
            else
                status = "Na voljo"

            bikeStatus.text = status

        }
    }

}