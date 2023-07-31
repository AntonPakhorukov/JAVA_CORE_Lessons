public class BaseHuman {
    protected int height;
    protected int maxJump;
    protected int maxRun;
    private String soname;

    public BaseHuman(String soname) {
        this.soname = soname;
    }

    public String getSoname() {
        return soname;
    }

    public void setSoname(String soname) {
        this.soname = soname;
    }
    public void printDescription(){
        System.out.println(soname);
    }

    // для видимости в интерфейсе
    public int getMaxJump() {
        return maxJump;
    }

    public int getMaxRun() {
        return maxRun;
    }
}
