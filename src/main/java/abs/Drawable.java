package abs;

public interface Drawable {

    void takeAPencil();
    void drawAShape();

}

class Circle implements Drawable{

    @Override
    public void takeAPencil() {

    }

    @Override
    public void drawAShape() {

    }
}

class Triangle implements Drawable, Printable{

    @Override
    public void takeAPencil() {
        System.out.println("Take a pencil.");
    }

    @Override
    public void drawAShape() {
        System.out.println("Draw a triangle.");
    }

    @Override
    public void print() {

    }
}

class Painter{
    public static void main(String[] args) {
        new Triangle().takeAPencil();
        new Triangle().drawAShape();


    }
}