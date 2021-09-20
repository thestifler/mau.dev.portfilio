package maudev.portfolio.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import maudev.portfolio.entity.User;
import maudev.portfolio.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    
    private final UserRepository userRepository;

    @Override
    public User deleteUser(Long id) {
        // TODO Auto-generated method stub

        User userDB = findById(id);
        if (null == userDB) {
            return null;
        }
        userDB.setStatus("DELETED");
        return userRepository.save(userDB);
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        // TODO Auto-generated method stub
        user.setStatus("CREATED");
        user.setCreateat(new Date());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        // TODO Auto-generated method stub

        User  userDB = findById(user.getId());

        if(null == userDB){

            return null;
        }
        userDB.setName(user.getName());
        userDB.setLastname(user.getLastname());
        userDB.setAboutme(user.getAboutme());
        userDB.setJobposition(user.getJobposition());
        
        return userRepository.save(userDB);
    }
    
}
