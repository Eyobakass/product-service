package com.eyobandbaheran.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eyobandbaheran.productservice.model.Product;
import com.eyobandbaheran.productservice.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // Constructor injection
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
}