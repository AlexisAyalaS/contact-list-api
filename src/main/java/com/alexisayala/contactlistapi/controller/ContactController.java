package com.alexisayala.contactlistapi.controller;

import com.alexisayala.contactlistapi.entity.Contact;
import com.alexisayala.contactlistapi.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactService contactService;

    @GetMapping()
    Iterable<Contact> list(){
        return contactService.findAll();
    }

    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id){
        return contactService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@RequestBody Contact contact){
        return contactService.create(contact);
    }

    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id, @RequestBody Contact form){
        return contactService.update(id, form);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        contactService.delete(id);
    }

}
