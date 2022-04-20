package com.example.mesi_bike

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TimePicker
import java.util.*

class RentBikeActivity : AppCompatActivity() {
    private lateinit var startTimeButton: Button
    private lateinit var endTimeButton: Button
    public var timeUsed = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rent_bike)

        //code for setting start and end time of renting
        startTimeButton = findViewById(R.id.startTime)
        endTimeButton = findViewById(R.id.endTime)

        startTimeButton.setOnClickListener {
            val currentTime = Calendar.getInstance()
            val startHour = currentTime.get(Calendar.HOUR_OF_DAY)
            val startMinute = currentTime.get(Calendar.MINUTE)

            TimePickerDialog(this, R.style.ThemeTimePicker, {view, hourOfDay, minute ->
                startTimeButton.setText("Od $hourOfDay:$minute")
            }, startHour, startMinute, false).show()
        }

        endTimeButton.setOnClickListener {
            val currentTime = Calendar.getInstance()
            val startHour = currentTime.get(Calendar.HOUR_OF_DAY)
            val startMinute = currentTime.get(Calendar.MINUTE)

            TimePickerDialog(this, R.style.ThemeTimePicker, {view, hourOfDay, minute ->
                endTimeButton.setText("Do $hourOfDay:$minute")
            }, startHour, startMinute, false).show()
        }

        //calculating difference
        //TODO("poračunat čas izposoje in ga zapisati v bazo")


        //sector in company
        val sector = resources.getStringArray(R.array.sectors)
        val spinner = findViewById<Spinner>(R.id.companySector)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, sector
            )
            spinner.adapter = adapter
        }
    }
    //spinner.getSelectedItem();
}