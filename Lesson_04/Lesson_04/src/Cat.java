/**
 * Статический вложенный класс Cat
 */
public class Cat {
    /**
     * Объявляем поля имя, цвет и возраст
     */
    private String name, color;
    private int age;

    /**
     * Создаем 2 конструктора
     */
    public Cat() { }
    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    /**
     * Объявляем класс Голос
     */
    static class Voice {
        /**
         * Объявляем поле громкость
         */
        private final int volume;

        /**
         * Создаем конструктор, который принимает уровень громкости
         * @param volume громкость
         */
        public Voice (int volume) {this.volume = volume;}

        /**
         * Создаем метод подать голос
         */
        public void sayMur() {
            System.out.printf("A cat purrs with volume %d\n", volume);
        }
    }
}
