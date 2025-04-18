package com.nhnacademy.thresholdmanagerservice.threshold.dto;

/**
 * 임계값(Threshold)에 대한 응답 DTO입니다.
 * <p>
 * 클라이언트에게 임계값 관련 데이터를 응답할 때 사용됩니다. 이 객체는 임계값의 고유 ID,
 * 메트릭 이름, limit 값, 비교 연산자(operator) 등과 같은 정보를 포함합니다.
 * </p>
 *
 * @author 강승우
 */
public class ThresholdResponse {

    /**
     * 임계값의 고유 ID
     */
    private Long thresholdId;

    /**
     * 측정 항목. 어떤 것을 감시할지를 뜻한다.
     * ex) cpu, memory
     */
    private String metric;

    /**
     * 임계값으로 설정된 수치
     * ex) CPU 사용률의 제한 값
     */
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
    private String createdBy;

    /**
     * 기초 생성자
     */
    protected ThresholdResponse() {}

    /**
     * ThresholdResponse 응답 객체를 생성합니다.
     *
     * @param thresholdId 임계값(Threshold)의 고유 ID
     * @param metric 임계값이 적용되는 메트릭 이름 (예: CPU 사용률, 메모리 등)
     * @param limitValue 임계값으로 설정된 수치
     * @param operator 비교 연산자 (예: GREATER_THAN, LESS_THAN 등)
     * @param enabled 해당 임계값 설정의 활성화 여부
     * @param createdBy 임계값을 생성한 사용자 이름
     */
    public ThresholdResponse(Long thresholdId, String metric, Double limitValue, String operator, boolean enabled, String createdBy) {
        this.thresholdId = thresholdId;
        this.metric = metric;
        this.limitValue = limitValue;
        this.operator = operator;
        this.enabled = enabled;
        this.createdBy = createdBy;
    }

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

    @Override
    public String toString() {
        return "ThresholdResponse{" +
                "thresholdId=" + thresholdId +
                ", metric='" + metric + '\'' +
                ", limitValue=" + limitValue +
                ", operator='" + operator + '\'' +
                ", enabled=" + enabled +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
