package com.example.booklibrary.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booklibrary.ICallBack
import com.example.booklibrary.R
import com.example.booklibrary.adapter.BooksAdapter
import com.example.booklibrary.model.AvailableBooksModel
import com.example.booklibrary.viewModel.BookDetailViewModel
import com.example.booklibrary.viewModel.BookViewModel
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity(),ICallBack {

    private lateinit var recyclerView: RecyclerView
    private var booksAdapter: BooksAdapter? = null
    private var viewModel: BookViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)
        initView()
    }

    private fun initView() {
        //set actionbar title
        supportActionBar!!.title = "Books"

        viewModel = ViewModelProvider(this@BooksActivity).get(BookViewModel::class.java)

        recyclerView = findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.itemAnimator = DefaultItemAnimator()



        viewModel?.getBookLiveData()?.observe(this, Observer {

            //working with live data to build recycler view adapter
            // if data is not null show it in recycler view else show a message to user "No books available !!"

            if (it != null && it.results.isNotEmpty()) {
                nothing.visibility = View.INVISIBLE
                recyclerView.adapter = BooksAdapter(this@BooksActivity, it,this)
                booksAdapter?.notifyDataSetChanged()
            } else {
                nothing.visibility = View.VISIBLE
            }
        })

        viewModel?.getAvailableBooks()
    }

    // back button handling via arrow in toolbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun handleClick(book: AvailableBooksModel?) {
        var bookDetailViewModel =  getBookDetailViewModel(book)
        val intent = Intent(this,BookDetailedActivity::class.java)
        intent.putExtra(getString(R.string.book),bookDetailViewModel)
        startActivity(intent)
    }

    private fun getBookDetailViewModel(book: AvailableBooksModel?): BookDetailViewModel? {
        return BookDetailViewModel(book)
    }
}
