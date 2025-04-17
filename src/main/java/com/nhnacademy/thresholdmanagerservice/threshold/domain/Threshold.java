package com.nhnacademy.thresholdmanagerservice.threshold.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

// TODO entity, class 내부 내용 없애야 합니다!
@Entity
public class Threshold {
    @Id
    @GeneratedValue
    @Column(name = "threshold_id")
    private Long thresholdId;

}
