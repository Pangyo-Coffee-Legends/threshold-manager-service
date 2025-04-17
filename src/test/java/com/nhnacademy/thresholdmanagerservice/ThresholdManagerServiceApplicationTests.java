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


    @MockitoBean
    private InfluxDBClient influxDBClient;

    @MockitoBean
    private QueryApi queryApi;

    @Test
    void contextLoads() {
        // 실제 호출 방지
        when(queryApi.query(anyString())).thenReturn(List.of());
    }

}
