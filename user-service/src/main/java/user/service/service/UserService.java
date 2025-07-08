package user.service.service;

import user.service.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user, Long clientId, String roleName);

    List<User> getAllUsers();

    User getUserByEmail(String email);
}
