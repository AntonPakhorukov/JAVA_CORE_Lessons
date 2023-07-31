public class Human extends BaseHuman implements Runner, Comparable<Human>{

    String name;
    public String getName() {
        return name;
    }

    int age;

    public Human() {
        //super("some_soname"); // можно так
        this("name", 18, "any_soname", 173); // можно и так прописывать по умолчанию
    }

    @Override
    public void printDescription() { // можно переопределить базовый метод
//        super.printDescription();
        if (getSoname().equals("any_soname")){
            System.out.println("not enter soname");
        } else {
            System.out.println(getSoname());
        }
    }

    public Human(String name, int maxJump, int maxRun) {
        super("soname");
        this.maxJump = maxJump;
        this.maxRun = maxRun;
        this.name = name;
    }

    public Human(String name, int age, String soname, int height) {
        super(soname); // Нужно вызывать первым!!! потом все остальное
        this.name = name;
        if (age <= 0) {
            throw new RuntimeException("Не корректный возраст");
        } else {
            this.age = age;
        }
        this.height = height; // protected будет виден в subclass
    }

    @Override
    public int compareTo(Human o) {
        if (this == o){
            return 0;
        }
        return this.name.compareTo(o.name);
    }

    // сделали по дефолту в интерфейсе
//    @Override
//    public boolean jump(int height) {
//        if (height <= maxJump) {
//            System.out.printf("%s удалось перепрыгнуть через стену %d см\n", name, height);
//            return true;
//        } else {
//            System.out.printf("%s не смог перепрыгнуть через стену %d см, остался на месте\n", name, height);
//            return false;
//        }
//    }
//    @Override
//    public boolean run(int length) {
//        if (length <= maxRun) {
//            System.out.printf("%s удалось пробежать дистанцию %d метров\n", name, length);
//            return true;
//        } else {
//            System.out.printf("%s не смог пробежать дистанцию %d метров, остался на дистанции\n", name, length);
//            return false;
//        }
//    }
}
