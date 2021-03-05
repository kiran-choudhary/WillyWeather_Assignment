@file:Suppress("SpellCheckingInspection")
package com.example.booklibrary.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.booklibrary.R
import com.example.booklibrary.model.AvailableBooksModel
import com.example.booklibrary.viewModel.BookDetailViewModel
import com.example.booklibrary.viewModel.BookViewModel
import kotlinx.android.synthetic.main.book_detail.*

/**
 * Created by Kiran Kumar Choudhary on 02,March,2021).
 */

class BookDetailedActivity  : AppCompatActivity(){

    var book:BookDetailViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_detail)
        initView()
    }

    private fun initView() {
        //set actionbar title

        book = intent.getSerializableExtra(getString(R.string.book)) as? BookDetailViewModel
        supportActionBar!!.title = book?.getBookName()

        //set back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        book_detail_author.text =  getString(R.string.author_name,book?.getBookAuthor())
        book_detail_desc.text = book?.getBookDesc()
        book_detail_price.text = getString(R.string.book_price_value,book?.getBookPrice())
        try {
            //load image from URI to image view
            Glide.with(this)
                .load(book?.getBookImgUrl())
                .into(book_detail_image)
        } catch (e: Exception) {
            Log.e("dev", e.printStackTrace().toString())
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}