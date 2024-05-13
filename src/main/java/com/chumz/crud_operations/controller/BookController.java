package com.chumz.crud_operations.controller;

import com.chumz.crud_operations.dto.BookRequest;
import com.chumz.crud_operations.dto.BookResponse;
import com.chumz.crud_operations.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BooksService booksService;

    //save
    @PostMapping("/books")
    public BookResponse saveBook(@Validated @RequestBody BookRequest bookRequest) {
        return booksService.saveBook(bookRequest);
    }

    //read
    @GetMapping("/books")
    public List<BookResponse> fetchBookList() {
        return booksService.fetchBookList();
    }

    //update
    @PutMapping("/books.{id}")
    public BookResponse updateBook(@RequestBody BookRequest bookRequest,
                                   @PathVariable("id") Long id) {
        return booksService.updateBook(bookRequest, id);
    }

    //delete
    public String deleteBookById(@PathVariable("id") Long id) {
        return "Deleted successfully";
    }


}
