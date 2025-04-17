package com.nhnacademy.thresholdmanagerservice.threshold.repository;

import com.nhnacademy.thresholdmanagerservice.threshold.domain.Threshold;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThresholdRepository extends JpaRepository<Threshold, Long> {
}
