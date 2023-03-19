import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest
{
    Invoice testI;
    Address testA2;

    @BeforeEach
    void setUp()
    {
        testA2 = new Address("Name Here", "Street Here", "City Here", "State Here", "Zip Code Here");
        testI = new Invoice(testA2);
    }

    @Test
    void formatInvoice()
    {
        assertEquals("                       I N V O I C E\n\nName Here\nStreet Here\nCity Here, State Here Zip Code Here\n==========================================================\n\n" +
                "Description                      Price    Qty    Total\n----------------------------------------------------------\n" +
                "==========================================================\n\nAMOUNT DUE: $    0.00", testI.formatInvoice());
    }
}