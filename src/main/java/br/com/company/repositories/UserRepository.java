package br.com.company.repositories;

import br.com.company.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    List<UserEntity> findAllByClientId(Integer id);

    Optional<UserEntity> findByEmail(String email);
}
