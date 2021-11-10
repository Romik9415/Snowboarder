package com.regram.ai.data

import android.location.Location
import androidx.room.TypeConverter
import com.regram.ai.extensions.fromJson
import com.google.gson.Gson

class DbTypeConverter {

    @TypeConverter
    fun convertFromLocation(locationModel: Location?): String {
        if (locationModel != null) {
            return Gson().toJson(locationModel)
        }
        return ""
    }

    @TypeConverter
    fun convertToLocation(locationModel: String): Location? {
        if (locationModel.isNotBlank()) {
            return Gson().fromJson<Location>(locationModel)
        }
        return null
    }
}
