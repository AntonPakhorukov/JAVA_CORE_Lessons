public class Robot extends BaseRobot implements Runner{
    public Robot(String name, int maxJump, int maxRun) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    // сделали по дефолту в интерфейсе
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
//
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
}
