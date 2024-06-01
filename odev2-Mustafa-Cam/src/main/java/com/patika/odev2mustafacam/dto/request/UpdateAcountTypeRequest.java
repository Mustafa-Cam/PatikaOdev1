package com.patika.odev2mustafacam.dto.request;

import com.patika.odev2mustafacam.model.enums.AccountType;
import lombok.Data;

@Data
public class UpdateAcountTypeRequest {
    private AccountType acountType;
}
