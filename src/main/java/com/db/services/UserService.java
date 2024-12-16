package com.db.services;
import com.db.entities.User;

public interface UserService {
    User saveUsers(User user);
    Iterable<User> findAll();
}
