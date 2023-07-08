import com.atguigu.spring.aop.annotation.Calculator;
import com.atguigu.spring.aop.annotation.CalculatorImpl;
import com.atguigu.spring.aop.annotation.LoggerAspect;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    @Test
    public void testAOPByAnnotation(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-aop.xml");
        // 通过被代理对象的接口类来获取代理对象的bean
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.add(1, 2);
       // calculator.div(1,0);
    }
}
