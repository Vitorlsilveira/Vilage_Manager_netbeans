package security;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import securaty.Security;

public class SecurityTest {

    private Security security = null;

    public SecurityTest() {
        security = new Security();
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

    @Test(dataProvider = "addDataProvider")
    public void getEncryptTest(String str) {
        String encryptedStr = null;
        try {
            encryptedStr = security.encrypt(str);
        } catch (Exception ex) {
            System.out.println("Error in Test" + ex);
        }

        String decryptdStr = "ab";

        try {
            decryptdStr = security.decrypt(encryptedStr);
        } catch (Exception ex) {
            System.out.println("Error in Test" + ex);
        }
        assertEquals(str, decryptdStr);
    }

    @DataProvider(name = "addDataProvider")
    public Object[][] getDataProvider() {
        return new Object[][]{
            {"WheRe U Coming From"},
            {"HE IS A MAN"},
            {"hi i am simple "},
            {"055 1236 54422 "},
            {"!@$%^&*()*&^.?/:"}
        };
    }
}
