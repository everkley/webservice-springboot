package com.atelion.webservice.resources;

import com.atelion.webservice.entities.Order;
import com.atelion.webservice.services.OrderService;
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
@RequestMapping(value ="/order")
@Tag(name = "get")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @Operation(summary = "get lista de orders", description = "retorna uma lista com todas as orders")
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> orders = orderService.findAll();
        return ResponseEntity.ok().body(orders);
    }

    @Operation(summary = "get order", description = "retorna uma order com base no id informado")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable(value = "id")
                                              @Parameter(name = "id", description = "id da order" ,
                                                      example = "1") Long id){
        Order order = orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }
}
