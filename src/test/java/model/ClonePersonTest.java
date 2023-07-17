package model;

public class ClonePersonTest {
    public static void main(String[] args) {
        Person p1 = new Person(123, "John", "Johnson", 43);
        Person p2 = new Person(123, "John", "Johnson", 43);

        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode() == p2.hashCode());

        Person p3 = new Person(222, "Bob", "Bobson", 54);
        Person p4 = new Person();
        p4.setId((p3.getId()));
        p4.setAge(p3.getAge());
        p4.setLName(p3.getLName());
        p4.setName(p3.getName());
        p4.setCat(p3.getCat());

        System.out.println("Clone correct? " + p3.equals(p4));

        Person p5Copy = new Person(p3.getId(), p3.getName(), p3.getLName(), p3.getAge(), p3.getCat(), null);
        System.out.println("Clone correct? " + p4.equals(p5Copy));
        System.out.println("Clone correct? " + p3.equals(p5Copy));

        Person p6 = new Person(555, "Mike", "Tyson", 57);
        Person p7 = p6.clone();
        System.out.println(p6.equals(p7));
    }
}
