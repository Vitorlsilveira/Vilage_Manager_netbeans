package DBConnections;

import DBConections.DBCon;
import datas.Home;
import datas.Persion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import logics.Logics;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DBConTest {

    private DBCon db = new DBCon();
    private Persion kasun = new Persion();
    private Logics logic = new Logics();
    private Home myhome = new Home();

    public void setKasun() {
        this.kasun.setName("Kasun");
        this.kasun.setId("901081930v");
        this.kasun.setSex(logic.getSexFromId("901081930v"));
        this.kasun.setAddress("Hali-Ela");
        this.kasun.setBirthday(logic.getBirthDateUsingId("901081930v"));
        this.kasun.setTpnum("0719751748");
    }

    public void setMyHome() {
        this.myhome.setHoemnumber("AAAA");
        this.myhome.setOwner("Ranathunga");
        this.myhome.setAddress("Hali-Ela");
        this.myhome.setNumofmembers(4);
        this.myhome.setTpnumber("0552051119");
    }

    @Test
    public void testCreateConnection() throws ClassNotFoundException {
        db.createConnecction();
        Assert.assertNotNull(db.con);
    }

    @Test
    public void testCloseConnection() throws ClassNotFoundException {
        db.createConnecction();
        try {
            db.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DBConTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Assert.assertNull(db.con);
    }

    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Persion ID is already in database")
    public void testAddPersionDataException() {
        setKasun();
        db.addPersionToDatabase(kasun);
    }

    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Home ID already in Database")
    public void testAddHomeToDatabaseException() {
        setMyHome();
        db.addHomeToDatabase(myhome);
    }

    @Test
    public void testSerchPersionById() {
        Persion persion = db.searchPersons("901081930v");
        Assert.assertEquals(persion.getId(), kasun.getId());
    }

    @Test
    public void testSerchHomeById() {
        try {
            Home home = db.searchHome("AAAA");
        } catch (Exception ex) {
            System.out.println("Error " + ex);
        }
    }
}
