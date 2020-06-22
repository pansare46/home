import org.ad.demo.privatecontent.ClassWithPrivateMethods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ClassWithPrivateMethods.class)
public class PowerMockPrivateMethodTest {

    @Test
    public void testClassPrivateMethods_printMessage_privateMethod() throws Exception {
        String message="Private Methods";
        String expectation="Expectation";
        //Prepare
        ClassWithPrivateMethods mock = PowerMockito.spy(new ClassWithPrivateMethods());
        //set expectations
        PowerMockito.doReturn(expectation).when(mock,"printMessage",message);
        //verify
        //String actual=mock.printMessage(message);



    }
}
