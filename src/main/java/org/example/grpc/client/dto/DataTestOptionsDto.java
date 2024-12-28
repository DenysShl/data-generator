package org.example.grpc.client.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.grpc.client.model.Data;

@NoArgsConstructor
@Getter
@Setter
public class DataTestOptionsDto {
    private int delaySeconds;
    private Data.MeasurementType[] measurementTypes;
}
