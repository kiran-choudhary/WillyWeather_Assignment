package com.example.booklibrary

import com.example.booklibrary.model.AvailableBooksModel
import java.util.*

/**
 * Created by Kiran Kumar Choudhary on 05,March,2021).
 */
class FakeRandomBookGenratorAPI {

    companion object {
        val BOOK_NAME = "Hamlet"
        val BOOK_DESC = "The Tragedy of Hamlet, Prince of Denmark, or more simply Hamlet, is a tragedy by William Shakespeare, believed to have been written between 1599 and 1601."
        val IMG_URL = "http://15.206.209.151/covers/hamlet_cover.jpg"
        val BOOK_PRICE = "1200"
        val BOOK_AUTHOR = "William Shakespeare"

        fun getBooksList(): MutableList<AvailableBooksModel?> {
            val books: MutableList<AvailableBooksModel?> = ArrayList<AvailableBooksModel?>()
            for (i in 0..9) {
                books.add(getBookObject())
            }
            return books
        }

        fun getBookObject() : AvailableBooksModel? {
            return AvailableBooksModel(
            bookAuthor = BOOK_AUTHOR,
            bookDesc = BOOK_DESC,
            bookName = BOOK_NAME,
            bookPrice = BOOK_PRICE,
            bookImgUrl = IMG_URL)
        }

    }

}