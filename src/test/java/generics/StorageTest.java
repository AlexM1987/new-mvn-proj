package generics;

import model.Person;
import org.junit.Assert;
import org.junit.Test;

public class StorageTest {

    @Test
    public void testStorage(){
        Storage <Person> personStorage = new Storage<>();
        personStorage.add(new Person(12, "Bob", "Ivanov", 33));
        personStorage.add(new Person(22, "Mike", "Petrov", 34));
        personStorage.add(new Person(32, "John", "Sidorov", 35));

        Assert.assertTrue(personStorage.size() == 3);
    }

    @Test (expected = NumberFormatException.class)
    public void testStorage2(){
        Storage<Number> numbers = new Storage<>();
        numbers.add(3.44); // boxing(упаковка) : double -> new Double(3.44) -> (Number)
        numbers.add(new Long(123));

        numbers.add(new Double("123, 123"));
    }
}
