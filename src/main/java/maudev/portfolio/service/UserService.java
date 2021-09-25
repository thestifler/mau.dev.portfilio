package maudev.portfolio.service;




import maudev.portfolio.dto.UserDto;
import maudev.portfolio.entity.User;


public interface UserService {
    
    UserDto getUser(Long id);
    User findById(Long id);

    User saveUser(User user);
    User updateUser(User user);
    User deleteUser(Long id);

}
