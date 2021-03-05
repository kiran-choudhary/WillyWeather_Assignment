@file:Suppress("SpellCheckingInspection")
package com.example.booklibrary.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.booklibrary.model.AvailableBooksModel

/**
 * Created by Kiran Kumar Choudhary on 02,March,2021).
 */


@Database(
    entities = [AvailableBooksModel::class],
    version = 1
)
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao


    companion object {

        private var instance: BookDatabase? = null

        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                BookDatabase::class.java, "book.db"
            ).build()
    }
}
