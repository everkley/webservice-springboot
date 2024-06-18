package com.atelion.webservice.resources;


import com.atelion.webservice.entities.Category;
import com.atelion.webservice.services.CategoryService;
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
@RequestMapping(value = "/categories")
@Tag(name = "Categories", description = "Operações relacionadas aos Categories")
public class CategoryResource {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @Operation(summary = "get lista de Category", description = "retorna uma lista com todas as categorias")
    public ResponseEntity<List<Category>> findAll(){
       return ResponseEntity.ok().body(categoryService.findAll());
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "get Category", description = "retorna uma categoria com base no id informado")
    public ResponseEntity<Category> findById(@PathVariable(value = "id")
                                             @Parameter(name = "id", description = "id da Category") Long id){
        return ResponseEntity.ok().body(categoryService.findById(id));
    }
}
