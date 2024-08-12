package com.prueba.bcnc.infrastructure.controller;

import com.prueba.bcnc.application.usecase.TariffUseCase;
import com.prueba.bcnc.shared.dto.TariffDto;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * The type Tariff controller.
 */
@RestController
@RequestMapping("/api/tariffs")
public class TariffController {
    private final TariffUseCase tariffUseCase;

    /**
     * Instantiates a new Tariff controller.
     *
     * @param tariffUseCase the tariff use case
     */
    public TariffController(@NotNull final TariffUseCase tariffUseCase) {
        this.tariffUseCase = tariffUseCase;
    }

    /**
     * Gets tariff.
     *
     * @param productId       the product id
     * @param brandId         the brand id
     * @param applicationDate the application date
     * @return the tariff
     */
    @GetMapping
    public ResponseEntity<TariffDto> getTariff(
            @RequestParam @NotNull Long productId,
            @RequestParam @NotNull Long brandId,
            @RequestParam @NotNull String applicationDate) {

        final var applicationDateTime = LocalDateTime.parse(applicationDate);
        final var tariffDto = this.tariffUseCase.getTariff(productId, brandId, applicationDateTime);

        return ResponseEntity.ok(tariffDto);
    }

}
