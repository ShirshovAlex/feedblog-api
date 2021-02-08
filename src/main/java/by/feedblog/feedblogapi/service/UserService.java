package by.feedblog.feedblogapi.service;

import by.feedblog.feedblogapi.dao.repository.UserRepository;
import by.feedblog.feedblogapi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean save(User user) {
        if (userRepository.existsByLogin(user.getLogin())) {
            return false;
        }
        userRepository.save(user);
        return true;
    }

    public boolean updatePassword(long id, String password) {
        if (userRepository.existsById(id)) {
            User one = userRepository.getOne(id);
            one.setPassword(password);
            userRepository.save(one);
            return true;
        }
        return false;
    }

    public boolean updateName(String name, long id) {
        if (userRepository.existsById(id)) {
            User one = userRepository.getOne(id);
            one.setName(name);
            userRepository.save(one);
            return true;
        }
        return false;
    }

    public boolean deleteById(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean deleteByLogin(String login) {
        if (userRepository.existsByLogin(login)) {
            userRepository.deleteByLogin(login);
            return true;
        }
        return false;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getByLogin(String login) {
        if (userRepository.existsByLogin(login)) {
            return userRepository.findByLogin(login);
        }
        return null;
    }

    public List<User> getAllByName(String name) {
        return userRepository.findAllByName(name);
    }
}
