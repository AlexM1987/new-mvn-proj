package abs;

public class DVD extends Player implements Playable, Test {
    @Override
    public void play() {
        System.out.println("Start playing DVD...");
    }

    @Override
    public void stop() {
        System.out.println("Stop playing DVD...");
    }

    @Override
    public void test() {

    }
}
