package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        //Function takes one argument and produces 1 result
        int increment = incrementByOne(1);
        System.out.println(increment);

        int increment2=incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply=multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(addBy1AndThenMultiplyBy10.apply(1));

        //BiFunction takes one argument and produces 2 results
        int incrementByOneAndMultiply1 = incrementByOneAndMultiply(2, 5);
        System.out.println(incrementByOneAndMultiply1);
        Integer  incrementByOneAndMultiplyBiFunction1= incrementByOneAndMultiplyBiFunction.apply(2, 5);
        System.out.println(incrementByOneAndMultiplyBiFunction1);

    }

    static Function<Integer,Integer> incrementByOneFunction = number -> number + 1;
    static Function<Integer,Integer> multiplyBy10Function =number->number*10;

    static int incrementByOne(int number) {
        return number + 1;
    }

    //BiFunction

    static BiFunction<Integer,Integer,Integer> incrementByOneAndMultiplyBiFunction=
            (incremented,nomberToMultiplyBy)->(incremented+1) * nomberToMultiplyBy;

    static int incrementByOneAndMultiply(int incremented ,int multiplyBy){
        return (incremented + 1) * multiplyBy;
    }
}
