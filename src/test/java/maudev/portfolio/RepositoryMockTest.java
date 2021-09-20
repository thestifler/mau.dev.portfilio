package maudev.portfolio;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import maudev.portfolio.entity.User;
import maudev.portfolio.repository.UserRepository;

@DataJpaTest
public class RepositoryMockTest {
    
    @Autowired
    private UserRepository userRepository;

    @Test
    private void whenFindById_then_ReturnUserList(){
        User user1 = User.builder()
            .name("Stif")
            .lastname("Meister")
            .aboutme("Java developer at solemti")
            .jobposition("Java Developer")
            .build();
        userRepository.save(user1);
        
        List<User> users = userRepository.findAll();

        Assertions.assertThat(users.size()>200);

    }
}
