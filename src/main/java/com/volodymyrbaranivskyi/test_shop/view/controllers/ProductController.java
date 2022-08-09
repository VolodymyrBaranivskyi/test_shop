package com.volodymyrbaranivskyi.test_shop.view.controllers;

import com.volodymyrbaranivskyi.test_shop.logic.services.ProductService;
import com.volodymyrbaranivskyi.test_shop.model.entities.PageRequest;
import com.volodymyrbaranivskyi.test_shop.model.entities.Products;
import com.volodymyrbaranivskyi.test_shop.view.dto.ProductDto;
import com.volodymyrbaranivskyi.test_shop.view.dto.mappers.ProductMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import static com.volodymyrbaranivskyi.test_shop.model.entities.PageRequest.createPageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@RestController
@RequestMapping("/shop/product")
@Api(
        value = "Products")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;


    @Autowired
    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @ApiOperation(
            value = "Get all products",
            response = Products.class)
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Successfully get all products"),
            @ApiResponse(
                    code = 400,
                    message = "Error get all products"),
    })
    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getProducts(@RequestParam(required = true) String nameFilter,
            @RequestParam(required = false) Integer page) {
        System.out.println(nameFilter);
        int limitItems =  1000000;
        PageRequest pageRequest = createPageRequest(page, limitItems);
        List<ProductDto> list;
        Map<String, Object> result = new HashMap<String,Object>();
        if (isNull(pageRequest)) {
            list = productMapper.toDto(productService.
                    getAllAvailable(nameFilter));
            result.put("products",list.stream().limit(limitItems).collect(Collectors.toList()));
            result.put("responseInfo", productService.calculateAddtitionalInfo(list, 1));
        } else {
            list = productMapper.toDto(productService.
                    getAllAvailable(pageRequest, nameFilter));
            result.put("product",list);
            result.put("responseInfo", productService.calculateAddtitionalInfo(list, page));
        }
        return ResponseEntity.ok(result);
    }
}
