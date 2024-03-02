package com.deliaaan.contactlistApi.controller;

import com.deliaaan.contactlistApi.entites.ContactEntity;
import com.deliaaan.contactlistApi.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/contacts")
@RestController
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;
    @GetMapping()
    Iterable<ContactEntity> list(){
        return contactRepository.findAll();
    }
}
