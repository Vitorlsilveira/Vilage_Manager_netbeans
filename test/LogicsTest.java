/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import logics.Logics;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 *
 * @author kattz
 */
public class LogicsTest {
    private Logics logics = null;
    
    public LogicsTest() {
        logics = new Logics();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }
    
    @Test
    public void getSexFromIdTest1(){
        System.out.println(logics.getClass().toString());
        String expect = "Male";
        String result = logics.getSexFromId("901081930v");
        assertEquals(result, expect);
    }
    
    @Test
    public void getSexFromIdTest2(){
        System.out.println(logics.getClass().toString());
        String expect = "Female";
        String result = logics.getSexFromId("906081930v");
        assertEquals(result, expect);
    }
    
    @Test(expectedExceptions = NumberFormatException.class , expectedExceptionsMessageRegExp = "Invalid numbers")
    public void getSexFromIdTest3(){
        System.out.println(logics.getClass().toString());
        String result = logics.getSexFromId("vvvvvvvvvv");
        ///assertEquals(result, expect);     
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
