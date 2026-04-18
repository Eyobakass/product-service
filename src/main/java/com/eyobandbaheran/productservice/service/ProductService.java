package com.eyobandbaheran.productservice.service;

import com.eyobandbaheran.productservice.dto.ProductRequest;
import com.eyobandbaheran.productservice.dto.ProductResponse;
import com.eyobandbaheran.productservice.exception.ResourceNotFoundException;
import com.eyobandbaheran.productservice.model.Product;
import com.eyobandbaheran.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    // ── GET ALL ─────────────────────────────
    public List<ProductResponse> findAll() {
        return repo.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    // ── GET BY ID ───────────────────────────
    public ProductResponse findById(Long id) {
        Product product = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return toResponse(product);
    }

    // ── CREATE ──────────────────────────────
    public ProductResponse create(ProductRequest req) {
        Product saved = repo.save(toEntity(req));
        return toResponse(saved);
    }

    // ── UPDATE ──────────────────────────────
    public ProductResponse update(Long id, ProductRequest req) {
        Product existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        existing.setName(req.getName());
        existing.setPrice(req.getPrice());
        existing.setStockQty(req.getStockQty());
        existing.setCategory(req.getCategory());

        return toResponse(repo.save(existing));
    }

    // ── DELETE ──────────────────────────────
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        repo.deleteById(id);
    }

    // ── MAPPING ─────────────────────────────
    private ProductResponse toResponse(Product p) {
        return new ProductResponse(
                p.getId(),
                p.getName(),
                p.getPrice(),
                p.getStockQty(),
                p.getCategory()
        );
    }

    private Product toEntity(ProductRequest req) {
        return new Product(
                req.getName(),
                req.getPrice(),
                req.getStockQty(),
                req.getCategory()
        );
    }
}