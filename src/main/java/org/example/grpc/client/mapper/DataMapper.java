package org.example.grpc.client.mapper;

import org.example.grpc.client.dto.DataDto;
import org.example.grpc.client.model.Data;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DataMapper extends Mappable<Data, DataDto> {
}
