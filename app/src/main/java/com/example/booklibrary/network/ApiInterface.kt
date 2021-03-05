@file:Suppress("SpellCheckingInspection")

package com.example.booklibrary.network

import androidx.annotation.Nullable
import com.example.booklibrary.model.GetBookResult
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by Kiran Kumar Choudhary on 02,March,2021).
 */


//http://15.206.209.151/api/getAllAvailableBooks

const val BASE_URL = "http://15.206.209.151/api/"

interface ApiInterface {

    @GET(value = "getAllAvailableBooks")
    suspend fun getAllAvailableBooks(): GetBookResult

    companion object {

        @Nullable val retrofit  = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiInterface::class.java)
    }


}

