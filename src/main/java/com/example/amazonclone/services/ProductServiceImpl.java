package com.example.amazonclone.services;

import com.example.amazonclone.Repository.ProductRepository;
import com.example.amazonclone.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> getAllProduct()
    {
            return productRepository.findAll();


    }

    @Override
    public Product getProductById(Long id)
    {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if(existingProduct!=null)
        {
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setImage(updatedProduct.getImage());
            productRepository.save(existingProduct);
        }
    }
}
