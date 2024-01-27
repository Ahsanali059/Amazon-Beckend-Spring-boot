package com.example.amazonclone.services;

import com.example.amazonclone.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService
{
    List<Product> getAllProduct();
    Product getProductById(Long id);

    void createProduct(Product product);

    void deleteProduct(Long id);

    void updateProduct(Long id, Product product);
}
