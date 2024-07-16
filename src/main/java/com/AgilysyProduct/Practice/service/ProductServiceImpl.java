package com.AgilysyProduct.Practice.service;

import com.AgilysyProduct.Practice.Exception.ProductServiceCustomException;
import com.AgilysyProduct.Practice.entity.Product;
import com.AgilysyProduct.Practice.model.ProductRequest;
import com.AgilysyProduct.Practice.model.ProductResponse;
import com.AgilysyProduct.Practice.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.*;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product..");

        Product product = Product.builder().productName(productRequest.getName()).quantity(productRequest.getQuantity()).price(productRequest.getPrice()).build();
        productRepository.save(product);
        log.info("Product is Created");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        log.info("Get the Product for ProductId: {}"+productId);
        Product product = productRepository.findById(productId).orElseThrow(()-> new ProductServiceCustomException("Product with given "+ productId+"is not present","Product Not Found"));
        ProductResponse productResponse = new ProductResponse();
        copyProperties(product,productResponse);

        return productResponse;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        log.info("Reduce Quantity {} for Id:{}", quantity, productId);

        Product product = productRepository.findById(productId).
                orElseThrow(() -> new ProductServiceCustomException("Product with given Id not found", "PRODUCT_NOT_FOUND"));

        if (product.getQuantity() < quantity) {
            throw new ProductServiceCustomException("Product does not have sufficient quantity", "INSUFFICIENT_QAUANTITY");
        }

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        log.info("Product Quantity Updated Successfully");
    }
}
