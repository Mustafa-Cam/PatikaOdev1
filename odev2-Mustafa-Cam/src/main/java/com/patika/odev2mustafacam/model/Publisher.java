package com.patika.odev2mustafacam.model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Publisher {

    private Long id;
    private String name;
    private LocalDate creatDate;
    //private List<Book> bookList; //model olarak bunu yapmadık.

}
