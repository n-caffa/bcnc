package com.prueba.bcnc;

import com.prueba.bcnc.application.usecase.TariffUseCase;
import com.prueba.bcnc.domain.model.Tariff;
import com.prueba.bcnc.domain.repository.TariffRepository;
import com.prueba.bcnc.shared.exception.ProductNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * The type Tariff service application tests.
 */
class TariffServiceApplicationTests {
    @Mock
    private TariffRepository tariffRepository;
    @InjectMocks
    private TariffUseCase getTariffUseCase;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test get tariff at 10 am on 14 th.
     */
    @Test
    void testGetTariffAt10AMOn14th() {

        // Given
        final var productId = 35455L;
        final var brandId = 1L;
        final var applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);

        final var expectedTariff = new Tariff(brandId, productId, 1, 0, BigDecimal.valueOf(35.50), "EUR",
                LocalDateTime.of(2020, 6, 14, 0, 0),
                LocalDateTime.of(2020, 12, 31, 23, 59, 59));

        // When
        when(tariffRepository.existsByProductId(35455L)).thenReturn(true);
        when(tariffRepository.existsByBrandId(1L)).thenReturn(true);
        when(tariffRepository.findApplicableTariff(productId, brandId, applicationDate)).thenReturn(Optional.of(expectedTariff));

        final var result = getTariffUseCase.getTariff(productId, brandId, applicationDate);

        // Then
        assertNotNull(result);
        assertEquals(productId, result.getProductId());
        assertEquals(brandId, result.getBrandId());
        assertEquals(1, result.getPriceList());
        assertEquals(BigDecimal.valueOf(35.50), result.getPrice());

        verify(tariffRepository, times(1)).findApplicableTariff(productId, brandId, applicationDate);
    }

    /**
     * Test get tariff at 4 pm on 14 th.
     */
    @Test
     void testGetTariffAt4PMOn14th() {

         // Given
         final var productId = 35455L;
         final var brandId = 1L;
         final var applicationDate = LocalDateTime.of(2020, 6, 14, 16, 0);

         final var expectedTariff = new Tariff(brandId, productId, 2, 1, BigDecimal.valueOf(25.45), "EUR",
                 LocalDateTime.of(2020, 6, 14, 15, 0),
                 LocalDateTime.of(2020, 6, 14, 18, 30));

         // When
         when(tariffRepository.existsByProductId(35455L)).thenReturn(true);
         when(tariffRepository.existsByBrandId(1L)).thenReturn(true);
         when(tariffRepository.findApplicableTariff(productId, brandId, applicationDate)).thenReturn(Optional.of(expectedTariff));

         final var result = getTariffUseCase.getTariff(productId, brandId, applicationDate);

         // Then
         assertNotNull(result);
         assertEquals(productId, result.getProductId());
         assertEquals(brandId, result.getBrandId());
         assertEquals(2, result.getPriceList());
         assertEquals(BigDecimal.valueOf(25.45), result.getPrice());

         verify(tariffRepository, times(1)).findApplicableTariff(productId, brandId, applicationDate);
     }

    /**
     * Test get tariff at 9 pm on 14 th.
     */
    @Test
    void testGetTariffAt9PMOn14th() {

        // Given
        final var productId = 35455L;
        final var brandId = 1L;
        final var applicationDate = LocalDateTime.of(2020, 6, 14, 21, 0);

        final var expectedTariff = new Tariff(brandId, productId, 1, 0, BigDecimal.valueOf(35.50), "EUR",
                LocalDateTime.of(2020, 6, 14, 0, 0),
                LocalDateTime.of(2020, 12, 31, 23, 59, 59));

        // When
        when(tariffRepository.existsByProductId(35455L)).thenReturn(true);
        when(tariffRepository.existsByBrandId(1L)).thenReturn(true);
        when(tariffRepository.findApplicableTariff(productId, brandId, applicationDate)).thenReturn(Optional.of(expectedTariff));

        final var result = getTariffUseCase.getTariff(productId, brandId, applicationDate);

        // Then
        assertNotNull(result);
        assertEquals(productId, result.getProductId());
        assertEquals(brandId, result.getBrandId());
        assertEquals(1, result.getPriceList());
        assertEquals(BigDecimal.valueOf(35.50), result.getPrice());

        verify(tariffRepository, times(1)).findApplicableTariff(productId, brandId, applicationDate);
    }

    /**
     * Test get tariff at 10 am on 15 th.
     */
    @Test
    void testGetTariffAt10AMOn15th() {

        // Given
        final var productId = 35455L;
        final var brandId = 1L;
        final var applicationDate = LocalDateTime.of(2020, 6, 15, 10, 0);

        final var expectedTariff = new Tariff(brandId, productId, 3, 1, BigDecimal.valueOf(30.50), "EUR",
                LocalDateTime.of(2020, 6, 15, 0, 0),
                LocalDateTime.of(2020, 6, 15, 11, 0));

        // When
        when(tariffRepository.existsByProductId(35455L)).thenReturn(true);
        when(tariffRepository.existsByBrandId(1L)).thenReturn(true);
        when(tariffRepository.findApplicableTariff(productId, brandId, applicationDate)).thenReturn(Optional.of(expectedTariff));

        final var result = getTariffUseCase.getTariff(productId, brandId, applicationDate);

        // Then
        assertNotNull(result);
        assertEquals(productId, result.getProductId());
        assertEquals(brandId, result.getBrandId());
        assertEquals(3, result.getPriceList());
        assertEquals(BigDecimal.valueOf(30.50), result.getPrice());

        verify(tariffRepository, times(1)).findApplicableTariff(productId, brandId, applicationDate);
    }

    /**
     * Test get tariff at 9 pm on 16 th.
     */
    @Test
    void testGetTariffAt9PMOn16th() {

        // Given
        final var productId = 35455L;
        final var brandId = 1L;
        final var applicationDate = LocalDateTime.of(2020, 6, 16, 21, 0);

        final var expectedTariff = new Tariff(brandId, productId, 4, 1, BigDecimal.valueOf(38.95), "EUR",
                LocalDateTime.of(2020, 6, 15, 16, 0),
                LocalDateTime.of(2020, 12, 31, 23, 59, 59));

        // When
        when(tariffRepository.existsByProductId(35455L)).thenReturn(true);
        when(tariffRepository.existsByBrandId(1L)).thenReturn(true);
        when(tariffRepository.findApplicableTariff(productId, brandId, applicationDate)).thenReturn(Optional.of(expectedTariff));

        final var result = getTariffUseCase.getTariff(productId, brandId, applicationDate);

        // Then
        assertNotNull(result);
        assertEquals(productId, result.getProductId());
        assertEquals(brandId, result.getBrandId());
        assertEquals(4, result.getPriceList());
        assertEquals(BigDecimal.valueOf(38.95), result.getPrice());

        verify(tariffRepository, times(1)).findApplicableTariff(productId, brandId, applicationDate);
    }

    /**
     * Test tariff not found exception.
     */
    @Test
    void testTariffNotFoundException() {

        // Given
        final var productId = 35455L;
        final var brandId = 1L;
        final var applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);

        // When
        when(tariffRepository.findApplicableTariff(productId, brandId, applicationDate)).thenReturn(Optional.empty());

        // Then
        assertThrows(ProductNotFoundException.class, () -> getTariffUseCase.getTariff(productId, brandId, applicationDate));

    }
}
