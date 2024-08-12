package com.prueba.bcnc.infrastructure.repository;

import com.prueba.bcnc.domain.model.Tariff;
import com.prueba.bcnc.domain.repository.TariffRepository;
import com.prueba.bcnc.infrastructure.persistence.TariffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * JpaTariffRepository interface
 */
@Repository
public interface JpaTariffRepository extends JpaRepository<TariffEntity, Long>, TariffRepository {

    /**
     * Find applicable tariff
     *
     */
    @Override
    default Optional<Tariff> findApplicableTariff(Long productId,Long brandId,LocalDateTime applicationDate) {

        return findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                productId, brandId, applicationDate, applicationDate
        ).map(entity -> new Tariff(
                entity.getBrandId(),
                entity.getProductId(),
                entity.getPriceList(),
                entity.getPriority(),
                entity.getPrice(),
                entity.getCurrency(),
                entity.getStartDate(),
                entity.getEndDate()
        ));
    }

    /**
     * Find first by product id, brand id, start date less than equal, end date greater than equal and order by priority desc
     *
     */
    Optional<TariffEntity> findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            Long productId,Long brandId,LocalDateTime startDate,LocalDateTime endDate);

    boolean existsByProductId(Long productId);

    boolean existsByBrandId(Long brandId);
    }


