package com.nhnacademy.thresholdmanagerservice.alertlog.repository;

import com.nhnacademy.thresholdmanagerservice.alertlog.domain.AlertLog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AlertLog 의 저장소입니다.
 */
public interface AlertLogRepository extends JpaRepository<AlertLog, Long> {
}
