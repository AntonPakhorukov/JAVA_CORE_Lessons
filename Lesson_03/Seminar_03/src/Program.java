import java.util.ArrayList;
import java.util.Objects;

public class Program {
    public static void main(String[] args) {
        Human human1 = new Human();
        human1.name = "User";
        human1.age = 20;
        //System.out.println(human1.getSoname());

        Human human2 = new Human("User2", 15, "soname", 171);
        //human2.setSoname("soname");
        // human2.soname = "soname2"; не в доступе
        //System.out.println(human2.getSoname());
        //System.out.println(human2.height);
        human2.height = 173;
        //System.out.println(human2.height);
        //System.out.println(human2.name);
        //printHuman(human2);
        //Test.printHeight(human2);

        Human human3 = new Human();
       // System.out.println(human3.name + " " + human3.getSoname() + " " + human3.age + " " + human3.height);
        // выведет базовые параметры
        //human3.printDescription();
        human3.setSoname("new_soname");
        //human3.printDescription();
        //System.out.println(human1.compareTo(human2)); // -1
        //System.out.println(human1.compareTo(human1)); // 0

//        Robot robot1 = new Robot(); // наследуется от BaseRobot, доступны run / jump
//        BaseRobot robot2 = new Robot();// наследуется от Object
//        Object robot3 = new Robot(); // базовый класс
//        Runner robot4 = new Robot(); // так же будет работать, доступны run / jump
        /**
         * Создали полосу препятствий
         */
        Obstacle[] obstacles = {
                new Track(1200),
                new Wall(30),
                new Track(2000),
                new Wall(140),
                new Track(3000),
                new Wall(250)
        };

        ArrayList<Runner> runners = new ArrayList<>();
        runners.add(new Cat("Barsik", 300, 1500));
        runners.add(new Cat("Murzic", 230, 1700));
        runners.add(new Robot("Robotics", 50, 9999));
        runners.add(new Robot("R2D2", 0, 5000));
        runners.add(new Human("Mark", 150, 2500));
        runners.add(new Human("Garry", 350, 3500));

        for (Runner runner: runners) {
            for (Obstacle obstacle: obstacles) {
                if (obstacle instanceof Track) {
                    if(!runner.run(obstacle.getLength()))
                        break;
                } else if (obstacle instanceof Wall) {
                    if (!runner.jump(obstacle.getHeight()))
                        break;
                }
            }
        }


    }
    private static void printHuman(Human human){
        System.out.println(human.height);
        System.out.println(human.name);
    }
}
