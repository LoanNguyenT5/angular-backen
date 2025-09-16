package com.example.user.management.controller;
import com.example.user.management.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final List<User> users = new ArrayList<>();
    @GetMapping
    public List<User> getUsers() {
        return users;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        if (user.getCreatedOn() == null) {
            user.setCreatedOn(Instant.now());
        }
        users.add(user);
        return user;
    }
    @PutMapping("/{loginName}")
    public ResponseEntity<User> updateUser(
            @PathVariable String loginName,
            @RequestBody User updatedUser) {

        for (User user : users) {
            if (user.getLoginName().equals(loginName)) {
                user.setCustomProfile(updatedUser.isCustomProfile());
                user.setTemplate(updatedUser.getTemplate());
                user.setRoles(updatedUser.getRoles());
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.notFound().build();
    }

}
