package com.deliaaan.contactlistApi.controller;

import com.deliaaan.contactlistApi.entites.ContactEntity;
import com.deliaaan.contactlistApi.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping("/api/contacts")
@RestController
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;
    @GetMapping()
    Iterable<ContactEntity> list(){
        return contactRepository.findAll();
    }

    @GetMapping("{id}")
    public ContactEntity get(@PathVariable Integer id){
        return contactRepository
                .findById(id)
                .orElse(null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ContactEntity create(@RequestBody ContactEntity contact){
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }


    @PutMapping("{id}")
    public ContactEntity update(@PathVariable Integer id, @RequestBody ContactEntity contact){
        ContactEntity contactFromDB = contactRepository
                .findById(id)
                .orElse(null);

        contactFromDB.setName(contact.getName());
        contactFromDB.setEmail(contact.getEmail());

        return contactRepository.save(contactFromDB);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        ContactEntity contact = contactRepository
                .findById(id)
                .orElse(null);
        contactRepository.delete(contact);
    }


}
