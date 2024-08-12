package com.prueba.bcnc.infrastructure.persistence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * TariffEntity class
 */
@Entity
@Table(name = "prices")
@Getter
@Setter
@NoArgsConstructor
public class TariffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand_id", nullable = false)
    private Long brandId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "price_list", nullable = false)
    private Integer priceList;

    @Column(name = "priority", nullable = false)
    private Integer priority;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "curr", nullable = false)
    private String currency;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

}
