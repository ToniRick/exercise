package br.com.example.exercise.model;

import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class CountryTest {
    @Test
    public void testCountry() throws IOException {
        try{
            Country country = new Country();
            country.setCode("");
            country.setName("");
            List test = new ArrayList();
            country.setLanguages(test);
            assertTrue( true );
        } catch (Exception err) {
            assertTrue( false );
        }
    }
}
