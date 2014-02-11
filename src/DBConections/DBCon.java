
package DBConections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
import datas.Home;

import datas.Persion;
import java.sql.ResultSet;

public class DBCon{
    
    private  Connection con = null;
    
    public DBCon(){
    }
    
    public void createConnecction(){
        	try {
		 con =
	       DriverManager.getConnection("jdbc:mysql://localhost/vilage", "root", "root");
		
	} catch (SQLException ex) {
                    System.out.println("Error "+ex);
		}
		//return con;
	}
    
    
    public void addPersionToDatabase(Persion persion) throws SQLException{
        createConnecction();
        String sql = "INSERT INTO persion VALUES('"+persion.getName()+"','"+persion.getId()+"','"+persion.getSex()+"','"
                + ""+persion.getAddress()+"','"+persion.getTpnum()+"','"+persion.getBirthday()+"');";
        
        System.out.println("sql "+sql);
        
        Statement st = (Statement) con.createStatement();
        
        st.executeUpdate(sql);
        con.close();
    }
    
    public void addHomeToDatabase(Home home) throws SQLException{
        createConnecction();
        String sql = "INSERT INTO home VALUES('"+home.getHoemnumber()+"','"+home.getOwner()+"','"+home.getAddress()+"','"
                + ""+home.getTpnumber()+"','"+home.getNumofmembers()+"');";
        System.out.println("sql "+sql);
        Statement st = (Statement) con.createStatement();
        st.executeUpdate(sql);
        con.close();
    }
    
    
    public Persion searchPersons(String id) throws SQLException, ClassNotFoundException{
        createConnecction();
        String sql="select * from persion where ID='"+id+"'";
        
        Connection connection=con;
        java.sql.Statement stm=(java.sql.Statement) connection.createStatement();
        ResultSet res=stm.executeQuery(sql);
        if(res.next()){
            return new Persion(id,res.getString("Name"),res.getString("Sex"),res.getString("Address"),res.getString("TPNum"),res.getString("Birth_date"));
        }else{
            return null;
        }
    }
    
}
