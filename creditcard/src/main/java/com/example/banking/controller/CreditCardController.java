package com.example.banking.controller;

import com.example.banking.model.CreditCard;
import com.example.banking.service.CreditCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/creditcard")
public class CreditCardController {

    private CreditCardService creditCardService;

    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }


    @PostMapping
    public CreditCard saveCreditCard(@RequestBody CreditCard creditCard) {
        creditCardService.save(creditCard);
        return creditCard;
    }


    @GetMapping(path = "{clientId}")
    public List<CreditCard> findCreditCardByClientId(@PathVariable String clientId) {
        return creditCardService.findCreditCardByClientId(clientId);
    }

    @PutMapping
    public void updateLoan(@RequestBody CreditCard creditCard) {
        creditCardService.update(creditCard);
    }

    @GetMapping
    public List<CreditCard> getAllCreditCard() {
        return creditCardService.getAll();
    }

    @DeleteMapping(path = "{id}")
    public void deleteCreditCard(@PathVariable Long id) {
        Optional<CreditCard> loan = creditCardService.get(id);
        if (loan.isPresent()) {
            creditCardService.delete(loan.get());
        }
    }
}
