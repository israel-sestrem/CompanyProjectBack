package br.com.company.services;

import br.com.company.entities.ClientEntity;
import br.com.company.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<ClientEntity> findAll(){
        return clientRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<ClientEntity> findById(Integer id){
        return clientRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public ClientEntity findByName(String name){
        return clientRepository.findByName(name);
    }

    @Transactional
    public ClientEntity save(ClientEntity client){
        return clientRepository.save(client);
    }

    @Transactional(readOnly = true)
    public Boolean existsById(Integer id){
        return clientRepository.existsById(id);
    }

    @Transactional
    public void deleteById(Integer id){
        clientRepository.deleteById(id);
    }

    public ClientEntity checkNullFields(ClientEntity client, ClientEntity newClient){
        if(newClient.getName()!=null){
            client.setName(newClient.getName());
        }
        if(newClient.getEmail()!=null){
            client.setEmail(newClient.getEmail());
        }
        return client;
    }

}
