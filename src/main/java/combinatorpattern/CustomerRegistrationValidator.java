package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import combinatorpattern.CustomerRegistrationValidator.*;

import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public interface CustomerRegistrationValidator
        extends Function<Customer, ValidationResult> {

    static CustomerRegistrationValidator isEmailValid () {
        return customer -> customer.getEmail().contains("@")
                ? ValidationResult.SUCCES : EMAIL_NOT_VALID;
    }
    static CustomerRegistrationValidator isPhoneNumberValid () {
        return customer -> customer.getPhoneNumber().startsWith("+0")
                ? ValidationResult.SUCCES : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAdult () {
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 18
                ? ValidationResult.SUCCES : NOT_AN_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other){
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCES) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult{
        SUCCES,
        NOT_AN_ADULT,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID
    }
}
