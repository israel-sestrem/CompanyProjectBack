package br.com.company.service;

import br.com.company.entity.UserEntity;
import br.com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(Integer id){
        return userRepository.findById(id);
    }

    public List<UserEntity> findAllByClientId(Integer id){
        return userRepository.findAllByClientId(id);
    }

    public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }

    public Boolean existsById(Integer id){
        return userRepository.existsById(id);
    }

    public void deleteById(Integer id){
        userRepository.deleteById(id);
    }

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

    public Boolean validateUser(String email, String password){
        Optional<UserEntity> user = this.findByEmail(email);
        return user.isPresent() && this.decode(user.get().getPassword()).equals(password);
    }

    public List<UserEntity> decodeAll(List<UserEntity> users){
        return users
                .stream()
                .map(user -> {
                    user.setPassword(this.decode(user.getPassword()));
                    return user;
                })
                .collect(Collectors.toList());
    }

}
