package Tests;

import AspectsYo.customerLogger;
import Services.CustomerService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;



public class TestClass {
    private customerLogger cLog;


        @Before
        public void setUp() {
            cLog = Mockito.spy(cLog);
            ReflectionTestUtils.setField(cLog, "instance", cLog);
        }
    @Test
    public void testShit() {
        CustomerService cs = new CustomerService();
        cs.customerAdded();


    }
}
