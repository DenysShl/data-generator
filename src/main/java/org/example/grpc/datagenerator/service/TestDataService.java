package org.example.grpc.datagenerator.service;

import org.example.grpc.datagenerator.test.DataTestOptions;

public interface TestDataService {
    void sendMessagesTest(DataTestOptions dataTestOptions);

}
