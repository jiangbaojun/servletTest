import com.test.initializer.App;
import com.test.initializer.App1;

/**
 * @Author: jiangbaojun
 * @Date: 2020/4/13 17:19
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println(App.class.isAssignableFrom(App1.class));
    }
}
