package com.alexisayala.contactlistapi.repository;

import com.alexisayala.contactlistapi.entity.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
}
