package br.com.company.services;

import br.com.company.entities.ContactEntity;
import br.com.company.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Transactional(readOnly = true)
    public List<ContactEntity> findAll(){
        return contactRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<ContactEntity> findById(Integer id){
        return contactRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<ContactEntity> findAllByClientId(Integer id){
        return contactRepository.findAllByClientId(id);
    }

    @Transactional
    public ContactEntity save(ContactEntity contact){
        return contactRepository.save(contact);
    }

    @Transactional(readOnly = true)
    public Boolean existsById(Integer id){
        return contactRepository.existsById(id);
    }

    @Transactional
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
