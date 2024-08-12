package com.prueba.bcnc.integracion;

import com.prueba.bcnc.infrastructure.persistence.TariffEntity;
import com.prueba.bcnc.infrastructure.repository.JpaTariffRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TariffIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private JpaTariffRepository tariffRepository;

    TariffIntegrationTest() {
    }

    @BeforeEach
    void setUp() {
        // Preparar los datos de prueba en la base de datos H2
        final var tariff1 = new TariffEntity();
        tariff1.setBrandId(1L);
        tariff1.setProductId(35455L);
        tariff1.setPriceList(1);
        tariff1.setPriority(0);
        tariff1.setPrice(BigDecimal.valueOf(35.50));
        tariff1.setCurrency("EUR");
        tariff1.setStartDate(LocalDateTime.of(2020, 6, 14, 0, 0));
        tariff1.setEndDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
        tariffRepository.save(tariff1);
    }

    @Test
    void testGetTariff() {
        final var url = "http://localhost:" + port + "/api/tariffs?productId=35455&brandId=1&applicationDate=2020-06-14T10:00:00";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

        final var expectedPrice = "\"price\":35.50";
        assertTrue(response.getBody().contains(expectedPrice));
    }

}