package dians.coolcutsfinder.service;

import dians.coolcutsfinder.model.User;
import dians.coolcutsfinder.model.UserDto;


import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}