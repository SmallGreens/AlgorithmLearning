package JavaBasic;

/**
 * @author Matt
 * @date 2021/2/2 16:06
 */
public class Father {
    private String name;
    private int age;
    private String home;
    public Father(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }
}
