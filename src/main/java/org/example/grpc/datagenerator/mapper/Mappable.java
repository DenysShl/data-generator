package org.example.grpc.datagenerator.mapper;

import java.util.List;

public interface Mappable<E, D> {
    E toModel(D dto);
    List<E> toModelList(List<D> dtoList);
    D toDto(E model);
    List<D> toDtoList(List<E> modelList);
}
