package maudev.portfolio.service;

import java.util.List;


import maudev.portfolio.entity.User;


public interface UserService {
    
    public List<User> findAll();
    public User findById(Long id);

    public User saveUser(User user);
    public User updateUser(User user);
    public User deleteUser(Long id);

}
