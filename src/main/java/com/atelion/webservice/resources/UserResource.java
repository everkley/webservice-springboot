package com.atelion.webservice.resources;

import com.atelion.webservice.entities.User;
import com.atelion.webservice.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@Tag(name = "Users", description = "Operações relacionadas aos Users")
public class UserResource {

    @Autowired
    private UserService userService;

    @Operation(summary = "get lista de User", description = "retorna uma lista com todos os Users")
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @Operation(summary = "get User por id", description = "retorna um User com base no id informado")
    @GetMapping(value ="/{id}")
    public ResponseEntity<User> findById(@PathVariable(value = "id")
                                             @Parameter(name = "id", description = "Id do User",
                                                     example = "1") Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    @Operation(summary = "insere um User")
    public ResponseEntity<User> insert (@RequestBody User user){
        user = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(user);
    }
}
