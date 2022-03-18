package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println("without predicate ");
        System.out.println(isPhoneNumberValid("0698090987"));
        System.out.println(isPhoneNumberValid("06980"));
        System.out.println(isPhoneNumberValid("06980909_7"));

        System.out.println("with predicate");
        System.out.println(isPhoneNumberValidPredicate.test("0698090987"));
        System.out.println(isPhoneNumberValidPredicate.test("06980"));
        System.out.println(isPhoneNumberValidPredicate.test("06980909_7"));


        System.out.println(
                "is phone number contains 4 and valid = "+
                isPhoneNumberValidPredicate.and(IsPhoneNumberContains4).test("0648090987")
        );

    }

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("06") && phoneNumber.length()==10;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("06") && phoneNumber.length()==10;

    static Predicate<String> IsPhoneNumberContains4 = phoneNumber ->
            phoneNumber.contains("4");
}

