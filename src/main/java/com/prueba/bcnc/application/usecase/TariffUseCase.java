package com.prueba.bcnc.application.usecase;

import com.prueba.bcnc.domain.repository.TariffRepository;
import com.prueba.bcnc.shared.dto.TariffDto;
import com.prueba.bcnc.shared.exception.BrandNotFoundException;
import com.prueba.bcnc.shared.exception.ProductNotFoundException;
import com.prueba.bcnc.shared.exception.TariffNotFoundException;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * TariffUseCase
 */
@Service
public class TariffUseCase {

    private final TariffRepository tariffRepository;

    /**
     * Instantiates a new Tariff use case.
     *
     * @param tariffRepository the tariff repository
     */
    public TariffUseCase(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    /**
     * Gets tariff.
     *
     * @param productId       the product id
     * @param brandId         the brand id
     * @param applicationDate the application date
     * @return the tariff
     */
    public TariffDto getTariff(@NotNull Long productId,@NotNull Long brandId,@NotNull LocalDateTime applicationDate) {

        if (!tariffRepository.existsByProductId(productId)) {
            throw new ProductNotFoundException("Product with ID " + productId + " not found in the database.");
        }

        if (!tariffRepository.existsByBrandId(brandId)) {
            throw new BrandNotFoundException("Brand with ID " + brandId + " not found in the database.");
        }

        final var tariff = this.tariffRepository.findApplicableTariff(productId, brandId, applicationDate)
                .orElseThrow(() -> new TariffNotFoundException("No applicable tariff found for product ID " + productId +
                        ", brand ID " + brandId + " and date " + applicationDate));
        return new TariffDto(
                tariff.getProductId(),
                tariff.getBrandId(),
                tariff.getPriceList(),
                tariff.getPrice(),
                tariff.getStartDate(),
                tariff.getEndDate()
        );
    }

}
