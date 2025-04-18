package com.nhnacademy.thresholdmanagerservice.threshold.repository;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("dev")
@DataJpaTest
class ThresholdRepositoryTest {

    @Autowired
    private ThresholdRepository thresholdRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    void findByMetric() {
    }

    @Test
    void findByCreatedBy() {
    }

    @Test
    void findByEnabledTrue() {
    }

    @Test
    void existsByMetricAndOperator() {
    }
}