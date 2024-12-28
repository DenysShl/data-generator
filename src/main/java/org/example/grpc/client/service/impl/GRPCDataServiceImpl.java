package org.example.grpc.client.service.impl;

import com.google.protobuf.Empty;
import com.google.protobuf.Timestamp;
import grpc.common.DataServerGrpc;
import grpc.common.GRPCData;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.example.grpc.client.model.Data;
import org.example.grpc.client.service.GRPCDataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GRPCDataServiceImpl implements GRPCDataService {
    @GrpcClient(value = "data-generator-blocking")
    private DataServerGrpc.DataServerBlockingStub blockingStub;

    @GrpcClient(value = "data-generator-async")
    private DataServerGrpc.DataServerStub asyncStub;

    @Override
    public void send(Data data) {
        grpc.common.GRPCData request = grpc.common.GRPCData.newBuilder()
                .setSensorId(data.getSensorId())
                .setTimestamp(
                        Timestamp.newBuilder()
                                .setSeconds(data.getTimestamp().getSecond())
                                .setNanos(data.getTimestamp().getNano())
                                .build()
                )
                .setMeasurementType(
                        grpc.common.MeasurementType.valueOf(data.getMeasurementType().name())
                )
                .setMeasurement(data.getMeasurement())
                .build();

        blockingStub.addData(request);

//        Async
        StreamObserver<Empty> responseObserver = new StreamObserver<Empty>() {
            @Override
            public void onNext(Empty empty) {
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {

            }
        };
        asyncStub.addData(request, responseObserver);
    }

    @Override
    public void send(List<Data> dataList) {
        StreamObserver<Empty> responseObserver = new StreamObserver<Empty>() {
            @Override
            public void onNext(Empty empty) {
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {

            }
        };

        StreamObserver<GRPCData> requestObserver = asyncStub.addStreamOfData(responseObserver);
        for (Data data : dataList) {
            grpc.common.GRPCData request = grpc.common.GRPCData.newBuilder()
                    .setSensorId(data.getSensorId())
                    .setTimestamp(
                            Timestamp.newBuilder()
                                    .setSeconds(data.getTimestamp().getSecond())
                                    .setNanos(data.getTimestamp().getNano())
                                    .build()
                    )
                    .setMeasurementType(
                            grpc.common.MeasurementType.valueOf(data.getMeasurementType().name())
                    )
                    .setMeasurement(data.getMeasurement())
                    .build();
            requestObserver.onNext(request);
        }
        requestObserver.onCompleted();
    }
}
