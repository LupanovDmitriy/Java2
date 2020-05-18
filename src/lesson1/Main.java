package lesson1;

import lesson1.competitors.Competitor;
import lesson1.obstacle.Obstacle;
import lesson1.obstacle.Treadmill;
import lesson1.obstacle.Wall;

/*
1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса.
Эти классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в консоль).
2.Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники должны выполнять
соответствующие действия (бежать или прыгать), результат выполнения печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
3.Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти этот набор препятствий.
4.* У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения на бег и прыжки.
Если участник не смог пройти одно из препятствий, то дальше по списку он препятствий не идет.
5. Задача про дни недели. Прикреплено в материалах
 */
public class Main {
    public static void main(String[] args) {
        Competitor[] competitors={
                new Human("Вася"),
                new Kat("Барсик"),
                new Robot("Робот")
        };
        Obstacle[] obstacles ={
                new Wall(3),
                new Treadmill(500)
        };

        for (Competitor c:competitors) {
            for (Obstacle o : obstacles){
                o.doIt(c);
                if (!c.onDistance()){
                    break;
                }
            }

        }
        for (Competitor c:competitors) {
            c.info();
        }


    }


}
