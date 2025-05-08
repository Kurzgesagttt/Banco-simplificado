package com.kurzgts.PicPay.dtov2;

import java.util.Date;

public record ErroResponseDTO(
        String message,
        String details,
        Date date
) {
}
