package br.com.company.repositories;

import br.com.company.entities.FaqEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepository extends JpaRepository<FaqEntity, Integer> {
}
