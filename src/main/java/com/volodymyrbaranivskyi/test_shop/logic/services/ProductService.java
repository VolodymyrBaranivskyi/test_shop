package com.volodymyrbaranivskyi.test_shop.logic.services;

import com.volodymyrbaranivskyi.test_shop.Util.ResponseInfo;
import com.volodymyrbaranivskyi.test_shop.model.entities.PageRequest;
import com.volodymyrbaranivskyi.test_shop.model.entities.Products;
import com.volodymyrbaranivskyi.test_shop.view.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<Products> getAllByRegex(String regularExpression);
    List<Products> getAllAvailable(PageRequest pageRequest, String nameFilter);
    List<Products> getAllAvailable(String nameFilter);
    ResponseInfo calculateAddtitionalInfo(List<ProductDto> productDtos, int page);

}
