package JavaBasic;

/**
 * @author Matt
 * @date 2021/2/2 16:07
 */
public class Children extends Father{

    /**
     * 如果父类中没有 default 方法，会报如下错误！！
     * There is no default constructor available in 'JavaBasic.Father'
      *
     * @param name
     */
    public Children(String name) {
        super(name);
    }

    public static void sayHello(){
        System.out.println("hello");
    }
}
