public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.name = "Barsik";
        cat1.age = 4;
        int x = cat1.pawsCount;
        cat1.say();
//        cat1.pawsCount = 6; // если final, то изменить не сможем
        cat1.pawsCount2 = 6; // можно переназначить
        System.out.println(cat1.pawsCount2); // сработает, но виден не будет
        System.out.println(Cat.pawsCount); // так будет виден, это общее для всех котов
        cat1.soname = "Barsik";


        Cat cat2 = new Cat();
        cat2.name = "Murzik";
        cat2.age = 6;
        cat2.jump();
        cat2.setDown(); // сработает, но виден не будет в подсказках
        cat2.soname = "Murzic";

        System.out.println("Cat1 is " + cat1.soname + ", and Cat2 is " + cat2.soname); // семантическая ошибка

    }
}
