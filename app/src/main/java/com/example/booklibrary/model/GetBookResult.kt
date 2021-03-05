package com.example.booklibrary.model


class GetBookResult(
    var results: List<AvailableBooksModel>
) {
    constructor() : this(results = emptyList())
}
