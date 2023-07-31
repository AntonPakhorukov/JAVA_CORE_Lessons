public interface Runner {
//    boolean jump(int height);
//    boolean run (int length);

    // можно прописать методы здесь по дефолту, и не переписывать в классах
    String getName(); // возвращает нам имя
    int getMaxJump(); // возвращает нам высоту
    int getMaxRun(); // возвращает нам длину
    default boolean jump(int height) {
        if (height <= getMaxJump()) {
            System.out.printf("%s удалось перепрыгнуть через стену %d см\n", getName(), height);
            return true;
        } else {
            System.out.printf("%s не смог перепрыгнуть через стену %d см, остался на месте\n", getName(), height);
            return false;
        }
    }

    default boolean run(int length) {
        if (length <= getMaxRun()) {
            System.out.printf("%s удалось пробежать дистанцию %d метров\n", getName(), length);
            return true;
        } else {
            System.out.printf("%s не смог пробежать дистанцию %d метров, остался на дистанции\n", getName(), length);
            return false;
        }
    }
}
