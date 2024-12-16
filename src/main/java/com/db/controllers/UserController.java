package com.db.controllers;
import com.db.entities.MenuItem;
import com.db.entities.Restaurant;
import com.db.entities.User;
import com.db.services.MenuItemService;
import com.db.services.RestaurantService;
import com.db.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    MenuItemService menuItemService;

    @GetMapping("/restaurants")
    public ResponseEntity<Iterable<Restaurant>> getAllRestaurants() {
        Iterable<Restaurant> restaurants = restaurantService.getAllRestaurants(); // Assuming this fetches restaurants
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/restaurants/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        Optional<Restaurant> restaurant = restaurantService.findById(id);
        return restaurant
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user)
    {
        return ResponseEntity.ok(userService.saveUsers(user));
    }

    @PostMapping("/Order")
    public ResponseEntity<User> saveUserWithOrder(@RequestBody User user)
    {
        return ResponseEntity.ok(userService.saveUsers(user));
    }

    @GetMapping
    public ResponseEntity <Iterable<User>>getAllUsers()
    {
        return ResponseEntity.ok(userService.findAll());
    }
}
