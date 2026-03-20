package com.eyobandbaheran.productservice;

import com.eyobandbaheran.productservice.model.Product;
import com.eyobandbaheran.productservice.repository.ProductRepository;
import com.eyobandbaheran.productservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void findByIdReturnsProductWhenProductExists() {
        Product laptop = new Product("Laptop", 1200.0);
        laptop.setId(1L);
        when(productRepository.findById(1L)).thenReturn(Optional.of(laptop));

        Optional<Product> result = productService.findById(1L);

        assertThat(result).isPresent();
        assertThat(result.get().getName()).isEqualTo("Laptop");
        assertThat(result.get().getPrice()).isEqualTo(1200.0);
    }

    @Test
    void findByIdReturnsEmptyWhenProductNotFound() {
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Product> result = productService.findById(99L);

        assertThat(result).isEmpty();
    }
}