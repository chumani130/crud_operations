package com.chumz.crud_operations.services;

import com.chumz.crud_operations.dto.BookRequest;
import com.chumz.crud_operations.dto.BookResponse;

import java.util.List;

public interface BooksService {

    // save
    BookResponse saveBook(BookRequest bookRequest);

    // read
    List<BookResponse> fetchBookList();

    // update
    BookResponse updateBook(BookRequest bookRequest, Long id);

    // delete
    void deleteBookById(Long id);
}
