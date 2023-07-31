public class BaseRobot {
    protected String name;
    protected int maxRun;
    protected int maxJump;
    // для видимости в интерфейсе
    public String getName() {
        return name;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public int getMaxRun() {
        return maxRun;
    }
}
