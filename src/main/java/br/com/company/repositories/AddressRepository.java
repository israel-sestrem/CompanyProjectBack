package br.com.company.repositories;

import br.com.company.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {
    List<AddressEntity> findAllByClientId(Integer id);
}
