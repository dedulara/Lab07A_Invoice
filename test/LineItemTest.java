import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineItemTest
{
    LineItem testLI;
    Product testP;

    @BeforeEach
    void setUp()
    {
        testP = new Product("Description", 5);
        testLI = new LineItem(testP, 10);
    }

    @Test
    void productLineFormat()
    {
        assertEquals("Description                     $  5.00    10   $   50.00", testLI.productLineFormat());
    }
}