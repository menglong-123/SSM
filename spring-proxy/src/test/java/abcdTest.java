import com.atguigu.spring.pojo.User;
import com.atguigu.spring.proxy.Calculator;
import com.atguigu.spring.proxy.CalculatorImpl;
import com.atguigu.spring.proxy.CalculatorStaticProxy;
import com.atguigu.spring.proxy.ProxyFactory;
import org.junit.Test;

public class abcdTest {
    @Test
    public void testProxy(){
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        // 不知道动态生成的代理类的类名，但是知道动态代理类实现的接口，所以使用接口类型来接受生成的代理类
        Calculator proxy = (Calculator)proxyFactory.getProxy();
        proxy.add(1, 0);
    }
}
