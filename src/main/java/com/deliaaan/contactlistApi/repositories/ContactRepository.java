package com.deliaaan.contactlistApi.repositories;

import com.deliaaan.contactlistApi.entites.ContactEntity;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<ContactEntity, Integer>{

}
