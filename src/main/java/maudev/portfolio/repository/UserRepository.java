package maudev.portfolio.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import maudev.portfolio.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    

    public List<User> findAll();

}
