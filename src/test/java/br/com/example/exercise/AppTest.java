package br.com.example.exercise;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.io.IOException;

public class AppTest {
    @Test
    public void testMain() throws IOException {
        App app = new App();
        String[] args = {"15"};
        try{
            app.main(args);
            assertTrue( true );
        } catch (Exception err) {
            assertTrue( false );
        }
    }

    @Test
    public void testMainZeroVal() throws IOException {
        App app = new App();
        String[] args = {"0"};
        try{
            app.main(args);
            assertTrue( true );
        } catch (Exception err) {
            assertTrue( false );
        }
    }

}
