package callbacks;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        hello("Mohamed",null,value->{
            System.out.println("no last name provided for :"+value);
        });

        hello2("Mohamed",null,() -> {
            System.out.println("no last name provided ");
        });
    }

    static void hello(String firstName, String lastName, Consumer<String> callBack ){
        System.out.println(firstName);
        if(lastName != null) System.out.println(lastName);
        else callBack.accept(firstName);
    }
    static void hello2(String firstName, String lastName, Runnable callBack ){
        System.out.println(firstName);
        if(lastName != null) System.out.println(lastName);
        else callBack.run();
    }
}
