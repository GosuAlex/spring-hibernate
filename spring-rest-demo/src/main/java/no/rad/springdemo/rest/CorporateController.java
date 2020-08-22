package no.rad.springdemo.rest;

import no.rad.springdemo.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class CorporateController {

    @GetMapping("/corporate")
    public List<Payment> getPayments() {

        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment(0, 99, "Roy", "Sameep"));
        payments.add(new Payment(1, 199, "Rogan Josh", "Ola Nordmann"));
        payments.add(new Payment(2, 500, "Ramesh", "Fredrik"));

        return payments;
    }
}
