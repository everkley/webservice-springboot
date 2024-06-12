package com.atelion.webservice.resources;

import com.atelion.webservice.entities.User;
import com.atelion.webservice.services.UserService;
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
@RequestMapping(value = "/users")
@Tag(name = "get", description = "")
public class UserResource {

    @Autowired
    private UserService userService;

    @Operation(summary = "get lista de usuários", description = "retorna uma lista com todos os usuários")
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @Operation(summary = "get usuário por id", description = "retorna um usuário com base no id informado")
    @GetMapping(value ="/{id}")
    public ResponseEntity<User> findById(@PathVariable(value = "id")
                                             @Parameter(name = "id", description = "Id do usuário",
                                                     example = "1") Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
