package lesson3;

import com.sun.deploy.cache.BaseLocalApplicationProperties;

import java.util.*;

/*
2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
        В этот телефонный справочник с помощью метода add() можно добавлять записи.
        С помощью метода get() искать номер телефона по фамилии.
        Следует учесть, что под одной фамилией может быть несколько телефонов, тогда при запросе такой фамилии должны выводиться все телефоны.
        Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще
        дополнительные поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.).
        Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main(), прописывая add() и get().
*/
public class TelephonBook {
    private HashMap<String, Set<String>> map = new HashMap<>();

    void add(String name, String number){
        Set<String> set = new HashSet<>();
        // не понимаю почему не могу set сделать private???
        if (map.get(name)!=null){
            set=map.get(name); // СОМНЕВАЮСЬ В ПРАВИЛЬНОСТИ такой записи.
            // Что произойдет в этом случае set = new HashSet<>(). Я замусореваю память?
            //ПРОКОМЕНТИРУЙТЕ ПОЖАЛУЙСТА.
        }
        set.add(number);
        map.put(name,set);
    }

    void get(String name){
        System.out.println("Телефоны "+name);
        if (map.get(name)!=null){
            System.out.println(map.get(name));
        }else{
            System.out.println("список пуст");
        }
    }
}

