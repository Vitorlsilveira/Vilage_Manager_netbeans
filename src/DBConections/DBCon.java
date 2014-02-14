package DBConections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
import datas.Home;

import datas.Persion;
import java.sql.ResultSet;
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
            //    persion.setAddress(encryptedPersion.getId());

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
        createConnecction();
        String sql = "INSERT INTO home VALUES('" + home.getHoemnumber() + "','" + home.getOwner() + "','" + home.getAddress() + "','"
                + "" + home.getTpnumber() + "','" + home.getNumofmembers() + "');";
        System.out.println("sql " + sql);
        Statement st = (Statement) con.createStatement();
        st.executeUpdate(sql);
        con.close();
    }

    public Persion searchPersons(String id) throws SQLException, ClassNotFoundException {
        Persion decryptedPersion = new Persion();
        createConnecction();
        String sql = "select * from persion where ID='" + id + "'";

        Connection connection = con;
        java.sql.Statement stm = (java.sql.Statement) connection.createStatement();
        ResultSet res = stm.executeQuery(sql);
        if (res.next()) {
            Persion prsn = new Persion(id, res.getString("Name"), res.getString("Sex"), res.getString("Address"), res.getString("TPNum"), res.getString("Birth_date"));
            try {
                decryptedPersion = security.decryptPersion(prsn);
            } catch (Exception ex) {
                Logger.getLogger(DBCon.class.getName()).log(Level.SEVERE, null, ex);
            }
            return decryptedPersion;
        } else {
            return null;
        }
    }

}
