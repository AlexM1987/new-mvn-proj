package util;

import com.sun.javaws.exceptions.CacheAccessException;
import errors.CarNotFoundException;
import model.Car;
import model.Person;
import org.junit.Assert;
import org.junit.Test;

public class PersonsTest {
    @Test
    public void driveTest(){
        Person p1 = new Person();
        p1.setName("John");

        Car car1 = new Car();
        car1.setModel("BMW X7");
        p1.setCar(car1);

        try {
            PersonsUtil.drive(p1);
        }catch (CarNotFoundException e){
            e.printStackTrace();
        }
    }

//    @Test
//    public void driveTest2() {
//
//        try {
//            PersonsUtil.drive(null);
//        }catch (CarNotFoundException e){
//           Throwable th = e.getCause();
//            Assert.assertArrayEquals(NullPointerException.class, th.getClass());
//        }
//    }
}
