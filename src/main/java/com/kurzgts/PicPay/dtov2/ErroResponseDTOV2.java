package com.kurzgts.PicPay.dtov2;

import java.util.Date;

public record ErroResponseDTOV2(
        String message,
        String details,
        Date date
) {
}
