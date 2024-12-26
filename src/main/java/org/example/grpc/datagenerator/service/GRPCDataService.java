package org.example.grpc.datagenerator.service;

import org.example.grpc.datagenerator.model.Data;

import java.util.List;

public interface GRPCDataService {
    void send(Data data);
    void send(List<Data> dataList);
}
