package com.prueba.bcnc.shared.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * TariffDto
 */
@AllArgsConstructor
@Getter
@Setter
public class TariffDto {

    private final Long productId;
    private final Long brandId;
    private final Integer priceList;
    private final BigDecimal price;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
}

