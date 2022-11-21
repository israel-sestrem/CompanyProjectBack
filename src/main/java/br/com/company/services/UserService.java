package br.com.company.services;

import br.com.company.entities.ClientEntity;
import br.com.company.entities.UserEntity;
import br.com.company.interfaces.RecUserLoginInterface;
import br.com.company.interfaces.SignupInterface;
import br.com.company.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ClientService clientService;

    @Transactional(readOnly = true)
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<UserEntity> findById(Integer id){
        return userRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<UserEntity> findAllByClientId(Integer id){
        return userRepository.findAllByClientId(id);
    }

    @Transactional
    public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }

    @Transactional
    public UserEntity saveWithClient(SignupInterface userClient){
        UserEntity user;
        if(userClient.getClientName() != null){
            if(userClient.getClientEmail() != null) {
                ClientEntity client = new ClientEntity(userClient.getClientName(), userClient.getClientEmail());
                user = this.mapToUserEntity(userClient, clientService.save(client));
            } else {
                ClientEntity client = clientService.findByName(userClient.getName());
                user = this.mapToUserEntity(userClient, client);
            }
        } else {
            user = this.mapToUserEntity(userClient, null);
        }
        return this.save(user);
    }

    private UserEntity mapToUserEntity(SignupInterface userClient, ClientEntity client) {

        UserEntity user = new UserEntity();
        user.setName(userClient.getName());
        user.setPassword(userClient.getPassword());
        user.setEmail(userClient.getEmail());
        if(client != null)
            user.setClientId(client.getId());

        return user;
    }

    @Transactional(readOnly = true)
    public Boolean existsById(Integer id){
        return userRepository.existsById(id);
    }

    @Transactional
    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<UserEntity> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public UserEntity checkNullFields(UserEntity user, UserEntity newUser){
        if(newUser.getClientId()!=null){
            user.setClientId(newUser.getClientId());
        }
        if(newUser.getName()!=null){
            user.setName(newUser.getName());
        }
        if(newUser.getPassword()!=null){
            user.setPassword(this.encode(newUser.getPassword()));
        }
        if(newUser.getEmail()!=null){
            user.setEmail(newUser.getEmail());
        }
        return user;
    }

    public String encode(String value){
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    public String decode(String value){
        return new String(Base64.getDecoder().decode(value));
    }

    public RecUserLoginInterface validateUser(String email, String password){
        RecUserLoginInterface userLogged = new RecUserLoginInterface();
        Optional<UserEntity> user = this.findByEmail(email);

        if(user.isPresent()) {
            userLogged.setIsValid(this.decode(user.get().getPassword()).equals(password));
            userLogged.setId(user.get().getId().toString());
        }

        return userLogged;
    }

    public List<UserEntity> decodeAll(List<UserEntity> users){
        return users
                .stream()
                .peek(user -> user.setPassword(this.decode(user.getPassword())))
                .collect(Collectors.toList());
    }

}
