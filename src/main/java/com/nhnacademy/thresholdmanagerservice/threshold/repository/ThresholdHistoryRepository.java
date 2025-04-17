package com.nhnacademy.thresholdmanagerservice.threshold.repository;

import com.nhnacademy.thresholdmanagerservice.threshold.domain.ThresholdHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ThresholdHistory 의 저장소 입니다.
 */
public interface ThresholdHistoryRepository extends JpaRepository<ThresholdHistory, Long> {
}
