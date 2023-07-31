import java.text.BreakIterator;

/**
 * Создание локального класса
 */
public class Animal {
    /**
     * Создали метод для Animal, сделать какое-то действие
     * @param state принимает значение спит или нет
     */
    void performBehavior(boolean state) {
        /**
         * Создаем класс "мозг" и метод sleep
         * который в состоянии сна скажет спит
         */
        class Brain {
            void sleep() {
                if (state) {
                    System.out.println("Sleeping");
                } else {
                    System.out.println("Not sleeping");
                }
            }
        }
        /**
         * Создали объект класса Brain
         * вызвали метод sleep
         */
        Brain brain = new Brain();
        brain.sleep();
    }
}
