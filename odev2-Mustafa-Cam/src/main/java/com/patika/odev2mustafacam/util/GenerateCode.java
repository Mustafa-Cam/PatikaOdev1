package com.patika.odev2mustafacam.util;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component // Spring tarafından yönetilen bir bileşen olarak işaretlenmeli
@NoArgsConstructor
public class GenerateCode {
    private int ordercodeplus=10;

    public String generateOrderCode() {
        // Get the current timestamp
        ordercodeplus+=1;
        LocalDateTime now = LocalDateTime.now();

        // Format the timestamp as a unique order code
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddHHmmss"+ordercodeplus);

        return now.format(formatter);
    }
}
