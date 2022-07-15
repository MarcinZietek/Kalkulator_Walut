package pl.atos.Dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class KalkulatorDaoTest {

    @Test
    public void testClassDaoExists() {
        try {
            Class.forName("pl.atos.Dao.KalkulatorDao");
        } catch (ClassNotFoundException e) {
            Assertions Assert = null;
            Assert.fail("should have a class called KalkulatorDao");
        }
    }

    
    @Test
    void getValues() {

    }

    @Test
    void getCurrency() {
    }
}