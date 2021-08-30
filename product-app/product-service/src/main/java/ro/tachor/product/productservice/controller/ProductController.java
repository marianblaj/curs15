package ro.tachor.product.productservice.controller;


import dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs13.exceptions.ResourceNotFoundException;
import ro.tachor.product.productservice.model.ProductEntity;
import ro.tachor.product.productservice.model.mapper.ProductMapper;
import ro.tachor.product.productservice.service.ProductService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;
    private final ProductMapper mapper;

    @GetMapping
    List<Product> getAll() {
        return mapper.toApi(service.getAll());
    }

    @GetMapping("/populate")
    void populate(){
        service.populate();
    }

    @GetMapping("{productId}")
    Product getProduct(@PathVariable Long productId) {
        return service.getProduct(productId)
                .map(mapper::toApi)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + productId + " is not found"));
    }

    @PostMapping
    Product addProduct(@RequestBody Product product) {
        return mapper.toApi(service.addProduct(mapper.toDb(product)));

    }

    @DeleteMapping("{productId}")
    Product deleteProduct(@PathVariable long productId) {
        return service.deleteProduct(productId)
                .map(mapper::toApi)
                .orElse(null);
    }
}
