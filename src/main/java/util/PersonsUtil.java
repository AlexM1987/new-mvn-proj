package util;

import errors.CarNotFoundException;
import model.Car;
import model.Person;

public class PersonsUtil {

    public static void drive(Person p) throws CarNotFoundException {
        Car car = null;

        try{
            car = p.getCar();
        }catch (NullPointerException e){
            throw new CarNotFoundException("Person is Null", e);
        }


        if (car == null)
            throw new CarNotFoundException(); // we leave the method

        if(car.getModel() == null){
            throw new CarNotFoundException("Model is not populated.");
        }

        System.out.println(p.getLName() + " is driving " + p.getCar().getModel());
    }
}
