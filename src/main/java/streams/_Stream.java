package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static streams._Stream.Gender.FEMALE;
import static streams._Stream.Gender.MALE;


public class _Stream {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("MOHAMED", MALE));
        people.add(new Person("AHMED", MALE));
        people.add(new Person("MOUNA", FEMALE));
        people.add(new Person("NADIA", FEMALE));
        people.add(new Person("ALI", MALE));

//        people.stream()
//                .map(person -> person.gender)
//                .collect(Collectors.toSet())
//                .forEach(System.out::println);
//
//        people.stream()
//                .mapToInt(value -> value.name.length())
//                .forEach(System.out::println);


    }


    enum Gender {
        MALE, FEMALE
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
}
