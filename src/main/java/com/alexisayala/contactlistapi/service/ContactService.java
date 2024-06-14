package com.alexisayala.contactlistapi.service;

import com.alexisayala.contactlistapi.entity.Contact;
import com.alexisayala.contactlistapi.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public Iterable<Contact> findAll(){
        return contactRepository.findAll();
    }

    public Contact findById(Integer id){
        return contactRepository.findById(id).orElse(null);
    }

    public Contact create(Contact contact){
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, Contact form){
        Contact contactFromDB = findById(id);
        contactFromDB.setName(form.getName());
        contactFromDB.setEmail(form.getEmail());
        return contactRepository.save(contactFromDB);
    }

    public void delete(Integer id){
        Contact contactFromDB = findById(id);
        contactRepository.delete(contactFromDB);
    }
}
