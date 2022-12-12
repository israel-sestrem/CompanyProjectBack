package br.com.company.services;

import br.com.company.repositories.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FaqService {

    @Autowired
    FaqRepository faqRepository;



}
