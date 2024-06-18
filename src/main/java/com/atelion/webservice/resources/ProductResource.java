package com.atelion.webservice.resources;

import com.atelion.webservice.entities.Product;
import com.atelion.webservice.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
@Tag(name = "Products", description = "Operações relacionadas aos Products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping
    @Operation(summary = "get lista de Products", description = "retorna uma lista com todos os Products")
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok().body(productService.findAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "get Product", description = "retorna um Product com base no id informado")
    public ResponseEntity<Product> findById(@PathVariable(value = "id")
                                            @Parameter(name = "id", description = "id do Product") Long id) {
        return ResponseEntity.ok().body(productService.findById(id));
    }
}
