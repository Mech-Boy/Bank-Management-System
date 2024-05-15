package Connections;
import java.sql.*;

public class SqlConnection {

      public   Connection c;
      public   Statement s;
        public SqlConnection(){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                c=DriverManager.getConnection("Your Url","UserName","Password");
                s=c.createStatement();

            }catch (Exception e){
                System.out.println(e);
            }
        }

}
