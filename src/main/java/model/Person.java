package model;

import lombok.*;

import java.util.Objects;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person implements Cloneable, Comparable<Person>{


    private int id;
    private String name;
    private String lName;
    private int age;
    private Cat cat;
    private Car car;

    public Person(int id, String name, String lName, int age) {
        this.id = id;
        this.name = name;
        this.lName = lName;
        this.age = age;
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Person person = (Person) o;
//        return id == person.id;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && age == person.age && Objects.equals(name, person.name) &&
                Objects.equals(lName, person.lName) && Objects.equals(cat, person.cat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lName, age, cat);
    }

    @Override
    public Person clone() {
        Person clone = null;
        try {
            clone = (Person)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public int compareTo(Person o) {
        return this.lName.compareTo(o.getLName());
    }
}
