package org.example.grpc.client.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.grpc.client.model.Data;
import org.example.grpc.client.service.GRPCDataService;
import org.example.grpc.client.service.TestDataService;
import org.example.grpc.client.test.DataTestOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class TestDataServiceImpl implements TestDataService {
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private final GRPCDataService grpcDataService;

    @Value("${push.batch-size}")
    private int batchSize;

    @Override
    public void sendMessagesTest(DataTestOptions testOptions) {
        List<Data> dataBatch = new ArrayList<>();
        if (testOptions.getMeasurementTypes().length > 0) {
            executorService.scheduleAtFixedRate(
                    () -> {
                        Data data = new Data();
                        data.setSensorId(
                                (long) getRandomNumber(1, 10)
                        );
                        data.setMeasurement(
                                getRandomNumber(15, 20)
                        );
                        data.setMeasurementType(
                                getRandomMesurementType(testOptions.getMeasurementTypes())
                        );
                        data.setTimestamp(LocalDateTime.now());
                        dataBatch.add(data);
                        if (dataBatch.size() == batchSize) {
                            grpcDataService.send(dataBatch);
                            dataBatch.clear();
                        }
                    },
                    0,
                    testOptions.getDelaySeconds(),
                    TimeUnit.SECONDS
            );
        }
    }

    private Data.MeasurementType getRandomMesurementType(Data.MeasurementType[] measurementTypes) {
        int randomTypeId = (int) (Math.random() * measurementTypes.length);
        return measurementTypes[randomTypeId];
    }

    private double getRandomNumber(int min, int max) {
        return (Math.random() * (max - min)) + min;
    }
}
