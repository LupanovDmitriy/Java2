package lesson1.obstacle;

import lesson1.competitors.Competitor;

public class Treadmill extends Obstacle {
    private int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(distance);
    }

}
