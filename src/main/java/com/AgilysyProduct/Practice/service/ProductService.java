package com.AgilysyProduct.Practice.service;

import com.AgilysyProduct.Practice.model.ProductRequest;
import com.AgilysyProduct.Practice.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);
}
