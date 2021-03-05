@file:Suppress("SpellCheckingInspection")
package com.example.booklibrary.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.booklibrary.repository.Repository
import com.example.booklibrary.model.GetBookResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

/**
 * Created by Kiran Kumar Choudhary on 02,March,2021).
 */

class BookViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: Repository? = null
    private var books = MutableLiveData<GetBookResult>()

    init {
        if (repository == null)
            repository =
                Repository(getApplication<Application>().applicationContext)
    }

    // return a live data
    fun getBookLiveData(): MutableLiveData<GetBookResult> {
        return books

    }

    //fetch data from API i.e. all the available books and notify the observers of live data
    fun getAvailableBooks() {
        CoroutineScope(IO).launch {
            val res = (repository?.getAllAvailableBooks())
            books.postValue(res)
        }
    }


}