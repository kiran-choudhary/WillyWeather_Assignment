@file:Suppress("SpellCheckingInspection")
package com.example.booklibrary.repository

import android.content.Context
import android.util.Log
import com.example.booklibrary.database.BookDatabase
import com.example.booklibrary.model.GetBookResult
import com.example.booklibrary.network.ApiInterface
import com.example.booklibrary.util.Utility
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.net.ConnectException


/**
 * Created by Kiran Kumar Choudhary on 02,March,2021).
 */


class Repository(private var context: Context) {

    // fetch books from REST Api
    suspend fun getAllAvailableBooks(): GetBookResult? {
        var availableBooks: GetBookResult? = null

        if(Utility.isNetworkAvailable(context)) {
            try {
                availableBooks = ApiInterface.retrofit.getAllAvailableBooks()
                addBooksInDb(availableBooks)
                Log.d("Dev", availableBooks.toString())
            } catch (e: ConnectException) {
                e.printStackTrace()
            }
        }else{
            availableBooks =  GetBookResult(BookDatabase.invoke(context).bookDao().getBooks())
        }

        return availableBooks
    }



    //add Books info in DB
    private suspend fun addBooksInDb(availableBooks: GetBookResult?) {
        CoroutineScope(IO).launch {
            try {
                BookDatabase.invoke(context).bookDao().insertAllBooks(availableBooks?.results)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}