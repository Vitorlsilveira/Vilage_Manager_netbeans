package logics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LogicsTest {

    private Logics logics = null;

    public LogicsTest() {
        logics = new Logics();
    }

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
    public void getSexFromIdTest1() {
        String expect = "Male";
        String result = logics.getSexFromId("901081930v");
        assertEquals(result, expect);
    }

    @Test
    public void getSexFromIdTest2() {
        String expect = "Female";
        String result = logics.getSexFromId("906081930v");
        assertEquals(result, expect);
    }

    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Invalid numbers")
    public void getSexFromIdTestExceptions() {
      logics.getSexFromId("vvvvvvvvvv");     
    }
    
    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Wrong Id Number")
    public void getSexFromIdTestExceptions1() {
      logics.getBirthDateUsingId("904011232v");     
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
