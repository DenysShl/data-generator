package org.example.grpc.client.service;

import org.example.grpc.client.model.Data;

import java.util.List;

public interface GRPCDataService {
    void send(Data data);
    void send(List<Data> dataList);
}
