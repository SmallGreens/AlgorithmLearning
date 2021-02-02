package JavaBasic;

/**
 * @author Matt
 * @date 2021/2/2 15:31
 *
 * 测试理解： java 的值传递机制。
 */
public class JavaCopyMechanism {

    public static void main(String[] args) {
        Student s1 = new Student("xiaoMing");
        Student s2 = new Student("xiaoZhang");
        JavaCopyMechanism.swap(s1, s2);
        System.out.println("s1:" + s1.getName());
        System.out.println("s2:" + s2.getName());

    }

    public static void swap(Student x, Student y){
//        Student temp = x;
//        x = y;
//        y = temp;

        String tmp = x.getName();
        x.name = y.getName();
        y.name = tmp;
        System.out.println("x:" + x.getName());
        System.out.println("y:" + y.getName());
    }





}

class Student{
    public String name;
    public Student(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
