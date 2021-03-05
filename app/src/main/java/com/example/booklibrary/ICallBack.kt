@file:Suppress("SpellCheckingInspection")
package com.example.booklibrary

import com.example.booklibrary.model.AvailableBooksModel

/**
 * Created by Kiran Kumar Choudhary on 01,March,2021).
 */
interface ICallBack {
    fun handleClick(availableBooksModel:  AvailableBooksModel?)
}