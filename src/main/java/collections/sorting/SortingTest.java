package collections.sorting;

import lombok.AllArgsConstructor;
import model.Car;
import model.Person;
import lombok.Data;

import java.util.*;

public class SortingTest {
    public static void main(String[] args) {



        Person p1 = new Person(12, "Mike", "Jackson", 40);
        Person p2 = new Person(52, "John", "Smith", 25);
        Person p3 = new Person(12, "Alex", "White", 35);
        Person p4 = new Person(12, "Stive", "Black", 18);
        Person p5 = new Person(12, "Bayron", "Sidorov", 50);
        Person p6 = new Person(12, "Yuri", "Ivanov", 41);

        Car c1 = new Car(33, "BMW");
        Car c2 = new Car(34, "ACURA");
        Car c3 = new Car(35, "OPEL");
        Car c4 = new Car(36, "RENO");
        Car c5 = new Car(37, "SUZUKI");
        Car c6 = new Car(38, "AUDI");

        p1.setCar(c1);
        p2.setCar(c2);
        p3.setCar(c3);
        p4.setCar(c4);
        p5.setCar(c5);
        p6.setCar(c6);

        List<Person> persons = Arrays.asList(p1, p2, p3, p4, p5, p6);

        //1st via Comparable
        System.out.println(persons);
        Collections.shuffle(persons);
        System.out.println(persons);
        Collections.sort(persons);
        System.out.println(persons);

        List<String> strs = Arrays.asList("BB", "AAA", "AA", "Y", "CC");
        Collections.sort(strs);
        System.out.println(strs);

        //2nd Comparator
        Collections.sort(persons, new PersonsByCarComparator());
        System.out.println(persons);
        Collections.sort(persons, new PersonsByAgeComparator());
        System.out.println(persons);

        Pizza pizza1 = new Pizza('s', "Cheese" , 2000, true);
        Pizza pizza2 = new Pizza('m', "Veggie" , 900, false);
        Pizza pizza3 = new Pizza('s', "Pepperoni" , 1900, true);
        Pizza pizza4 = new Pizza('l', "Pepperoni" , 2900, true);

        List<Pizza> pizzas = Arrays.asList(pizza1, pizza2, pizza3, pizza4);
        Collections.sort(pizzas);
        System.out.println(pizzas);

        Collections.sort(pizzas, new PizzaByNameComparator());
    }
}

class PersonsByCarComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        System.out.println("PersonsByCarComparator -> compare");
        return o1.getCar().compareTo(o2.getCar());
    }
}

class PersonsByAgeComparator implements Comparator<Person>{

    private boolean asc = true;

    public PersonsByAgeComparator(boolean asc){
        this.asc = asc;
    }
    public PersonsByAgeComparator(){

    }

    @Override
    public int  compare(Person o1, Person o2) {
        return asc?
                new Integer(o1.getAge()).compareTo(o2.getAge())
                :
                new Integer(o2.getAge()).compareTo(o1.getAge());
    }
}

@Data
@AllArgsConstructor
class Pizza implements Comparable<Pizza>, Comparator<Pizza>{
    private char size; // can be 's', 'm', 'l'
    private String name;
    private long kcal;
    private boolean isThin;

    @Override
    public int compareTo(Pizza o) {
        return Long.valueOf(kcal).compareTo(o.kcal);
    }

    @Override
    public int compare(Pizza o1, Pizza o2) {
        return o1.name.compareTo(o2.name);
    }
}

class PizzaByNameComparator implements Comparator<Pizza>{

    @Override
    public int compare(Pizza o1, Pizza o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
