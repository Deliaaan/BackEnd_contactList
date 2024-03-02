package com.deliaaan.contactlistApi;

import com.deliaaan.contactlistApi.entites.ContactEntity;
import com.deliaaan.contactlistApi.repositories.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.w3c.dom.ls.LSException;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ContactlistApiApplication {

	public static void main(String[] args) {SpringApplication.run(ContactlistApiApplication.class, args);}

	@Bean
	CommandLineRunner runner(ContactRepository contactRepo) {
		return args ->
		{
			List<ContactEntity> contacts = Arrays.asList(
					new ContactEntity("Carlos", "Carlos@gmail.com", LocalDateTime.now()),
					new ContactEntity("Juan", "Juan@gmail.com", LocalDateTime.now()),
					new ContactEntity("pedro", "pedro@gmail.com", LocalDateTime.now()),
					new ContactEntity("diego", "diego@gmail.com", LocalDateTime.now()),
					new ContactEntity("puto", "puto@gmail.com", LocalDateTime.now())
			);
			contactRepo.saveAll(contacts);
		};
	}
}


