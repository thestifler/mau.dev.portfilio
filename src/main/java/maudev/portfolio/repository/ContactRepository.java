package maudev.portfolio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import maudev.portfolio.entity.Contact;


@Repository
public interface ContactRepository extends JpaRepository<Contact,Long>  {
    
    public List<Contact> findAll();
}
