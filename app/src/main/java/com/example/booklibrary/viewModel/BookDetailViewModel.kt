package com.example.booklibrary.viewModel

import com.example.booklibrary.model.AvailableBooksModel
import java.io.Serializable

/**
 * Created by Kiran Kumar Choudhary on 05,March,2021).
 */
class BookDetailViewModel :Serializable{
    var book :AvailableBooksModel? = null

    constructor(booksModel: AvailableBooksModel?) {
        book = booksModel
    }

    public fun getBookAuthor():String?{
        return book?.bookAuthor;
    }

    public fun getBookDesc():String?{
        return book?.bookDesc;
    }

    public fun getBookId():Int?{
        return book?.bookId;
    }

    public fun getBookImgUrl():String?{
        return book?.bookImgUrl;
    }

    public fun getBookName():String?{
        return book?.bookName;
    }

    public fun getBookPrice():String?{
        return book?.bookPrice;
    }
}