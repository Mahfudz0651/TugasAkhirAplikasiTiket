package com.example.aplikasitiket.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.aplikasitiket.database.dao.DatabaseDao
import com.example.aplikasitiket.model.ModelDatabase

@Database(entities = [ModelDatabase::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao?
}