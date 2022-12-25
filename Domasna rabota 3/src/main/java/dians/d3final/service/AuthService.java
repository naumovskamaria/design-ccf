package dians.d3final.service;

import dians.d3final.model.User;

public interface AuthService {
    User login(String username, String password);
}
