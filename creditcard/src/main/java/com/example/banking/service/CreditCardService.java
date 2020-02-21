package com.example.banking.service;

import com.example.banking.model.CreditCard;
import com.example.banking.repository.CreditCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService implements AbstractCreditCardService<CreditCard> {

    private CreditCardRepository creditCardRepository;

    public CreditCardService(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }

    public Optional<CreditCard> get(long id) {
        return creditCardRepository.findById(id);
    }

    public List<CreditCard> getAll() {
        return (List<CreditCard>) creditCardRepository.findAll();
    }

    public void save(CreditCard loan) {
        creditCardRepository.save(loan);
    }

    public void update(CreditCard loan) {
        creditCardRepository.save(loan);
    }

    public void delete(CreditCard loan) {
        creditCardRepository.delete(loan);
    }

    public List<CreditCard> findCreditCardByClientId(String clientId) {
        return creditCardRepository.findByClientId(clientId);
    }
}
