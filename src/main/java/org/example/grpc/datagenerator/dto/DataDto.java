package org.example.grpc.datagenerator.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.grpc.datagenerator.model.Data;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class DataDto {
    private Long sensorId;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime tmestamp;
    private Double measurement;
    private Data.MeasurementType measurementType;
}
