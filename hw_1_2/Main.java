package oop.hw_1_2;
/*
Проанализировать персонажей "
Крестьянин,Peasant ~ Spearman > не боевой, не лечит, не ходит, носит стрелы снайперам и арбалетчикам
Разбойник, Rogue ~ Spearman > боевой юнит, ходит, бьет в упор
Снайпер, Sniper  боевой юнит. Не перемещается, стреляет, стрелы ограничены
Колдун, Sorcerer ~ Monk > волшебник. Не перемещается, лечит, мана не ограничена
Копейщик, Spearman - боевой юнит. Перемещается на 1 клеточку за ход (кроме диагоналей).Оружие ближнего боя не ограничено, ход не ограничен
Арбалетчик, Crossbowman - боевой юнит. Умеет стрелять, не перемещается, стрелы ограничены
Монах, Monk - волшебник. Не перемещается, лечит, мана не ограничена

Для каждого определить
8 полей данных(здоровье, сила итд) 3-4 поля поведения(методов атаковать, вылечить итд). Создать абстрактный класс и иерархию
наследников. Расположить классы в пакет так, чтобы в основной программе небыло видно их полей. В не абстрактных классах
переопределить метод toString() так чтобы он возвращал название класса или имя. Создать в основной программе по одному
обьекту каждого не абстрактного класса и вывести в консоль его имя.
======================================================================
Добавить в проект класс, предназначенный для хранения координат. Добавить в абстрактный класс поле, экземпляр класс координат.
Пробросить координаты через конструкторы наследников так, чтобы создавая объекты вы передавали в параметры имя и координаты.
Скорректировать алгоритм заполнения команд. Кроме имен каждый персонаж должен иметь координаты. Одна команда находится с левой стороны,
другая с правой (y = 0, y = 9).
В класс лучников добавить метод поиск ближайшего противника. Алгоритм рассчета расстояний реализовать в классе координат.
======================================================================================

Добавить в файл интерфейса метод void step() это будет основной метод взаимодействыия с объектами. Добавить интерфейс
в базовый абстрактный класс. Реализовать этот метод во всех классах наследниках. Для начала просто заглушкой.
Доработать классы лучников. Лучник должен во первых проверить жив ли он и есть ли у него стрелы, если нет то завершить метод.
Есль всё да, то найти ближайшего противника и выстрелить по немы и, соответственно потратить одну стрелу.
Реализовать весь функционал лучников в методе step().
Добавить в абстрактный класс int поле инициатива.
В классах наследников инициализировать это поле. Крестьянин = 0, маги=1, пехота=2, лучники=3. В мэйне сделать так,
чтобы сначала делали ход персонажи с наивысшей инициативой из обеих комманд а с наименьшей в конце.
======================================================================================

Реализовать метод step() пехоты. Первое проверяем живы ли мы, потом ищем ближайшего противника. Если противник в соседней клетке,
наносим повреждение. Иначе двигаемся в сторну противника. Алгоритм движения, если dX>dY двигаемся по x иначе по y. dX и dY
(разница наших координат и ближайшего противника) знаковые, от знака зависит направление. Если

Формат сдачи: ссылка на гитхаб проект
======================================================================================
Добавить в проект классы View и AnsiColors(я вам их в телегу кину). Реализовать в вашем
проекте "основной цикл" с отображением View и реализовать gameOver.
======================================================================================


abstract class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }
    public abstract int getHealth();
    public abstract int getStrength();
    public abstract void attack();
    public abstract void heal();
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
class Peasant extends Person {
    private int health;
    private int strength;
    public Peasant(String name, int health, int strength) {
        super(name);
        this.health = health;
        this.strength = strength;
    }
    @Override
    public int getHealth() {
        return health;
    }
    @Override
    public int getStrength() {
        return strength;
    }
    @Override
    public void attack() {

    }
    @Override
    public void heal() {
    }
}
public class Main {
    public static void main(String[] args) {
        Person peasant = new Peasant("Крестьянин", 100, 10);
//      Person robber = new Robber("Разбойник", 80, 20);

        System.out.println(peasant.toString());
//        System.out.println(robber.toString());

    }

}
*/

import oop.hw_1_2.pers.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        heroesWhite = generateCommand(0, 1);
        heroesBlack = generateCommand(3, 10);
        heroOrder.addAll(heroesWhite);
        heroOrder.addAll(heroesBlack);
        heroOrder.sort(((o1, o2) -> o2.getInitiative() - o1.getInitiative()));


        Scanner scanner = new Scanner(System.in);
        boolean flag;
        while (true) {
            View.view();
            if (gameOverBlack()) {
                flag = true;
                break;
            }
            if (gameOverWhite()) {
                flag = false;
                break;
            }
            for (Hero h : heroOrder) {
                if (heroesBlack.contains(h)) {
                    h.step(heroesWhite, heroesBlack);
                } else {
                    h.step(heroesBlack, heroesWhite);
                }
            }
            scanner.nextLine();
        }
        if (flag) {
            System.out.println("Победила команда белых");
        } else {
            System.out.println("Победила команда черных");
        }
    }

/*
        heroOrder.forEach(n -> System.out.println(n.getInitiative()));

        System.out.println("******************************");

        heroesWhite.forEach(n -> System.out.println(n.toString()));
        System.out.println("******************************");
        heroesBlack.forEach(n -> System.out.println(n.toString()));

//        heroesBlack.forEach(n -> n.printEnemyDistance(heroesWhite));
        heroesBlack.forEach(n -> n.step(heroesBlack, heroesWhite));
        heroesWhite.forEach(n -> n.step(heroesWhite, heroesBlack));







        System.out.println("******************************");
        heroesBlack.forEach(n -> System.out.println(n.toString()));
        System.out.println("******************************");
        heroesBlack.forEach(n -> n.printEnemyDistance(heroesWhite));
*/

        public static boolean gameOverWhite () {
            for (Hero hero : heroesWhite) {
                if (hero.health > 0) return false;
            }
            return true;
        }

        public static boolean gameOverBlack () {
            for (Hero hero : heroesBlack) {
                if (hero.health > 0) return false;
            }
            return true;
        }


        public static ArrayList<Hero> heroesWhite = new ArrayList<>();
        public static ArrayList<Hero> heroesBlack = new ArrayList<>();
        public static ArrayList<Hero> heroOrder = new ArrayList<>();

        static ArrayList<Hero> generateCommand ( int n, int y){
            ArrayList<Hero> commandHeroes = new ArrayList<>();
            Random random = new Random();
            int rand;


            for (int i = 0; i < 11; i++) {
                rand = random.nextInt(1, 5) + n;
//            (int) Math.random()*10;
                switch (rand) {
                    case 1:
                        float minDist = 0;
                        commandHeroes.add(new Crossbower(getName(), i, y, minDist));
                        break;
                    case 2:
                        commandHeroes.add(new Monk(getName(), i, y));
                        break;
                    case 3:
                        commandHeroes.add(new Pikeman(getName(), i, y));
                        break;
                    case 4:
                        commandHeroes.add(new Peasant(getName(), i, y));
                        break;
                    case 5:
                        commandHeroes.add(new Rogue(getName(), i, y));
                        break;
                    case 6:
                        commandHeroes.add(new Sniper(getName(), i, y));
                        break;
                    case 7:
                        commandHeroes.add(new Wizard(getName(), i, y));
                        break;
                }
            }
            return commandHeroes;
        }

        static String getName () {
            return NameOfHeroes.values()[new Random().nextInt(NameOfHeroes.values().length - 1)].name();
        }


        //    protected int initiative;


}




