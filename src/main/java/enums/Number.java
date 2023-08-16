package enums;

import java.util.Scanner;

public enum Number {
    //Перечисляем названия объектов. Каждый этот эеземпляр финальный, статический
    ONE, TWO, THREE
}

 enum Seasons{
    SPRING, SUMMER, FALL, WINTER;

     public static Seasons getSeasonsByNum(int number){
        switch (number){
            case 1:
                return SPRING;
            case 2:
                return SUMMER;
            case 3:
                return FALL;
            case 4:
                return WINTER;
        }
        return null;
     }

     public static Seasons getSeasonByMonthNum(int number){
         switch (number){
             case 3:
             case 4:
             case 5:
                 return SPRING;
             case 6:
             case 7:
             case 8:
                 return SUMMER;
             case 9:
             case 10:
             case 11:
                 return FALL;
             case 12:
             case 1:
             case 2:
                 return WINTER;
         }
         throw new IllegalArgumentException("Incorrect month number " + number);
     }
}

class EnumsTester {
    public static void main(String[] args) {
        Number num = Number.ONE;
        if(num instanceof Enum){
            System.out.println("This is ENUM.");
        }
        System.out.println(Number.values().length);
        for (Number n : Number.values()){
            System.out.println("Enum name : " + n.name() + " | position : "
                    + n.ordinal());

        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Input season:");
        int seasonName = sc.nextInt();

        Seasons s1 = Seasons.WINTER;
        switch (Seasons.getSeasonByMonthNum(8)){
            case WINTER:
                System.out.println("It's snowy!");
                break;
            case SUMMER:
                System.out.println("Let's swim!");
                break;
            default:
                System.out.println("It's boring!");
        }

        Seasons.getSeasonByMonthNum(8);

        System.out.println(Seasons.valueOf("FALL").ordinal());

    }
}

class Constants{
    public static final double PI = 3.14;

    public static final String ONE = "ONE";
}

enum Planet {
    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);

    private final double mass;   // in kilograms
    private final double radius; // in meters
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    private double mass() { return mass; }
    private double radius() { return radius; }

    // universal gravitational constant  (m3 kg-1 s-2)
    public static final double G = 6.67300E-11;

    double surfaceGravity() {
        return G * mass / (radius * radius);
    }
    double surfaceWeight(double otherMass) {
        return otherMass * surfaceGravity();
    }
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Planet <earth_weight>");
            System.exit(-1);
        }
        double earthWeight = Double.parseDouble(args[0]);
        double mass = earthWeight/EARTH.surfaceGravity();
        for (Planet p : Planet.values())
            System.out.printf("Your weight on %s is %f%n",
                    p, p.surfaceWeight(mass));
    }
}
