package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

public class Main {
    public static void main(String[] args) {
       Customer customer = new Customer(
               "Mohamed",
               "ahouzigmail.com",
               "+283838448",
               LocalDate.of(1995,1,28)
       );

//       CustomerValidatorService validatorService = new CustomerValidatorService();
//        System.out.println(validatorService.isValid(customer));

        //
        ValidationResult result = isEmailValid()
                .and(isAdult())
                .and(isPhoneNumberValid()).apply(customer);
        System.out.println(result);

        if(result != SUCCES) throw new IllegalArgumentException(result.name());
    }
}
