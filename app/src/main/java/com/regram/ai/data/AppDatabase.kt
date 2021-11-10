package com.regram.ai.data

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.regram.ai.AppExecutors
import com.regram.ai.data.database.dao.UserDao
import com.regram.ai.ui.main.User

@Database(
    entities = [
        User::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    var isDataBaseCreated = MutableLiveData<Boolean>()

    companion object {
        private const val dbName = "fleetsu_db"
        private var dbInstance: AppDatabase? = null

        fun getInstance(app: Application, appExecutors: AppExecutors): AppDatabase {
            if (dbInstance == null) {
                synchronized(AppDatabase::class.java) {
                    dbInstance = createDataBase(app, appExecutors)
                    dbInstance!!.updateDatabaseCreated(app)
                }
            }
            return dbInstance!!
        }

        private fun createDataBase(app: Application, appExecutors: AppExecutors): AppDatabase {
            return Room.databaseBuilder(app.applicationContext, AppDatabase::class.java, dbName)
                .build()
        }
    }


    private fun updateDatabaseCreated(context: Context) {
        if (context.getDatabasePath(dbName).exists()) {
            provideDatabaseCreated()
        }
    }

    private fun provideDatabaseCreated() {
        isDataBaseCreated.postValue(true)
    }

    abstract fun userDao(): UserDao

}