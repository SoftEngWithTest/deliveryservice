package ie.gmit;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class OrderTest {

    Order order;
    @Test
    void testOrderIdSuccess(){
        order = new Order("123888");
        assertEquals("123888",order.getOrderId());
    }

    @Test
    void testOrderIdFail(){
        assertThrows(IllegalArgumentException.class,()->new Order("1234"));
    }


}
