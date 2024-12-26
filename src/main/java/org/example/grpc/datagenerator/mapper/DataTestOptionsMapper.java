package org.example.grpc.datagenerator.mapper;

import org.example.grpc.datagenerator.dto.DataTestOptionsDto;
import org.example.grpc.datagenerator.test.DataTestOptions;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataTestOptionsMapper extends Mappable<DataTestOptions, DataTestOptionsDto> {
}
