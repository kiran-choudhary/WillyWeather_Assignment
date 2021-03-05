@file:Suppress("SpellCheckingInspection")
package com.example.booklibrary.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.booklibrary.model.AvailableBooksModel

/**
 * Created by Kiran Kumar Choudhary on 02,March,2021).
 */


@Dao
interface BookDao {
    @Insert
    suspend fun insertAllBooks(availableBooksModel: List<AvailableBooksModel>?)

    @Query(value = "select * from book")
    fun getBooks(): List<AvailableBooksModel>
}