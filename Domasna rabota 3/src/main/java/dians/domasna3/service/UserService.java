package dians.domasna3.service;



import dians.domasna3.model.User;
import dians.domasna3.model.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}