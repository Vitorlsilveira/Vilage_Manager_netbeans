package DBConections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
import datas.Home;

import datas.Persion;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import securaty.Security;

public class DBCon {

    public Connection con = null;
    Security security = new Security();

    public DBCon() {
    }

    public void createConnecction() {
        try {
            con
                    = DriverManager.getConnection("jdbc:mysql://localhost/vilage", "root", "root");

        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
        //return con;
    }

    public void closeConnection() throws SQLException {
        con.close();
    }

    public void addPersionToDatabase(Persion persion) throws SQLException {
        try {
            Persion encryptedPersion = new Persion();
            encryptedPersion = security.encryptPersion(persion);
            System.out.println("Encrypted ID : " + encryptedPersion.getId());
            createConnecction();

            String sql = "INSERT INTO persion VALUES('" + encryptedPersion.getName() + "','" + encryptedPersion.getId() + "','" + encryptedPersion.getSex() + "','"
                    + "" + encryptedPersion.getAddress() + "','" + encryptedPersion.getTpnum() + "',"
                    + "'" + encryptedPersion.getBirthday() + "','" + encryptedPersion.getHomeNumber() + "');";

            System.out.println("sql " + sql);

            Statement st = (Statement) con.createStatement();

            System.out.println("Created a Statement");

            st.executeUpdate(sql);
            closeConnection();
        } catch (Exception ex) {
            Logger.getLogger(DBCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addHomeToDatabase(Home home) throws SQLException {
        Home encryptedHome = new Home();
        try {
            encryptedHome = security.encryptHome(home);
        } catch (Exception ex) {
            Logger.getLogger(DBCon.class.getName()).log(Level.SEVERE, null, ex);
        }

        createConnecction();
        String sql = "INSERT INTO home VALUES('" + encryptedHome.getHoemnumber() + "','" + encryptedHome.getOwner() + "','" + encryptedHome.getAddress() + "','"
                + "" + encryptedHome.getTpnumber() + "','" + encryptedHome.getNumofmembers() + "');";
        System.out.println("sql " + sql);
        Statement st = (Statement) con.createStatement();
        st.executeUpdate(sql);
        closeConnection();
    }

    public Persion searchPersons(String id) throws Exception {
        Persion decryptedPersion = null;
        Persion prsn = null;
        try {
            String encryptedId = security.encrypt(id);
            createConnecction();
            String sql = "select * from persion where ID='" + encryptedId + "'";
            Connection connection = con;
            java.sql.Statement stm = (java.sql.Statement) connection.createStatement();
            ResultSet res = stm.executeQuery(sql);
            if (res.next()) {
                prsn = new Persion(res.getString("ID"), res.getString("Name"), res.getString("Sex"), res.getString("Address"), res.getString("TPNum"), res.getString("Birth_date"), res.getString("Home_Number"));
                try {
                    decryptedPersion = security.decryptPersion(prsn);
                } catch (Exception ex) {
                    return null;
                }
            }
            closeConnection();
        } catch (Exception ex) {
            //Logger.getLogger(DBCon.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return decryptedPersion;
    }

    public List<Persion> getSearchPersionByHN(String hNum) throws Exception {
        String encrypname = security.encrypt(hNum);
        System.out.println("encryptName : " + encrypname);
        createConnecction();
        java.sql.Statement stm = con.createStatement();
        String sql = "Select * From persion where Home_Number='" + encrypname + "'";
        System.out.println("sql : " + sql);
        ResultSet res = stm.executeQuery(sql);
        List<Persion> persionList = new ArrayList<>();
        while (res.next()) {
            Persion pers = new Persion(res.getString("ID"), res.getString("Name"), res.getString("Sex"), res.getString("Address"), res.getString("TPNum"), res.getString("Birth_Date"), res.getString("Home_Number"));
            Persion persion = security.decryptPersion(pers);
            persionList.add(persion);
        }
        return persionList;
    }

    public Home searchHome(String num) throws Exception {
        Home decryptedHome = new Home();
        String encryptedhomeid = security.encrypt(num);
        System.out.println("encryptedhomeid : " + encryptedhomeid);
        createConnecction();
        String sql = "select * from home where Home_Number='" + encryptedhomeid + "'";
        System.out.println("sql : " + sql);
        Connection connection = con;
        java.sql.Statement stm = (java.sql.Statement) connection.createStatement();
        ResultSet res = stm.executeQuery(sql);
        if (res.next()) {
            Home home = new Home(res.getString("Home_Number"), res.getString("Owner"), res.getString("Address"), res.getString("TP_Number"), res.getInt("NumberOfMembers"));
            System.out.println("Home number : " + home.getHoemnumber());
            try {
                decryptedHome = security.decryptHome(home);
                System.out.println("Encrypted address " + home.getAddress());
                System.out.println("Encrypted TP " + home.getTpnumber());
                System.out.println("decryptedHome TP : " + decryptedHome.getTpnumber());
            } catch (Exception ex) {
                return null;
            }
        }
        closeConnection();
        return decryptedHome;
    }

    public List<Home> getSearchHome(String name) throws Exception {
        String encryptName = security.encrypt(name);
        System.out.println("encryptName : " + encryptName);
        createConnecction();
        java.sql.Statement stm = con.createStatement();
        String sql = "Select * From home where Owner='" + encryptName + "'";
        System.out.println("sql : " + sql);
        ResultSet res = stm.executeQuery(sql);
        List<Home> customerList = new ArrayList<>();
        while (res.next()) {
            Home hme = new Home(res.getString("Home_Number"), res.getString("Owner"), res.getString("Address"), res.getString("TP_Number"), res.getInt("NumberOfMembers"));
            Home home = security.decryptHome(hme);
            customerList.add(home);
        }
        closeConnection();
        return customerList;
    }

    public void updatePersionData(Persion persion) throws Exception {
        Persion encryptedpersion = null;
        try {
            encryptedpersion = security.encryptPersion(persion);
        } catch (Exception ex) {
            Logger.getLogger(DBCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        createConnecction();
        String sql = "UPDATE persion SET Name= '" + encryptedpersion.getName() + "',"
                + " ID='" + encryptedpersion.getId() + "', Address='" + encryptedpersion.getAddress() + "', "
                + "TPNum='" + encryptedpersion.getTpnum() + "' WHERE ID='" + encryptedpersion.getId() + "';";

        Statement st = (Statement) con.createStatement();
        st.executeUpdate(sql);
        System.out.println("Done ...");
        closeConnection();
    }

    public void deletePersionData(String id) throws Exception {
        String encryptid = null;
        try {
            encryptid = security.encrypt(id);
            System.out.println("decrypted ID : " + security.decrypt(encryptid));
        } catch (Exception ex) {
            Logger.getLogger(DBCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        createConnecction();
        String sql = "DELETE FROM persion WHERE ID='" + encryptid + "';";
        Statement st = (Statement) con.createStatement();
        st.executeUpdate(sql);
        closeConnection();
    }

    public List<Persion> getSearchPersion(String tPNum) throws Exception {
        String encryptNum = security.encrypt(tPNum);
        System.out.println("encryptTPNum : " + encryptNum);
        createConnecction();
        java.sql.Statement stm = con.createStatement();
        String sql = "Select * From persion where TPNum='" + encryptNum + "'";
        System.out.println("sql : " + sql);
        ResultSet res = stm.executeQuery(sql);
        List<Persion> persionList = new ArrayList<>();
        while (res.next()) {
            Persion pers = new Persion(res.getString("ID"), res.getString("Name"), res.getString("Sex"), res.getString("Address"), res.getString("TPNum"), res.getString("Birth_Date"), res.getString("Home_Number"));
            Persion persion = security.decryptPersion(pers);
            persionList.add(persion);
        }
        closeConnection();
        return persionList;
    }

    public List<Persion> getSearchPersionByName(String name) throws Exception {
        String encrypname = security.encrypt(name);
        System.out.println("encryptName : " + encrypname);
        createConnecction();
        java.sql.Statement stm = con.createStatement();
        String sql = "Select * From persion where Name='" + encrypname + "'";
        System.out.println("sql : " + sql);
        ResultSet res = stm.executeQuery(sql);
        List<Persion> persionList = new ArrayList<>();
        while (res.next()) {
            Persion pers = new Persion(res.getString("ID"), res.getString("Name"), res.getString("Sex"), res.getString("Address"), res.getString("TPNum"), res.getString("Birth_Date"), res.getString("Home_Number"));
            Persion persion = security.decryptPersion(pers);
            persionList.add(persion);
        }
        closeConnection();
        return persionList;
    }

    public void editHomeDetails(Home home) throws Exception {
        Home encryptedhome = new Home();
        try {
            encryptedhome = security.encryptHome(home);
        } catch (Exception ex) {
            Logger.getLogger(DBCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        createConnecction();

        String sql = "UPDATE home SET Home_Number= '" + encryptedhome.getHoemnumber() + "',"
                + " Owner='" + encryptedhome.getOwner() + "', Address='" + encryptedhome.getAddress() + "', "
                + "TP_Number='" + encryptedhome.getTpnumber() + "', NumberOfMembers=" + encryptedhome.getNumofmembers() + ""
                + " WHERE Home_Number='" + encryptedhome.getHoemnumber() + "';";

        Statement st = (Statement) con.createStatement();

        st.executeUpdate(sql);

        closeConnection();
    }

    public void delHomedetails(String homeid) throws Exception {
        String encrypthomeid = null;
        try {
            encrypthomeid = security.encrypt(homeid);
        } catch (Exception ex) {
            Logger.getLogger(DBCon.class.getName()).log(Level.SEVERE, null, ex);
        }
        createConnecction();
        String sql = "DELETE FROM home WHERE Home_Number='" + encrypthomeid + "';";
        Statement st = (Statement) con.createStatement();
        st.executeUpdate(sql);
        closeConnection();
    }
}
