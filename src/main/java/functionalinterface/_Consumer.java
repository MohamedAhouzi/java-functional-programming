package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {
        Customer mohamed = new Customer("Mohamed", "0655664435");

        //normal java function
        greetCustomer(mohamed);
        greetCustomerV2(mohamed,false);

        //Consumer Functional interface
        getGreetCustomerConsumer.accept(mohamed);
        getGreetCustomerConsumerV2.accept(mohamed,false);

    }

    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName + " Thank you for registering phone number " + customer.customerPhoneNumber);

    }
    static void greetCustomerV2(Customer customer,Boolean showNumber){
        System.out.println("Hello " +
                customer.customerName +
                " ,Thank you for registering phone number " +
                (showNumber ? customer.customerPhoneNumber : "**********" ));
    }
    static Consumer<Customer> getGreetCustomerConsumer =
            customer -> System.out.println("Hello " + customer.customerName + " Thank you for registering phone number " + customer.customerPhoneNumber);

    static BiConsumer<Customer,Boolean> getGreetCustomerConsumerV2 = (customer,showNumber) ->
            System.out.println("Hello " +
            customer.customerName +
            " ,Thank you for registering phone number " +
            (showNumber ? customer.customerPhoneNumber : "**********" ));


    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
