package com.chumz.crud_operations.services;

import com.chumz.crud_operations.dto.BookRequest;
import com.chumz.crud_operations.dto.BookResponse;
import com.chumz.crud_operations.entity.BookEntity;
import com.chumz.crud_operations.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServicesImpl implements BooksService{

    @Autowired
    private BookRepo bookRepo;

    // save
    @Override
    public BookResponse saveBook(BookRequest bookRequest) {
        BookEntity bookEntity = bookRepo.save(BookEntity.builder()
                .name(bookRequest.getName())
                .author(bookRequest.getAuthor())
                .price(bookRequest.getPrice()).build());

        return BookResponse.builder().name(bookEntity.getName())
                .author(bookEntity.getAuthor())
                .price(bookEntity.getPrice()).build();
    }

    @Override
    public List<BookResponse> fetchBookList() {
        return List.of();
    }

    @Override
    public BookResponse updateBook(BookRequest bookRequest, Integer id) {
        return null;
    }

    @Override
    public void deleteBookById(Integer id) {

    }

}
