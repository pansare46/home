
import org.ad.demo.model.ClassWithFinalMethods;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ClassWithFinalMethods.class)
public class PowerMockFinalMethodTest {
    public static final Logger log = LoggerFactory.getLogger(PowerMockFinalMethodTest.class);

    @Test
    public void testClassWithFinalMethods_printMessage_finalMethod() throws Exception {
        String message="Hello PowerMockito";
        //Create a mock Object
        ClassWithFinalMethods mockObject= PowerMockito.mock(ClassWithFinalMethods.class);
        //whenNew() method makes sure that whenever an instance of this class is made using the new keyword by
        // invoking a no argument constructor, this mock instance is returned instead of the real object.
        PowerMockito.whenNew(ClassWithFinalMethods.class).withNoArguments().thenReturn(mockObject);
        //invoke the no argument constructor to make an instance of the system under test
        ClassWithFinalMethods object= new ClassWithFinalMethods();
        //verify whether no argument constructor was called
        PowerMockito.verifyNew(ClassWithFinalMethods.class).withNoArguments();
        //set an expected String on final method using String we defined
        PowerMockito.when(object.printMessage(message)).thenReturn(message);
        log.info(message.toString());
        String helloPowerMockito=object.printMessage(message);
        //Verify final method is actually called
        Mockito.verify(object).printMessage(message);
        //Assert expectations to the actual String returned to us
        Assert.assertEquals(message,helloPowerMockito);
    }
}
