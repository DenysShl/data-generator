package org.example.grpc.client.model;

import grpc.common.GRPCData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
@Setter
@NoArgsConstructor
public class Data {
    private Long sensorId;
    private LocalDateTime timestamp;
    private Double measurement;
    private MeasurementType measurementType;

    public enum MeasurementType {
        TEMPERATURE,
        VOLTAGE,
        POWER
    }

    public Data(GRPCData data) {
        this.sensorId = data.getSensorId();
        this.timestamp = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(
                        data.getTimestamp().getSeconds()
                ),
                ZoneId.systemDefault());
        this.measurement = data.getMeasurement();
        this.measurementType = MeasurementType.valueOf(data.getMeasurementType().name());
    }
}
