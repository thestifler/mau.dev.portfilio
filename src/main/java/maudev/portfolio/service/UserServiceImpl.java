package maudev.portfolio.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import lombok.RequiredArgsConstructor;
import maudev.portfolio.dto.UserDto;
import maudev.portfolio.entity.User;
import maudev.portfolio.repository.UserRepository;
import maudev.portfolio.util.helper.MapperHelper;

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
    public User findById(Long id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        String hashCode = argon2.hash(2, 1024, 2, user.getWordpass());
        user.setWordpass(hashCode);
        
        user.setStatus("CREATED");
        user.setCreateat(new Date());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
    
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

    @Override
    public UserDto getUser(Long id) {
        User user = userRepository.findByIdAndStatus(id,"CREATED");

        return MapperHelper.modelMapper().map(user, UserDto.class);
    }
    
}
