package com.inkombizz.web.service;

import com.inkombizz.web.dto.ProductAddRequest;
import com.inkombizz.web.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();

    void addOrUpdateProduct(ProductAddRequest productAddRequest);

    Product findById(Integer id);

    void delete(Integer id);
}
