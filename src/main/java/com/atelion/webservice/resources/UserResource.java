package com.atelion.webservice.resources;

import com.atelion.webservice.entities.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Tag(name = "get", description = "Retorna uma lista de usuários")
    @GetMapping
    public ResponseEntity<User> findAll() {
        User u = new User(1, " alguem", "aleguem @", "1231313", "1321321");
        return ResponseEntity.ok().body(u);
    }
}
