package Project;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class e1 {

    Connection con =null;

    public static Connection dbconnect()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/register","root","");
            return conn;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
    }
}