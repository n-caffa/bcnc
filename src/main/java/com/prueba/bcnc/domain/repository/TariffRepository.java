package com.prueba.bcnc.domain.repository;

import com.prueba.bcnc.domain.model.Tariff;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * TariffRepository interface
 */
public interface TariffRepository {

    /**
     * Find applicable tariff
     */
    Optional<Tariff> findApplicableTariff(@NotNull Long productId,@NotNull Long brandId,@NotNull LocalDateTime applicationDate);

    boolean existsByProductId(Long productId);

    boolean existsByBrandId(Long brandId);
}
