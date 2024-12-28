package org.example.grpc.client.controller;

import lombok.RequiredArgsConstructor;
import org.example.grpc.client.dto.DataDto;
import org.example.grpc.client.dto.DataTestOptionsDto;
import org.example.grpc.client.mapper.DataMapper;
import org.example.grpc.client.mapper.DataTestOptionsMapper;
import org.example.grpc.client.model.Data;
import org.example.grpc.client.service.GRPCDataService;
import org.example.grpc.client.service.TestDataService;
import org.example.grpc.client.test.DataTestOptions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
@RequiredArgsConstructor
public class DataController {
    private final GRPCDataService grpcDataService;
    private final TestDataService testDataService;
    private final DataMapper dataMapper;
    private final DataTestOptionsMapper dataTestOptionsMapper;

    @PostMapping("/send")
    public void send(@RequestBody DataDto dataDto) {
        Data model = dataMapper.toModel(dataDto);
        grpcDataService.send(model);
    }

    @PostMapping("/send-test")
    public void sendTest(@RequestBody DataTestOptionsDto dataTestOptionsDto) {
        DataTestOptions model = dataTestOptionsMapper.toModel(dataTestOptionsDto);
        testDataService.sendMessagesTest(model);
    }
}
