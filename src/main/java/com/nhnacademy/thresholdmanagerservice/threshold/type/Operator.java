package com.nhnacademy.thresholdmanagerservice.threshold.type;

/**
 * 임계값 비교에 사용되는 연산자 enum.
 * 동작 방식은 한글 설명(description)과 연산 기호(symbol)로 표현됩니다.
 */
public enum Operator {
    GREATER_THEN("크다", ">"),
    LESS_THAN("작다", "<"),
    EQUAL_TO("같다", "=="),
    NOT_EQUAL_TO("같지 않다", "!="),
    GREATER_OR_EQUAL("크거나 같다", ">="),
    LESS_OR_EQUAL("작거나 같다", "<=");

    /**
     * 한글로 표현한 방법
     */
    private final String description;

    /**
     * 기호로 표현한 방법
     */
    private final String symbol;

    /**
     * 기초 생성자 입니다.
     *
     * @param description 한글 표현 방법
     * @param symbol 기호 표현 방법
     */
    Operator(String description, String symbol) {
        this.description = description;
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public String getSymbol() {
        return symbol;
    }
}
