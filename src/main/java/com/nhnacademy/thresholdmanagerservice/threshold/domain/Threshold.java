package com.nhnacademy.thresholdmanagerservice.threshold.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * 경고 조건
 */
@Entity
public class Threshold {

    /**
     * 검색 ID 값을 만들어 줍니다.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "threshold_id")
    private Long thresholdId;

    /**
     * 측정 항목. 어떤 것을 감시할지를 뜻한다.
     * ex) cpu, memory
     */
    @Column(nullable = false)
    private String metric;

    /**
     * 임계값
     * ex) 90.0
     */
    @Column(nullable = false)
    private Double limitValue;

    /**
     * 어떤 조건으로 임계값을 판단할지 정한다.
     * GREATER_THEN     >
     * LESS_THEN        <
     * EQUAL_TO         ==
     * NOT_EQUAL_TO     !=
     * GREATER_OR_EQUAL >=
     * LESS_OR_EQUAL    <=
     */
    private String operator;

    /**
     * 활성화 여부
     */
    private boolean enabled;

    /**
     * 작성자. 누가 만들었는지 파악.
     */
    @Column(nullable = false, updatable = false)
    private String createdBy;

    /**
     * 생성 날짜
     */
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * 수정한 날짜
     */
    private LocalDateTime updatedAt;

    /**
     * JPA 기본 생성자
     */
    protected Threshold () {}

    /**
     * 외부에서 직접 호출 못하게 막고 이 형식으로 객체를 만들려고 한다
     *
     * @param metric 측정항목
     * @param limitValue 임계값
     * @param operator 임계값 판단 OPERATOR
     * @param enabled 활성화 여부
     * @param createdBy 작성자
     */
    private Threshold(String metric, Double limitValue, String operator, boolean enabled, String createdBy) {
        this.metric = metric;
        this.limitValue = limitValue;
        this.operator = operator;
        this.enabled = enabled;
        this.createdBy = createdBy;
    }

    /**
     * 이 factory method 를 통해서만 Threshold 객체를 만들 수 있다.
     * 생성자 대신 이름이 있는 메서드로 의미를 명확하게 표현합니다.
     *
     * @param metric 측정항목
     * @param limitValue 임계값
     * @param operator 임계값 판단 OPERATOR
     * @param createdBy 작성자
     * @return 새로운 Threshold 생성
     */
    public static Threshold ofNewThreshold(String metric, Double limitValue, String operator, String createdBy) {
        return new Threshold(metric, limitValue, operator, true, createdBy);
    }

    /**
     * 생성시 자동으로 생성 날짜를 만들어 준다.
     */
    @PrePersist
    public void prePersist() { this.createdAt = LocalDateTime.now(); }

    /**
     * 업데이트시 자동으로 업데이트 날짜를 만들어 준다.
     */
    @PreUpdate
    public void preUpdate() { this.updatedAt = LocalDateTime.now(); }

    public Long getThresholdId() {
        return thresholdId;
    }

    public String getMetric() {
        return metric;
    }

    public Double getLimitValue() {
        return limitValue;
    }

    public String getOperator() {
        return operator;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public String toString() {
        return "Threshold{" +
                "id=" + thresholdId +
                ", metric='" + metric + '\'' +
                ", limitValue=" + limitValue +
                ", operator='" + operator + '\'' +
                ", enabled=" + enabled +
                ", createdBy='" + createdBy + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
