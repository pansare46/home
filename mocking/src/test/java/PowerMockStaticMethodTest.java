import org.ad.demo.staticcontent.ClassWithStaticMethod;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ClassWithStaticMethod.class)
public class PowerMockStaticMethodTest {
    public static final Logger log = LoggerFactory.getLogger(PowerMockFinalMethodTest.class);

    @Test
    public void testClasswithStaticMethod_printMessage_staticMethod(){
        String message= "Hello Static ";
        String expectation="Expectation";
        //preparation
        PowerMockito.mockStatic(ClassWithStaticMethod.class);
        //setting up the expectations
        PowerMockito.when(ClassWithStaticMethod.printMessage(message)).thenReturn(expectation);
        String actual=ClassWithStaticMethod.printMessage(message);
        log.info("Tests");
        //verification
        Assert.assertEquals(expectation,actual);
    }
}
