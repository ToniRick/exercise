package br.com.example.exercise.solution;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ResponseTest {
    @Test
    public void testExercise1() {
        try{
            Response response = new Response();
            response.exercise1(10);
            assertTrue( true );
        } catch (Exception err) {
            assertTrue( false );
        }
    }

    @Test
    public void testExercise2() {
        try{
            Response response = new Response();
            response.exercise2();
            assertTrue( true );
        } catch (Exception err) {
            assertTrue( false );
        }
    }

}