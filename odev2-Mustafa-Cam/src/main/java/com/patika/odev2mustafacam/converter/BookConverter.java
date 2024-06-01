package com.patika.odev2mustafacam.converter;


import com.patika.odev2mustafacam.dto.request.BookSaveRequest;
import com.patika.odev2mustafacam.model.Book;
import com.patika.odev2mustafacam.model.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE) // nesne oluşturulmasın diye.

public class BookConverter {

//    public static Book toBook(BookSaveRequest bookSaveRequest) {
//        return Book.builder()
//                .name(bookSaveRequest.getName())
//                .amount(bookSaveRequest.getAmount())
//                .description(bookSaveRequest.getDescription())
//                .author(bookSaveRequest.getAuthor())
//                .build();
//    }
}
