
package DBConections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

import datas.Persion;

public class DBCon{
    
    private  Connection con = null;
    
    public DBCon(){
        
    }
    
    
    public void createConnecction(){
        	try {
		 con =
	       DriverManager.getConnection("jdbc:mysql://localhost/vilage?" +
	                                   "user=root&password=root");
		
	} catch (SQLException ex) {
                    System.out.println("Error "+ex);
		}
		//return con;
	}
    
    
    public void addPersionToDatabase(Persion persion) throws SQLException{
        createConnecction();
        String sql = "INSERT INTO persion VALUES('"+persion.getName()+"','"+persion.getId()+"','"+persion.getSex()+"','"
                + ""+persion.getAddress()+"','"+persion.getTpnum()+"');";
        
        Statement st = (Statement) con.createStatement();
        
        st.executeUpdate(sql);
        con.close();
    }
    
}
