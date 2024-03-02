package com.deliaaan.contactlistApi.service;

import com.deliaaan.contactlistApi.entites.ContactEntity;
import com.deliaaan.contactlistApi.repositories.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
// Usamos esta clase para aislar la logica principal
@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;


    // Encontrar todos
    public Iterable<ContactEntity> findAll() {
        return contactRepository.findAll();
    }

    // Encontrar POR ID
    public ContactEntity findById(Integer id){
        return contactRepository
                .findById(id)
                .orElse(null);
    }

    // Crear nuevo contacto
    public ContactEntity createNewContact(@RequestBody ContactEntity contact){
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    // actualizar contacto
    public ContactEntity updateContact(@PathVariable Integer id, @RequestBody ContactEntity contact){
        ContactEntity contactFromDB = findById(id);
        contactFromDB.setName(contact.getName());
        contactFromDB.setEmail(contact.getEmail());

        return contactRepository.save(contactFromDB);
    }

    // borrar contacto
    public void deleteContact(Integer id){
        ContactEntity contactFromDB = findById(id);
        contactRepository.delete(contactFromDB);
    }
}
