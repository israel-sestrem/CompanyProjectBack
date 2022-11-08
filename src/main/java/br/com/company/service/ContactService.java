package br.com.company.service;

import br.com.company.entity.ContactEntity;
import br.com.company.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public List<ContactEntity> findAll(){
        return contactRepository.findAll();
    }

    public Optional<ContactEntity> findById(Integer id){
        return contactRepository.findById(id);
    }

    public List<ContactEntity> findAllByClientId(Integer id){
        return contactRepository.findAllByClientId(id);
    }

    public ContactEntity save(ContactEntity contact){
        return contactRepository.save(contact);
    }

    public Boolean existsById(Integer id){
        return contactRepository.existsById(id);
    }

    public void deleteById(Integer id){
        contactRepository.deleteById(id);
    }

    public ContactEntity checkNullFields(ContactEntity contactEntity, ContactEntity newContact) {
        if(newContact.getType()!=null){
            contactEntity.setType(newContact.getType());
        }
        if(newContact.getPhone()!=null){
            contactEntity.setPhone(newContact.getPhone());
        }
        return contactEntity;
    }

}
