package com.nhnacademy.thresholdmanagerservice.threshold.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * ThresholdHistory 엔티티는 특정 Threshold(임계값)의 변경 이력을 기록합니다.
 * 누가(changedBy), 언제(changedAt), 어떤 값이(old/new) 어떻게 변경되었는지를 추적합니다.
 */
@Entity
public class ThresholdHistory {

    /**
     * 고유 식별자 (자동 생성)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "threshold_history_id")
    private Long id;

    /**
     * 변경된 임계값 엔티티
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "threshold_id", nullable = false)
    private Threshold threshold;

    /**
     * 변경을 수행한 사용자 식별자
     */
    @Column(nullable = false)
    private String changedBy;

    /**
     * 변경된 시각
     */
    @Column(nullable = false, updatable = false)
    private LocalDateTime changedAt;

    /**
     * 변경 전의 limit 값
     */
    @Column(nullable = false)
    private Double oldLimitValue;

    /**
     * 변경 후의 limit 값
     */
    private Double newLimitValue;

    /**
     * 변경 전의 operator 값
     */
    @Column(nullable = false)
    private String oldOperator;

    /**
     * 변경 후의 operator 값
     */
    private String newOperator;

    /**
     * 기본 생성자 (JPA용)
     */
    protected ThresholdHistory() {}

    /**
     * 외부에서 직접 호출 못하게 막고 이 형식으로 객체를 만들려고 한다
     *
     * @param threshold 변경된 임계값 엔티티
     * @param changedBy 변경을 수행한 사용자 식별자
     * @param changedAt 변경된 시각
     * @param oldLimitValue 변경 전 limit 값
     * @param newLimitValue 변경 후 limit 값
     * @param oldOperator 변경 전의 operator 값
     * @param newOperator 변경 후의 operator 값
     */
    private ThresholdHistory(Threshold threshold, String changedBy, LocalDateTime changedAt, Double oldLimitValue, Double newLimitValue, String oldOperator, String newOperator) {
        this.threshold = threshold;
        this.changedBy = changedBy;
        this.changedAt = changedAt;
        this.oldLimitValue = oldLimitValue;
        this.newLimitValue = newLimitValue;
        this.oldOperator = oldOperator;
        this.newOperator = newOperator;
    }

    /**
     * 이 factory method 를 통해서만 ThresholdHistory 객체를 만들 수 있다.
     * 생성자 대신 이름이 있는 메서드로 의미를 명확하게 표현합니다.
     *
     * @param threshold 변경된 임계값 엔티티
     * @param changedBy 변경을 수행한 사용자 식별자
     * @param oldLimitValue 변경 전 limit 값
     * @param newLimitValue 변경 후 limit 값
     * @param oldOperator 변경 전의 operator 값
     * @param newOperator 변경 후의 operator 값
     * @return 새로운 ThresholdHistory 생성
     */
    public static ThresholdHistory ofNewThresholdHistory(Threshold threshold, String changedBy, Double oldLimitValue, Double newLimitValue, String oldOperator, String newOperator) {
        return new ThresholdHistory(
                threshold,
                changedBy,
                LocalDateTime.now(),
                oldLimitValue,
                newLimitValue,
                oldOperator,
                newOperator
        );
    }

    public Long getId() {
        return id;
    }

    public Threshold getThreshold() {
        return threshold;
    }

    public String getChangedBy() {
        return changedBy;
    }

    public LocalDateTime getChangedAt() {
        return changedAt;
    }

    public Double getOldLimitValue() {
        return oldLimitValue;
    }

    public Double getNewLimitValue() {
        return newLimitValue;
    }

    public String getOldOperator() {
        return oldOperator;
    }

    public String getNewOperator() {
        return newOperator;
    }

    @Override
    public String toString() {
        return "ThresholdHistory{" +
                "id=" + id +
                ", threshold=" + threshold +
                ", changedBy='" + changedBy + '\'' +
                ", changedAt=" + changedAt +
                ", oldLimitValue=" + oldLimitValue +
                ", newLimitValue=" + newLimitValue +
                ", oldOperator='" + oldOperator + '\'' +
                ", newOperator='" + newOperator + '\'' +
                '}';
    }
}
