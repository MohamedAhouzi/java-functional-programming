package Imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static Imperative.Main.Gender.FEMALE;
import static Imperative.Main.Gender.MALE;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("MOHAMED", MALE));
        people.add(new Person("AHMED", MALE));
        people.add(new Person("MOUNA", FEMALE));
        people.add(new Person("NADIA", FEMALE));
        people.add(new Person("ALI", MALE));

//Imperative approach

        List<Person> males = new ArrayList<>();
        for (Person person : people) {
            if (person.gender.equals(MALE)) males.add(person);
        }

        System.out.println("//Imperative approach");
        males.forEach(System.out::println);

//Declarative approach

        Predicate<Person> personPredicate = person -> person.gender.equals(MALE);
        List<Person> males2 = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());

        System.out.println("//Declarative approach");
        males2.forEach(System.out::println);
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
