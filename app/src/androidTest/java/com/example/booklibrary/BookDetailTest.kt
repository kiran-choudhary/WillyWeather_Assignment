package com.example.booklibrary

import com.example.booklibrary.model.AvailableBooksModel
import com.example.booklibrary.viewModel.BookDetailViewModel
import org.junit.Test
import org.junit.Assert.assertEquals

import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


/**
 * Created by Kiran Kumar Choudhary on 05,March,2021).
 */
@RunWith(MockitoJUnitRunner::class)
public class BookDetailTest{

    @Test
    public fun shouldGetURLPicture(){
        val book : AvailableBooksModel? = getBook()
        val bookDetailViewModel = getBookDetailViewModel(book)
        assertEquals(book?.bookImgUrl,bookDetailViewModel?.getBookImgUrl())
    }

    @Test
    public fun shouldGetPrice(){
        val book : AvailableBooksModel? = getBook()
        val bookDetailViewModel = getBookDetailViewModel(book)
        assertEquals(book?.bookPrice,bookDetailViewModel?.getBookPrice())
    }

    @Test
    public fun shouldGetBookName(){
        val book : AvailableBooksModel? = getBook()
        val bookDetailViewModel = getBookDetailViewModel(book)
        assertEquals(book?.bookName,bookDetailViewModel?.getBookName())
    }

    @Test
    public fun shouldGetBookDesc(){
        val book : AvailableBooksModel? = getBook()
        val bookDetailViewModel = getBookDetailViewModel(book)
        assertEquals(book?.bookDesc,bookDetailViewModel?.getBookDesc())
    }

    @Test
    public fun shouldGetAuthor(){
        val book : AvailableBooksModel? = getBook()
        val bookDetailViewModel = getBookDetailViewModel(book)
        assertEquals(book?.bookAuthor,bookDetailViewModel?.getBookAuthor())
    }

    private fun getBook(): AvailableBooksModel? {
        return FakeRandomBookGenratorAPI.getBookObject()
    }

    private fun getBookDetailViewModel(book: AvailableBooksModel?): BookDetailViewModel? {
        return BookDetailViewModel(book)
    }
}