package test;

import domain.Cirkel;
import domain.DomainException;
import domain.Punt;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CirkelTest {
    @Test
    public void createValidCircle() {
        Cirkel c = new Cirkel(new Punt(200, 200), 20);

        assertEquals(new Punt(200, 200), c.getMiddelpunt());
        assertEquals(20, c.getRadius());
    }

    @Test(expected = DomainException.class)
    public void createCircleRadiusNotPositive() {
        Cirkel c = new Cirkel(new Punt(200, 200), -6);
    }

    @Test(expected = DomainException.class)
    public void createCircleRadiusNotZero() {
        Cirkel c = new Cirkel(new Punt(200, 200), 0);
    }

    @Test(expected = DomainException.class)
    public void createCircleMiddelpuntNotNull() {
        Cirkel c = new Cirkel(null, 20);
    }

    @Test
    public void testEquals() {
        Cirkel c = new Cirkel(new Punt(200, 200), 20);
        Cirkel c2 = new Cirkel(new Punt(200, 200), 20);

        assertEquals(c.equals(c2), true);
    }

    @Test
    public void testEqualsWithNull() {
        Cirkel c = new Cirkel(new Punt(200, 200), 20);

        assertNotEquals(null, c);
    }

    @Test
    public void testEqualsWithDifferentRadius() {
        Cirkel c = new Cirkel(new Punt(200, 200), 20);
        Cirkel c2 = new Cirkel(new Punt(200, 200), 25);

        assertNotEquals(c, c2);
    }

    @Test
    public void testEqualsWithDifferentMiddelpunt() {
        Cirkel c = new Cirkel(new Punt(200, 200), 20);
        Cirkel c2 = new Cirkel(new Punt(200, 250), 20);

        assertNotEquals(c, c2);
    }
}
