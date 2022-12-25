package dians.d3final.service.impl;

import dians.d3final.model.User;
import dians.d3final.model.exceptions.InvalidArgumentsException;
import dians.d3final.model.exceptions.InvalidUserCredentialsException;
import dians.d3final.repository.UserRepository;
import dians.d3final.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username==null || username.isEmpty() || password==null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }

}

