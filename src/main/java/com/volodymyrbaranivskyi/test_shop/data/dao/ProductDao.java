package com.volodymyrbaranivskyi.test_shop.data.dao;

import com.volodymyrbaranivskyi.test_shop.model.entities.Products;

import java.util.List;

public interface ProductDao {
    List<Products> getAll(String regex);
}
