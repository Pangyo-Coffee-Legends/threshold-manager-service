package com.nhnacademy.thresholdmanagerservice.threshold.repository;

import com.nhnacademy.thresholdmanagerservice.threshold.domain.Threshold;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Threshold 의 저장소입니다.
 */
public interface ThresholdRepository extends JpaRepository<Threshold, Long> {

    /**
     * metric 이름으로 조회
     * @param metric 측정 항목
     * @return 측정 항목의 리스트를 조회한다
     */
    List<Threshold> findByMetric(String metric);

    /**
     * 특정 사용자가 만든 임계값 목록 조회
     * @param createdBy 작성자
     * @return 작성자의 리스트를 조회한다
     */
    List<Threshold> findByCreatedBy(String createdBy);

    /**
     * 활성화된 임계 값 전체 조회
     * @param enabled 활성화 여부
     * @return 활성화된 리스트를 조회한다
     */
    List<Threshold> findByEnabledTrue(boolean enabled);

    /**
     * 특정 metric 과 operator 를 기준으로 중복 여부 검사
     * @param metric 측정 항목
     * @param operator 연산자
     * @return 측정 항목과 연산자에 대해 true, false
     */
    boolean existsByMetricAndOperator(String metric, String operator);
}
