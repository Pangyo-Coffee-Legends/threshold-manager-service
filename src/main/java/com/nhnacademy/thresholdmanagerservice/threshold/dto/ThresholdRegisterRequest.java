package com.nhnacademy.thresholdmanagerservice.threshold.dto;

/**
 * 임계값(Threshold)을 등록하기 위한 요청 DTO입니다.
 * <p>
 * 클라이언트로부터 전달받은 metric, limitValue, operator 등의 정보를 담아
 * Threshold 도메인 객체 생성을 위한 데이터로 사용됩니다.
 * </p>
 *
 * <p>주요 필드 예시:</p>
 * <ul>
 *     <li>metric - 모니터링 지표 이름 (측정 항목)</li>
 *     <li>limitValue - 임계값 숫자</li>
 *     <li>operator - 비교 연산자 (>, <, >= 등)</li>
 *     <li>enabled - 임계값 활성화 여부</li>
 * </ul>
 *
 * @author 강승우
 */
public class ThresholdRegisterRequest {

    /**
     * 측정 항목. 어떤 것을 감시할지를 뜻한다.
     * ex) cpu, memory
     */
    private String metric;

    /**
     * 기준이 되는 임계값
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

    private ThresholdRegisterRequest() {}

    public ThresholdRegisterRequest(String metric, Double limitValue, String operator, boolean enabled, String createdBy) {
        this.metric = metric;
        this.limitValue = limitValue;
        this.operator = operator;
        this.enabled = enabled;
        this.createdBy = createdBy;
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
        return "ThresholdRegisterRequest{" +
                "metric='" + metric + '\'' +
                ", limitValue=" + limitValue +
                ", operator='" + operator + '\'' +
                ", enabled=" + enabled +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
