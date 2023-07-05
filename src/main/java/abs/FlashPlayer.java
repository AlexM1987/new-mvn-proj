package abs;

public class FlashPlayer extends Player implements Playable {
    @Override
    public void play() {
        System.out.println("Start Flash Player...");
    }

    @Override
    public void stop() {
        System.out.println("Stop Flash Player...");
    }
}
