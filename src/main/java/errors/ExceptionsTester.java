package errors;

import model.Person;

public class ExceptionsTester {
    public static void main(String[] args) {
        System.out.println("Begin.");
        Person p1 = new Person();

        Throwable throwable;
        Error error;
        Exception exception;

        try{
            //Потенциально небезопасный код. Пытаемся отловить иксепшн.
            p1.clone(); //will throw NullPointerException object!
        }catch (NullPointerException e){ //в блоке кэтч ожидается объект конкретного типа
            //обработка в случае наступления данной ошибки
            System.out.println("Ooops! NullPointerException happened: " + e.getMessage());
            e.printStackTrace();
        }finally {
            //блок выполнится в любом случае (и с ошибкой и без)
            System.out.println("Final job.");
        }


        int [] array = {2, 12, 33};
        int i = 2;


//        try{
//            int val = array[i];
//            System.out.println(val);
//        }catch (ArrayIndexOutOfBoundsException e){
//            System.out.println("Ooops! ArrayIndexOutOfBoundsException happened: " + i + " / " + e.getMessage());
//            e.printStackTrace();
//            System.out.println("Please use next indexes bound ->: from 0 to " + (array.length - 1));
//        }finally {
//            //default implementation -> print first element
//            System.out.println(array[0]);
//        }



            String str = "Hello Java World!";
            String [] words = str.split(" ");
            for (String word : words) {
                try {
                    System.out.println(word.charAt(word.indexOf('o')));
                } catch (StringIndexOutOfBoundsException e) {
                    System.out.println("There is no 'o' in word " + word);
                }
            }





        System.out.println("End.");
    }
}
