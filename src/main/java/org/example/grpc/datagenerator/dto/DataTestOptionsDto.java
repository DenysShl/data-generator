package org.example.grpc.datagenerator.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.grpc.datagenerator.model.Data;

@NoArgsConstructor
@Getter
@Setter
public class DataTestOptionsDto {
    private int delaySeconds;
    private Data.MeasurementType[] measurementTypes;
}
