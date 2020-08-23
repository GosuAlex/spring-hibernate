package no.rad.springdemo.rest;

import no.rad.springdemo.entity.Payment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class CorporateController {

    @GetMapping("/corporate")
    public List<Payment> getPayments() {

        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment(0, 100, "Roy", "Sameep"));
        payments.add(new Payment(1, 200, "Rogan Josh", "Ola Nordmann"));
        payments.add(new Payment(2, 500, "Ramesh", "Fredrik"));

        return payments;
    }

    @GetMapping("/corporate/{paymentId}")
    public Payment getPayment(@PathVariable int paymentId) {

        List<Payment> payments = new ArrayList<>();
        payments.add(new Payment(0, 100, "Roy", "Sameep"));
        payments.add(new Payment(1, 200, "Rogan Josh", "Ola Nordmann"));
        payments.add(new Payment(2, 500, "Ramesh", "Fredrik"));

        return payments.get(paymentId);
    }


}