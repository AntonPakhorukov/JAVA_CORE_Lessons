import org.w3c.dom.ls.LSOutput;

import javax.crypto.spec.PSource;

public class Main {
    enum Color {
        RED("#FF0000"), GREEN("00FF00"), BLUE("0000FF");
        private String code;

        Color(String code){
            this.code = code;
        }
        public String getCode() {
            return code;
        }
    }

    private static class Orange2 { // создали объект апельсин
        /**
         * Создали поле класса Juice2
         */
        private Juice2 juice2;

        /**
         * Создали конструктор основного класса Orange2
         * в котором создается объект Juice2 и присваивается ссылка на него полю juice2
         */
        public Orange2() {
            this.juice2 = new Juice2();
        }

        /**
         * Создали метод "выжать сок" и внутри вызвали метод "сок капал"
         */
        public void squeezeJuice2() {
            System.out.println("Squeeze juice...");
            juice2.flow2();
        }

        /**
         * Создали подобъект сок
         * внутри создали метод "сок капал"
         */
        private class Juice2 {
            public void flow2() {
                System.out.println("Juice dripped...");
            }
        }
    }
    public static void main(String[] args) {
        /**
         * Можем создать переменную класса Season и поместить туда одно значение из enum
         * Метод ordinal возвращает порядковый номер определенной константы, нумерация с 0
         */
        Season current = Season.AUTUMN;
        System.out.println(current);
        System.out.println(current.ordinal());
        /**
         * Создали массив типа enum и поместили в него все значения enum
         * циклом foreach можем вывести их все на экран
         */
        Season[] seasons = Season.values();
        for (Season s: seasons) {
            System.out.printf("%s ", s); // WINTER SPRING SUMMER AUTUMN
        }

        System.out.println();
        /**
         * Создали класс enum в методе main
         * через цикл foreach вывели значения
         */
        for (Color c : Color.values()){
            System.out.printf("%s(%s) ", c, c.getCode()); // RED(#FF0000) GREEN(00FF00) BLUE(0000FF)
        }

        System.out.println();
        /**
         * ВНУТРЕННИЙ КЛАСС
         * создали отдельный класс Orange и внутри него создали вложенный класс Juice
         * в основном классе создали отдельно апельсин, отдельно сок путем вызова конструкторов
         * ЕСТЬ ПРИВЯЗКА ВНУТРЕННЕГО КЛАССА С ВНЕШНИМ
         */
        Orange orange = new Orange(); // создали апельсин - основной класс
        Orange.Juice juice = orange.new Juice(); // создали вложенный класс на основе экземпляра класса Orange
        orange.squeezeJuice(); // вызов метода - Squeeze juice...
        juice.flow();// вызов метода - Juice dripped...
        System.out.println();
        Orange2 orange2 = new Orange2();
        orange2.squeezeJuice2(); // Squeeze juice... Juice dripped...

        System.out.println();
        /**
         * ЛОКАЛЬНЫЙ КЛАСС
         * создали класс Animal
         * и вызвали метод, в который передали состояние
         * ЕСТЬ ПРИВЯЗКА ВНУТРЕННЕГО КЛАССА С ВНЕШНИМ
         */
        Animal animal = new Animal();
        animal.performBehavior( false); // sleeping / Not sleeping

        System.out.println();
        /**
         * СТАТИЧНЫЙ ВНУТРЕННИЙ КЛАСС
         * при создании нужно указывать внешний класс
         * создали подкласс Voice без внешнего класса Cat
         * и запустили метод sayMur
         * НЕТ ПРИВЯЗКИ К ВНЕШНЕМУ КЛАССУ
         */
        Cat.Voice voice = new Cat.Voice(100);
        voice.sayMur(); // A cat purrs with volume 100
        for (int i = 0; i < 10; i++){
            Cat.Voice voice1 = new Cat.Voice(100 + i);
            voice1.sayMur();
        }
    }
}
