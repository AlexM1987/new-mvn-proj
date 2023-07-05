package model;

public class PersonEqualsTests {
    public static void main(String[] args) {
        Person p = new Person();
        p.setLName("John");
        p.setLName("Johnson");
        p.setAge(55);
        p.setId(100);

        Person p2 = new Person(100, "John", "Johnson", 55);

        //I.Ссылки у разных объектов всегда разные!!!
        System.out.println("p == p2 ? " + (p == p2));

        Person p100 = p;
        System.out.println("p100 == p ? " + (p100 == p));

        /*II. equals по умолчанию проверяет ссылки. т.е. см. I. Если не переопределить equals,
         то всегда будут сравниваться ссылки*/
        Cat cat1 = new Cat("Murzik");
        Cat cat2 = new Cat("Murzik");
        Person person1 = new Person(123, "Mike", "Tyson", 56);
        person1.setCat(cat1);
        Person person2 = new Person(123, "Mike", "Tyson", 56);
        person2.setCat(cat2);

        /*чтобы объекты сравнивались корректно необходимо
         переопределить метод equals. Как правило объекты сравниваются по полям*/
        System.out.println("person1 equals person2 ? " + person1.equals(person2));

        //hashCode - функция, которая вернет целое число
        System.out.println("cat1 hashCode : " + cat1.hashCode());
        System.out.println("cat2 hashCode : " + cat2.hashCode());

        System.out.println("person1 hashCode : " + person1.hashCode());
        System.out.println("person2 hashCode : " + person2.hashCode());

        //коллизия - если у разных объектов один и тот же хэшкод
        //если хэшкоды разные, то объекты обязательно разные
    }
}
