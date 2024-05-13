package com.chumz.crud_operations.services;

import com.chumz.crud_operations.dto.BookRequest;
import com.chumz.crud_operations.dto.BookResponse;
import com.chumz.crud_operations.entity.BookEntity;
import com.chumz.crud_operations.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    //read
    @Override
    public List<BookResponse> fetchBookList() {
        List<BookResponse> bookResponses = new ArrayList<>();
        List<BookEntity> bookEntities = bookRepo.findAll();

        for (int i = 0; i < bookEntities.size(); i++) {
            BookResponse bookResponse = BookResponse.builder()
                    .name(bookEntities.get(i).getName())
                    .author(bookEntities.get(i).getAuthor())
                    .price(bookEntities.get(i).getPrice()).build();
            bookResponses.add(bookResponse);
        }
        return bookResponses;
    }

    // update
    @Override
    public BookResponse updateBook(BookRequest bookRequest, Long id) {
        BookEntity bookDB = bookRepo.findById(id).get();

        if (Objects.nonNull(bookRequest.getName()) && !"".equalsIgnoreCase(
                bookRequest.getName())) {
            bookDB.setName(bookRequest.getName());
        }
        if (Objects.nonNull(bookRequest.getAuthor()) && !"".equalsIgnoreCase(
                bookRequest.getAuthor())) {
            bookDB.setAuthor(bookRequest.getAuthor());
        }
        if (Objects.nonNull(bookRequest.getPrice()) && !"".equalsIgnoreCase(
                bookRequest.getPrice())) {
            bookDB.setPrice(bookRequest.getPrice());
        }
        BookEntity bookEntity = bookRepo.save(bookDB);
        return BookResponse.builder().name(bookEntity.getName())
                .author(bookEntity.getAuthor())
                .price(bookEntity.getPrice()).build();
    }
    @Override
    public void deleteBookById(Long id) {
        bookRepo.deleteById(id);

    }

}
