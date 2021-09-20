package maudev.portfolio.service;

import java.util.List;

import maudev.portfolio.entity.Contact;

public interface ContactService {

    public List<Contact> findAll();
    
    public Contact findById(Long id);

    public Contact saveContact(Contact contact);
    public Contact updateContact(Contact contact);
    public Contact deleteContact(Long id);
}
