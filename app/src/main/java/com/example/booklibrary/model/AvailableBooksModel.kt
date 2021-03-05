package com.example.booklibrary.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "book")
 class AvailableBooksModel(

    @SerializedName("book_author")
    var bookAuthor: String,
    @SerializedName("book_desc")
    var bookDesc: String,
    @SerializedName("book_id")
    @PrimaryKey
    var bookId: Int = 0,
    @SerializedName("book_img_url")
    var bookImgUrl: String,
    @SerializedName("book_name")
    var bookName: String,
    @SerializedName("book_price")
    var bookPrice: String

):Serializable