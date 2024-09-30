package com.spring.microservices.manager;

import com.spring.microservices.model.Payment;
import com.spring.microservices.model.Payments;

public class PaymentManager {

    public boolean validatePayment(Payment payment) {
        switch (payment.getPaymentMethod()) {
            case "CREDIT_CARD":
                return validateCreditCard(payment);
            case "ACH":
                return validateACH(payment);
            case "DEBIT_CARD":
                return validateDebitCard(payment);
            default:
                return false;
        }
    }

    private boolean validateCreditCard(Payment payment) {
        return payment.getCreditCard().getCreditCardNumber() != null
                && payment.getCreditCard().getExpirationDate() != null
                && !payment.getCreditCard().getExpirationDate().isEmpty()
                && payment.getCreditCard().getSecurityCode() != null
                && !payment.getCreditCard().getSecurityCode().isEmpty();
    }

    private boolean validateACH(Payment payment) {
        return payment.getAchDetails().getAccountNumber() != null
                && payment.getAchDetails().getRoutingNumber() != null;
    }

    private boolean validateDebitCard(Payment payment) {
        return payment.getDebitCard().getDebitCardNumber() != null
                && payment.getDebitCard().getExpirationDate() != null
                && !payment.getDebitCard().getExpirationDate().isEmpty()
                && payment.getDebitCard().getSecurityCode() != null
                && !payment.getDebitCard().getSecurityCode().isEmpty();
    }
}
