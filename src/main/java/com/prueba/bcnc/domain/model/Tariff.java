package com.prueba.bcnc.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * The type Tariff.
 */
@Getter
@Setter
@AllArgsConstructor
public class Tariff {

    private Long brandId;
    private Long productId;
    private Integer priceList;
    private Integer priority;
    private BigDecimal price;
    private String currency;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
