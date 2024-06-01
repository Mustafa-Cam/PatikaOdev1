package com.patika.odev2mustafacam.dto.response;

import com.patika.odev2mustafacam.model.Category;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponse {
    private Category CategoryName;
}
