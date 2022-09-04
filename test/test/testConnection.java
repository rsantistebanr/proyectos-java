
package test;

import Config.connection;
import java.io.IOException;
import java.sql.SQLException;


public class testConnection {

    testConnection testCon;
    public testConnection() throws SQLException, IOException{
        this.testCon = new testConnection();
                
    }

    public static void main(String[] args) throws SQLException {
        
        connection con = new connection();
        
        if(con != null){
             System.out.println("Conexión exitosa.... ");
            System.out.println("--------------------");
        } else {
            System.out.println(con);
        }
    }
    
}
