package com.patika.odev2mustafacam.exception;

import com.patika.odev2mustafacam.dto.response.ExceptionResponse;
import com.patika.odev2mustafacam.dto.response.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(KitapYurdumException.class)// annotation: Bu annotation, belirli bir türdeki istisnaları ele alacak olan metodu işaretler. Burada KitapYurdumException sınıfından gelen istisnaları ele alacak bir metot olduğu belirtilmiştir.
    public GenericResponse<ExceptionResponse> handleException(KitapYurdumException exception) {
        log.error(exception.getLocalizedMessage());
        return GenericResponse.failed(exception.getMessage());
    }
}
