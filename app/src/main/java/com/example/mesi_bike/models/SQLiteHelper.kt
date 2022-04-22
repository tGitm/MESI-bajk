package com.example.mesi_bike.models

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception

class SQLiteHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    // database data
    companion object{
        private val DATABASE_NAME = "MBAJK"
        private val DATABASE_VERSION = 1
        private val TABLE_NAME = "MesiBikes"
        private val IdBike = "Id"
        private val BikeName = "Name"
        private val Status = "Status"

        private val RES_TABLE = "Reservations"
        private val Id = "Id"
        private val Name = "Name"
        private val Sector = "Sector"
        private val Bike = "Bike"
        private val RentPurpose = "RentPurpose"
        private val Distance = "Distance"
        private val Time = "Time"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // creating table MesiBikes
        val createTableBikes = ("CREATE TABLE " + TABLE_NAME + " ("
                + IdBike + " INTEGER PRIMARY KEY, " +
                BikeName + " TEXT," +
                Status + " INTEGER" + ")")  //status = 1 (zasedeno), status = 0 (prosto)


        db?.execSQL(createTableBikes)

        // creating table Reservations
        val createTableReservations = ("CREATE TABLE " + RES_TABLE + " ("
                + Id + " TEXT PRIMARY KEY, " +
                Name + " TEXT," +
                Sector + " TEXT," +
                Bike + " TEXT," +
                RentPurpose + " TEXT," +
                Distance + " INTEGER," +
                Time + " TEXT" + ")")

        db?.execSQL(createTableReservations)

        db?.execSQL("INSERT INTO MesiBikes  VALUES(1, 'mBajk1', 0)")
        db?.execSQL("INSERT INTO MesiBikes  VALUES(2, 'mBajk2', 0)")
        db?.execSQL("INSERT INTO MesiBikes  VALUES(3, 'mBajk3', 0)")
        db?.execSQL("INSERT INTO MesiBikes  VALUES(4, 'mBajk4', 0)")
        db?.execSQL("INSERT INTO MesiBikes  VALUES(5, 'mBajk5', 0)")
        db?.execSQL("INSERT INTO MesiBikes  VALUES(6, 'mBajk6', 0)")
        db?.execSQL("INSERT INTO MesiBikes  VALUES(7, 'mBajk7', 0)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        db!!.execSQL("DROP TABLE IF EXISTS $RES_TABLE")
        onCreate(db)
    }

    // adding new bike
    fun insertBike(bikes: BikesModel): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(IdBike, bikes.Id)
        contentValues.put(BikeName, bikes.Name)
        contentValues.put(Status, bikes.Status)

        val success = db.insert(TABLE_NAME, null, contentValues)
        db.close()

        return success
    }

    // adding new reservation
    fun addReservation(res: ReservationModel): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(Id, res.Id)
        contentValues.put(Name, res.Name)
        contentValues.put(Sector, res.Sector)
        contentValues.put(Bike, res.Bike)
        contentValues.put(RentPurpose, res.RentPurpose)
        contentValues.put(Distance, res.Distance)
        contentValues.put(Time, res.Time)

        val success = db.insert(RES_TABLE, null, contentValues)
        db.close()

        return success
    }

    // updating status of bike
    fun updateStatusBike(newStatus: Int): Long {
        val db = this.writableDatabase
        val contentValues = ContentValues()

        contentValues.put(Status, newStatus)
        val success = db.insert(TABLE_NAME, null, contentValues)
        db.close()

        return success
    }

    // get all bikes
    @SuppressLint("Range")
    fun getBikes(): ArrayList<BikesModel> {
        val bikesList: ArrayList<BikesModel> = ArrayList()
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase
        val cursor: Cursor?

        try {
            cursor = db.rawQuery(selectQuery, null)

        } catch (e: Exception) {
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var id: Int
        var name: String
        var status: Int

        if (cursor.moveToFirst()) {
            do {
                id = cursor.getInt(cursor.getColumnIndex("Id"))
                name = cursor.getString(cursor.getColumnIndex("Name"))
                status = cursor.getInt(cursor.getColumnIndex("Status"))

                val bike = BikesModel(Id = id, Name = name, Status = status)
                bikesList.add(bike)
            } while (cursor.moveToNext())
        }
        return bikesList
    }
}