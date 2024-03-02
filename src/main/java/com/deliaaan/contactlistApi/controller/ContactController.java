package com.deliaaan.contactlistApi.controller;

import com.deliaaan.contactlistApi.entites.ContactEntity;
import com.deliaaan.contactlistApi.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@RequestMapping("/api/contacts")
@RestController
public class ContactController {

    private final ContactService contactService;

    // Encontrar todos
    @GetMapping()
    Iterable<ContactEntity> list(){
        return contactService.findAll();
    }

    // Encontrar POR ID
    @GetMapping("{id}")
    public ContactEntity get(@PathVariable Integer id){
        return contactService.findById(id);
    }

    //Crear nuevo contacto
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ContactEntity create(@RequestBody ContactEntity contact){
        return contactService.createNewContact(contact);
    }

    // actualizar contacto
    @PutMapping("{id}")
    public ContactEntity update(@PathVariable Integer id, @RequestBody ContactEntity contact){
        return contactService.updateContact(id, contact);
    }

    // borrar contacto
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        contactService.deleteContact(id);
    }


}
