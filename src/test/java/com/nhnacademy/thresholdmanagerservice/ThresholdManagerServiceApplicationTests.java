package com.nhnacademy.thresholdmanagerservice;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.QueryApi;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest(properties = "spring.profiles.active=test")
class ThresholdManagerServiceApplicationTests {


    /**
     * InfluxDBClient 를 Spring ApplicationContext 에 Mockito Mock 객체로 주입합니다.
     * 즉, QueryAPi 대신 Mock 객체가 주입됩니다.
     */
    @MockitoBean
    private InfluxDBClient influxDBClient;

    /**
     * QueryApi 를 Spring ApplicationContext 에 Mockito Mock 객체로 주입합니다.
     * 즉, QueryAPi 대신 Mock 객체가 주입됩니다.
     */
    @MockitoBean
    private QueryApi queryApi;

    /**
     * 실제 DB 쿼리 없이 테스트를 가능하게 해주는 mock 설정입니다.
     * influxDB 가 성공적으로 연결되고 값들을 가져올 수 있는지 테스트합니다.
     */
    @Test
    void contextLoads() {
        when(influxDBClient.getQueryApi()).thenReturn(queryApi);
        when(queryApi.query(anyString())).thenReturn(List.of());
    }

}
