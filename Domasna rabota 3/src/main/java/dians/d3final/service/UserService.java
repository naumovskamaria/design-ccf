package dians.d3final.service;

import dians.d3final.model.Role;
import dians.d3final.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword, String name, String surname, Role role);
}
