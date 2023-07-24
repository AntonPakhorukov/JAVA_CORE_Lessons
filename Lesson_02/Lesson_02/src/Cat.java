public class Cat {
    String name;
    static String soname;
    String color;
    int age;

    static final int pawsCount = 4; // не будет видна объекту
    static  int pawsCount2 = 4; // так же не увидит

    void jump() {
        System.out.println(name + " is jump");
    }
    void say() {
        System.out.println(name + " is meows");
    }

    static void setDown(){
        System.out.println("is setdown");
    }

}
