package abs;

public class TypePlayer extends Player implements Playable {
    @Override
    public void play() {
        System.out.println("Start Type Player...");
    }

    @Override
    public void stop() {
        System.out.println("Stop Type Player...");
    }
}
