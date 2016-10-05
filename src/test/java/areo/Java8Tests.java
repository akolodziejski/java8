package areo;

import junit.framework.TestCase;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by gta on 04.10.16.
 */


class Person {

    private String name;
    private double age;

    public Person(String name, double age){

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }
}


class Data {

    public static List<Person> small = Arrays.asList(
            new Person("Aro", 22.0),
            new Person("Ivona", 18.0));
}


public class Java8Tests extends TestCase {


    public void testGrouping(){

        Map<Double, List<Person>> groupedByAge = Data.small.stream().collect(Collectors.groupingBy(person -> person.getAge()));

        Map<Double, Set<String>> groupedByAgeWithName =
                Data.small.stream().collect(
                        Collectors.groupingBy(person -> person.getAge(),
                                Collectors.mapping(person -> person.getName(), Collectors.toSet())));


        assertEquals(2, groupedByAge.keySet().size());

    }
}
