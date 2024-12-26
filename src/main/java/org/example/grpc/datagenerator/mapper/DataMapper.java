package org.example.grpc.datagenerator.mapper;

import org.example.grpc.datagenerator.dto.DataDto;
import org.example.grpc.datagenerator.model.Data;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<Data, DataDto> {
}
