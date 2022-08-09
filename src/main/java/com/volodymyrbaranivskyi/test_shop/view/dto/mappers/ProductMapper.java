package com.volodymyrbaranivskyi.test_shop.view.dto.mappers;

import com.volodymyrbaranivskyi.test_shop.model.entities.Products;
import com.volodymyrbaranivskyi.test_shop.view.dto.ProductDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<ProductDto, Products> {
}