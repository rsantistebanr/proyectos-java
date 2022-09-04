package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class connection {

    //properties from the connection
    private String USERNAME = "root";
    private String PASSWORD = "123456789";
    private String HOST = "localhost";
    private String PORT = "3306";
    private String DATABASE = "tienda";
    private String CLASSNAME = "com.mysql.cj.jdbc.Driver";

    private String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?serverTimezone=UTC";
    private Connection con; //-> este atributo es parte de la class Connection de java

    public connection() throws SQLException {

        try {

            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "ERROR1");
            System.err.println("Error 1: " + e);

        } catch (SQLException s) {
JOptionPane.showMessageDialog(null, "RTTO2");
            System.err.println("Error 2: " + s);

        }
        
        
        
    }
    
    public Connection getConnection(){
            return con;
    }
    
    // close the connection
    public void close(){
        con = null;
    }

    
 
}
