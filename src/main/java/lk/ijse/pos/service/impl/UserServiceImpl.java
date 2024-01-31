package lk.ijse.pos.service.impl;

import lk.ijse.pos.dto.UserPasswordDTO;
import lk.ijse.pos.entity.User;
import lk.ijse.pos.repository.UserRepository;
import lk.ijse.pos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User changePassword(Long id, UserPasswordDTO userPasswordDTO) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null){
            user.setPassword(userPasswordDTO.getPassword());
            return userRepository.save(user);
        }
        return null;
    }
}
