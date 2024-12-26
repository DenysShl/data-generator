package org.example.grpc.datagenerator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Data {
    private Long sensorId;
    private LocalDateTime tmestamp;
    private Double measurement;
    private MeasurementType measurementType;

    public enum MeasurementType {
        TEMPERATURE,
        VOLTAGE,
        POWER
    }
}
