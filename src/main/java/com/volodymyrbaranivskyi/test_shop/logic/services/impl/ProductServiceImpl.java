package com.volodymyrbaranivskyi.test_shop.logic.services.impl;

import com.volodymyrbaranivskyi.test_shop.Util.ResponseInfo;
import com.volodymyrbaranivskyi.test_shop.data.dao.impl.ProductDaoImpl;
import com.volodymyrbaranivskyi.test_shop.logic.services.ProductService;
import com.volodymyrbaranivskyi.test_shop.model.entities.PageRequest;
import com.volodymyrbaranivskyi.test_shop.model.entities.Products;
import com.volodymyrbaranivskyi.test_shop.view.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDaoImpl productDaoImpl;

    @Autowired
    public ProductServiceImpl(ProductDaoImpl productDaoImpl) {
        this.productDaoImpl = productDaoImpl;
    }

    @Override
    public List<Products> getAllByRegex(String regularExpression) {
        return null;
    }

    @Override
    public List<Products> getAllAvailable(PageRequest pageRequest, String nameFilter) {
        List<Products> products = productDaoImpl.getAllAvailable(pageRequest);
        return products;
    }

    public List<Products> getAllAvailable(String nameFilter) {
        List<Products> products = productDaoImpl.getAllAvailable();
        Pattern pattern = getPattern(nameFilter);

        return products.stream().filter(product ->{
            boolean f = pattern.matcher(product.getName()).find();
            return !f;}).collect(Collectors.toList());
    }

    public Pattern getPattern(String pattern) {
        return Pattern.compile(pattern);
    }

    public ResponseInfo calculateAddtitionalInfo(List<ProductDto> productDtos, int page) {
        int limitItems =  1000000;
        ResponseInfo responseInfo = new ResponseInfo(page);
        productDtos.forEach(item -> {
            responseInfo.setItemsPerPage(limitItems);
            responseInfo.setTotalItems(productDtos.size() < limitItems
                    ? productDtos.size()
                    : limitItems);
            responseInfo.setNumPages((productDtos.size() % limitItems > 0)
                    ? (productDtos.size() / limitItems) + 1
                    : productDtos.size() / limitItems);
        });
        return responseInfo;
    }
}
