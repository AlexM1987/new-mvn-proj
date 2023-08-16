package enums;
import static enums.Constants.*; // * означает, что импортируем все

//import specific method or field
import static java.lang.Math.PI;
import static java.lang.Math.cos;

public class Test {
    public static void main(String[] args) {
        double x = PI + Constants.PI;
        Math.random();
        cos(2);

        System.out.println(Math.random());
        System.out.println(ONE);


        Problem problem1 = new Problem("Wrong password.");
        problem1.setSeverity(Severity.BLOCKER);
        problem1.resolve();
    }


    static int random(int bound){
        int x = (int)Math.random() * bound;
        return x;

    }
}
