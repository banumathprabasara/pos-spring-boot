package lk.ijse.pos.service;

import lk.ijse.pos.dto.UserPasswordDTO;
import lk.ijse.pos.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
    User getUserById(Long id);
    User changePassword(Long id, UserPasswordDTO userPasswordDTO);
}
