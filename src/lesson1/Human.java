package lesson1;

import lesson1.competitors.Competitor;

public class Human implements Competitor {
    String name;
    int maxRun;
    int maxJump;
    boolean  onDistance;


    public Human(String name) {
        this.name = name;
        this.maxRun = 2000;
        this.maxJump = 2;
        this.onDistance = true;
    }

    @Override
    public void run(int distance) {
        if (distance<=maxRun){
            System.out.println(name+" успешно пробежал");
        }
        else{
            System.out.println(name+" не смог пробежать");
            onDistance=false;
        }
    }

    @Override
    public void jump(int hight) {
        if (hight<=maxRun){
            System.out.println(name+" успешно перепрыгнул");
        }
        else{
            System.out.println(name+" не смог перепрыгнуть");
            onDistance=false;
        }
    }

    @Override
    public boolean onDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.println(name +" на дистанции:" +onDistance);
    }
}