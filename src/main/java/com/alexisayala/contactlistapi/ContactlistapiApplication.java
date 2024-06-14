package com.alexisayala.contactlistapi;

import com.alexisayala.contactlistapi.entity.Contact;
import com.alexisayala.contactlistapi.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ContactlistapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactlistapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ContactRepository contactRepository){
		return args -> {
				List<Contact> contacts = Arrays.asList(
						new Contact("'Alexis'", "alexis@email.com", LocalDateTime.now()),
						new Contact("Juan", "juan@email.com", LocalDateTime.now()),
						new Contact("Pedro", "pedro@email.com", LocalDateTime.now()),
						new Contact("Marcela", "marcela@email.com", LocalDateTime.now()),
						new Contact("Francisco", "francisco@email.com", LocalDateTime.now())
				);
				contactRepository.saveAll(contacts);

		};
	}
}
