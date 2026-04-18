package com.eyobandbaheran.productservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.eyobandbaheran.productservice.model.Product;
import com.eyobandbaheran.productservice.repository.ProductRepository;

@SpringBootApplication
public class ProductserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner seedData(ProductRepository repo) {
        return args -> {
            repo.save(new Product("Laptop", 1200.0, 15, "Electronics"));
            repo.save(new Product("Monitor", 350.0, 8, "Electronics"));
            repo.save(new Product("Keyboard", 85.0, 30, "Peripherals"));
        };
    }
}
