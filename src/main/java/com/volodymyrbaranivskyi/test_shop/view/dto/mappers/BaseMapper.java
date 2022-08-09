package com.volodymyrbaranivskyi.test_shop.view.dto.mappers;

import org.mapstruct.InheritInverseConfiguration;

import java.util.List;

public interface BaseMapper<Dto, Entity> {

    Dto toDto(Entity entity);

    List<Dto> toDto(List<Entity> entities);

    @InheritInverseConfiguration
    Entity toEntity(Dto dto);

    List<Entity> toEntity(List<Dto> dtos);
}
