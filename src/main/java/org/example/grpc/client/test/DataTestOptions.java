package org.example.grpc.client.test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.grpc.client.model.Data;

@NoArgsConstructor
@Getter
@Setter
public class DataTestOptions {
    private int delaySeconds;
    private Data.MeasurementType[] measurementTypes;
}
