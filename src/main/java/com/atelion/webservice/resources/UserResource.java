package com.atelion.webservice.resources;

import com.atelion.webservice.entities.User;
import com.atelion.webservice.repositories.UserRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {


    @Tag(name = "get", description = "Retorna uma lista de usuários")
    @GetMapping
    public ResponseEntity<User> findAll() {
        List<User> users = new ArrayList<>();
        return null;
    }
}
