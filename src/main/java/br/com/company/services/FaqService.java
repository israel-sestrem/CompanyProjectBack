package br.com.company.services;

import br.com.company.entities.FaqEntity;
import br.com.company.repositories.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FaqService {

    @Autowired
    FaqRepository faqRepository;

    @Transactional(readOnly = true)
    public List<FaqEntity> findAll(){
        return faqRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<FaqEntity> findById(Integer id){
        return faqRepository.findById(id);
    }

    @Transactional
    public FaqEntity save(FaqEntity faq){
        return faqRepository.save(faq);
    }

    @Transactional(readOnly = true)
    public boolean existsById(Integer id){
        return faqRepository.existsById(id);
    }

    @Transactional
    public void deleteById(Integer id){
        faqRepository.deleteById(id);
    }

}
