package pl.atos.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KalkulatorTest {

    @Test
    public void testClassExists() {
        try {
            Class.forName("pl.atos.model.Kalkulator");
        } catch (ClassNotFoundException e) {
            Assertions Assert = null;
            Assert.fail("should have a class called Kalkulator");
        }
    }
}