package org.example.grpc.client.service;

import org.example.grpc.client.test.DataTestOptions;

public interface TestDataService {
    void sendMessagesTest(DataTestOptions dataTestOptions);

}
