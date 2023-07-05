package abs;


// interface is a 100 % abstract class
public interface Playable {

    //public abstract by default
    void play();

    public abstract void stop();

    //by default the field is public and static final (constant)
    double pi = 3.14;

    public static final double X = 0.99;
}
