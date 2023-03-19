import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest
{
    Address testA;

    @BeforeEach
    void setUp()
    {
        testA = new Address("Name Here", "Street Here", "City Here", "State Here", "Zip Code Here");
    }

    @Test
    void formatAddress()
    {
        assertEquals("Name Here\nStreet Here\nCity Here, State Here Zip Code Here", testA.formatAddress());
    }
}