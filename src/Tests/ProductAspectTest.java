package Tests;

import AspectsYo.productLogger;
import Services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;

import java.time.chrono.ChronoLocalDateTime;

public class ProductAspectTest {

    private productLogger pLog;


    @Before
    public void setUp() {
        pLog = Mockito.mock(productLogger.class);
        ReflectionTestUtils.setField(pLog, "Instance", pLog);

    }

    @org.junit.jupiter.api.Test
    public void testProductShit() {
        ProductService ps = new ProductService();
        ps.productAdded();
    }
}
