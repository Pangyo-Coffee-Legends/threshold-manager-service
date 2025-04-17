package com.nhnacademy.thresholdmanagerservice.alertlog.domain;

import com.nhnacademy.thresholdmanagerservice.threshold.domain.Threshold;
import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * 실제 알림이 발생한 로그
 * Threshold에 정의된 조건이 실제 값(actualValue)에 의해 초과되었을 때 발생한 이벤트를 기록한다.
 */
@Entity
public class AlertLog {

    /**
     * AlertLog의 고유 식별자
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alertlog_id")
    private Long id;

    /**
     * 알림이 발생한 기준이 되는 임계값
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "threshold_id", nullable = false)
    private Threshold threshold;

    /**
     * 알림이 트리거된 시점
     */
    @Column(nullable = false, updatable = false)
    private LocalDateTime triggeredAt;

    /**
     * 알림 발생 당시의 실제 측정값
     */
    @Column(nullable = false)
    private Double actualValue;

    /**
     * 사용자 또는 시스템이 남긴 알림 메시지
     */
    private String message;

    /**
     * 알림이 해결되었는지 여부
     */
    @Column(nullable = false)
    private boolean resolved = false;

    /**
     * 알림이 해결된 시점 (resolved가 true일 때만 유효)
     */
    private LocalDateTime resolvedAt;

    /**
     * 기본 생성자
     */
    protected AlertLog() {}

    /**
     * 외부에서 직접 호출 못하게 막고 이 형식으로 객체를 만들려고 한다
     *
     * @param threshold 알림이 발생한 기준이 되는 임계값
     * @param triggeredAt 알림이 트리거된 시점
     * @param actualValue 알림 발생 당시의 실제 측정값
     * @param message 사용자 또는 시스템이 남긴 알림 메시지
     * @param resolved 알림이 해결된 시점
     */
    private AlertLog(Threshold threshold, LocalDateTime triggeredAt, Double actualValue, String message, boolean resolved) {
        this.threshold = threshold;
        this.triggeredAt = triggeredAt;
        this.actualValue = actualValue;
        this.message = message;
        this.resolved = resolved;
    }

    /**
     * 이 factory method 를 통해서만 AlertLog 객체를 만들 수 있다.
     * 생성자 대신 이름이 있는 메서드로 의미를 명확하게 표현합니다.
     *
     * @param threshold 알림이 발생한 기준이 되는 임계값
     * @param actualValue 알림 발생 당시의 실제 측정값
     * @param message 사용자 또는 시스템이 남긴 알림 메시지
     * @return 새로운 AlertLog 생성
     */
    public static AlertLog ofNewAlertLog(Threshold threshold, Double actualValue, String message) {
        return new AlertLog(threshold,
                LocalDateTime.now(),
                actualValue,
                message,
                false);
    }

    /**
     * 문제가 해결된 경우 사용
     */
    public void resolve() {
        this.resolved = true;
        this.resolvedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Threshold getThreshold() {
        return threshold;
    }

    public LocalDateTime getTriggeredAt() {
        return triggeredAt;
    }

    public Double getActualValue() {
        return actualValue;
    }

    public String getMessage() {
        return message;
    }

    public boolean isResolved() {
        return resolved;
    }

    public LocalDateTime getResolvedAt() {
        return resolvedAt;
    }

    @Override
    public String toString() {
        return "AlertLog{" +
                "id=" + id +
                ", threshold=" + threshold +
                ", triggeredAt=" + triggeredAt +
                ", actualValue=" + actualValue +
                ", message='" + message + '\'' +
                ", resolved=" + resolved +
                ", resolvedAt=" + resolvedAt +
                '}';
    }
}
