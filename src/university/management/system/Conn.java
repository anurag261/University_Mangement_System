
package university.management.system;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    Conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // connection string
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagemensystem","root","shubam");
            // to run sql query
            s = c.createStatement();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String []args) {
        
    }
    
}
