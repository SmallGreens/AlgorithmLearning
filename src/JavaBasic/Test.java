package JavaBasic;

/**
 * @author Matt
 * @date 2021/2/2 16:38
 */
public class Test {

    public static void main(String[] args) {
        Children children = new Children("XX");
        System.out.println(children.getAge());
        /**
         * static 方法也可以通过实例对象访问。不过 似乎不推荐。
         */
        children.sayHello();
    }
}
