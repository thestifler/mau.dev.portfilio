package maudev.portfolio.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import maudev.portfolio.entity.Contact;
import maudev.portfolio.repository.ContactRepository;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService{
    
    private final ContactRepository contactRepository;

    @Override
    public Contact deleteContact(Long id) {
        // TODO Auto-generated method stub
        Contact contactDelete = contactRepository.findById(id).orElse(null);

        if (contactDelete == null) {
            return null;
        }
        contactDelete.setStatus("DELETED");

        return contactRepository.save(contactDelete);
    }

    @Override
    public List<Contact> findAll() {
        // TODO Auto-generated method stub
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(Long id) {
        // TODO Auto-generated method stub
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public Contact saveContact(Contact contact) {
        // TODO Auto-generated method stub
        contact.setStatus("CREATED");
        contact.setCreateat(new Date());
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact) {
        // TODO Auto-generated method stub

        Contact contactDB = findById(contact.getId());

        if (null == contactDB) {
            return null;
        }
        contactDB.setName(contact.getName());
        contactDB.setUrl(contact.getUrl());
        contactDB.setUrlPhoto(contact.getUrlPhoto());
        
        return contactRepository.save(contactDB);
        
    }
    
}
