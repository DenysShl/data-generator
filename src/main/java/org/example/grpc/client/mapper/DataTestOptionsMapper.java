package org.example.grpc.client.mapper;

import org.example.grpc.client.dto.DataTestOptionsDto;
import org.example.grpc.client.test.DataTestOptions;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataTestOptionsMapper extends Mappable<DataTestOptions, DataTestOptionsDto> {
}
