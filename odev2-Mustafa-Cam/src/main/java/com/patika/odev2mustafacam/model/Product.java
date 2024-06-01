    package com.patika.odev2mustafacam.model;


    import lombok.*;
//    import com.patika.odev2mustafacam.model.enums.Category
    import java.math.BigDecimal;
    import java.util.Objects;

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    @Builder
    public class Product {

        private String name;
        private BigDecimal amount;
        private String description;
        private Publisher publisher;
//        private Category category; //Enum
        private Category category;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return Objects.equals(name, product.name);
        }

    }
