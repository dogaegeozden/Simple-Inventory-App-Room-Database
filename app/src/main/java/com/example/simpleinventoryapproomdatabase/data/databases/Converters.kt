package com.example.simpleinventoryapproomdatabase.data.databases

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.util.Date

/**
* This is a type converter to convert data types before putting them into the database.
*/
class Converters {

    @TypeConverter
    fun fromDate(date : Date) : Long{
        return date.time
    }

    @TypeConverter
    fun toDate(time : Long) : Date{
        return Date(time)
    }

}