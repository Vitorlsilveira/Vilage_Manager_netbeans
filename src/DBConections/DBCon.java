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

    private Connection con = null;
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

    public void addPersionToDatabase(Persion persion) throws SQLException {
        try {
            Persion encryptedPersion = new Persion();
            encryptedPersion = security.encryptPersion(persion);
            System.out.println("Encrypted ID : " + encryptedPersion.getId());
            createConnecction();

            String sql = "INSERT INTO persion VALUES('" + encryptedPersion.getName() + "','" + encryptedPersion.getId() + "','" + encryptedPersion.getSex() + "','"
                    + "" + encryptedPersion.getAddress() + "','" + encryptedPersion.getTpnum() + "','" + encryptedPersion.getBirthday() + "');";

            System.out.println("sql " + sql);

            Statement st = (Statement) con.createStatement();

            st.executeUpdate(sql);
            con.close();
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
        con.close();
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
                prsn = new Persion(res.getString("ID"), res.getString("Name"), res.getString("Sex"), res.getString("Address"), res.getString("TPNum"), res.getString("Birth_date"));
                try {
                    decryptedPersion = security.decryptPersion(prsn);
                } catch (Exception ex) {
                    Logger.getLogger(DBCon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(DBCon.class.getName()).log(Level.SEVERE, null, ex);
        }

        return decryptedPersion;
    }

    public Home searchHome(String num) throws Exception {
        Home decryptedHome = new Home();
        String encryptedhomeid = security.encrypt(num);
        System.out.println("encryptedhomeid : "+encryptedhomeid);
        createConnecction();
        String sql = "select * from home where Home_Number='" + encryptedhomeid + "'";
        System.out.println("sql : "+sql);
        Connection connection = con;
        java.sql.Statement stm = (java.sql.Statement) connection.createStatement();
        ResultSet res = stm.executeQuery(sql);
        if (res.next()) {
            Home home = new Home(res.getString("Home_Number"), res.getString("Owner"), res.getString("Address"), res.getString("TP_Number"), res.getInt("NumberOfMembers"));
            System.out.println("Home number : "+home.getHoemnumber());
            try {
                decryptedHome = security.decryptHome(home);
                System.out.println("Encrypted address "+home.getAddress());
                System.out.println("Encrypted TP "+home.getTpnumber());
                System.out.println("decryptedHome TP : "+decryptedHome.getTpnumber());
            } catch (Exception ex) {
                Logger.getLogger(DBCon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return decryptedHome;
    }

    public List<Home> getSearchHome(String name) throws Exception {
        String encryptName = security.encrypt(name);
        System.out.println("encryptName : "+encryptName);
        createConnecction();
        java.sql.Statement stm = con.createStatement();
        String sql = "Select * From home where Owner='" + encryptName + "'";
        System.out.println("sql : "+sql);
        ResultSet res = stm.executeQuery(sql);
        List<Home> customerList = new ArrayList<>();
        while (res.next()) {
            Home hme = new Home(res.getString("Home_Number"), res.getString("Owner"), res.getString("Address"), res.getString("TP_Number"), res.getInt("NumberOfMembers"));
            Home home = security.decryptHome(hme);
            customerList.add(home);
        }
        return customerList;
    }

}
