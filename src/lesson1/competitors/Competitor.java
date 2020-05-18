package lesson1.competitors;

public interface Competitor {
    void run(int distance);
    void jump(int hight);

    boolean onDistance();
    void info();
}
