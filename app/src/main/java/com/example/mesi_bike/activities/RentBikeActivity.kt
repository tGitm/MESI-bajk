package com.example.mesi_bike.activities

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.*
import com.example.mesi_bike.R
import com.example.mesi_bike.models.ReservationModel
import com.example.mesi_bike.models.SQLiteHelper
import com.google.android.material.slider.Slider
import com.google.android.material.textfield.TextInputEditText
import java.util.*

class RentBikeActivity : AppCompatActivity() {
    private lateinit var startTimeButton: Button
    private lateinit var endTimeButton: Button
    private lateinit var inputName: TextInputEditText
    private lateinit var rentPurpose: TextInputEditText
    private lateinit var addReservation: Button
    private lateinit var cancelReservation: Button
    private lateinit var sectorSpinner: Spinner
    private lateinit var bikesSpinner: Spinner
    private lateinit var kmSlider: Slider
    private var db: SQLiteHelper = SQLiteHelper(this)

    public var timeUsed = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rent_bike)

        // getting fields from xml by id
        startTimeButton = findViewById(R.id.startTime)
        endTimeButton = findViewById(R.id.endTime)
        inputName = findViewById(R.id.name)
        rentPurpose = findViewById(R.id.purposeInput)
        addReservation = findViewById(R.id.add_bike_button)
        cancelReservation = findViewById(R.id.cancel_button)
        sectorSpinner = findViewById(R.id.companySector)
        bikesSpinner = findViewById(R.id.chooseBike)
        kmSlider = findViewById(R.id.slider)


        // code for setting start and end time of renting
        startTimeButton.setOnClickListener {
            val currentTime = Calendar.getInstance()
            val startHour = currentTime.get(Calendar.HOUR_OF_DAY)
            val startMinute = currentTime.get(Calendar.MINUTE)

            TimePickerDialog(this, {view, hourOfDay, minute ->
                startTimeButton.setText("Od $hourOfDay:$minute")
            }, startHour, startMinute, false).show()
        }

        endTimeButton.setOnClickListener {
            val currentTime = Calendar.getInstance()
            val startHour = currentTime.get(Calendar.HOUR_OF_DAY)
            val startMinute = currentTime.get(Calendar.MINUTE)

            TimePickerDialog(this, {view, hourOfDay, minute ->
                endTimeButton.setText("Do $hourOfDay:$minute")
            }, startHour, startMinute, false).show()
        }

        // calculating time
        //TODO("poračunat čas izposoje in ga zapisati v bazo")


        // sector in company
        val sector = resources.getStringArray(R.array.sectors)
        val spinner = findViewById<Spinner>(R.id.companySector)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, sector
            )
            spinner.adapter = adapter
        }

        // choosing a bike
        val bikes = resources.getStringArray(R.array.bikes)
        val spinnerBikes = findViewById<Spinner>(R.id.chooseBike)
        if (spinnerBikes != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, bikes
            )
            spinnerBikes.adapter = adapter
        }

        val name = inputName.text
        val purpose = rentPurpose.text
        var distance: Double
        var time: String

        val sectorSpin = sectorSpinner.getSelectedItem()
        val bikeSpin = bikesSpinner.getSelectedItem()

        // generating random id
        fun randomID(): String = List(16) {
            (('a'..'z') + ('A'..'Z') + ('0'..'9')).random()
        }.joinToString("")
        val id = randomID()

        var kilometers: Float
        kmSlider.addOnChangeListener { kmSlider, value, fromUser ->
            kilometers = kmSlider.value
            Log.d("km", kilometers.toString())
        }


        // returning error message if fields are empty on button clicked
        addReservation.setOnClickListener {
            if (inputName.text!!.isNotEmpty() && rentPurpose.text!!.isNotEmpty()) {
                db.addReservation(ReservationModel(Id = id, Name = name.toString(), Sector = sectorSpin.toString(), RentPurpose = purpose.toString(), Bike = bikeSpin.toString(), Distance = 0.0f, Time = "00:00"))
                Toast.makeText(this, "Rezervacija dodana", Toast.LENGTH_SHORT).show()

                // going back to home screen after 3s
                Handler().postDelayed(Runnable {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }, 3000)
            }
            else {
                Toast.makeText(this, "NAPAKA! Vsa polja so obvezna!", Toast.LENGTH_SHORT).show()
            }
        }

        // exiting reservation screen
        cancelReservation.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}