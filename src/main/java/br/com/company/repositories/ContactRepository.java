package br.com.company.repositories;

import br.com.company.entities.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Integer> {
    List<ContactEntity> findAllByClientId(Integer id);
}
