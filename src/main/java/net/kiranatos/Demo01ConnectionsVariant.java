package net.kiranatos;

import java.sql.Connection;
import java.sql.Driver; /* not a com.mysql.cj.jdbc.Driver, old version: import com.mysql.jdbc.Driver; */
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01ConnectionsVariant { /*
    jdbc:mysql://localhost:3306/mybdname
    jdbc - Driver
    mysql - database type
    localhost - location or IP
    3306 - port
    mybdname - name of my database */
    
    private final static String path = "jdbc:mysql://localhost:3306/library";
    private final static String login = "root";
    private final static String pass = "Acquaintance6022";
    
    public static void main(String[] args) {
        Demo01ConnectionsVariant demo = new Demo01ConnectionsVariant();
        demo.demonstration2015_1();
        demo.demonstration2015_2();
        demo.demonstration2020();
    }
    
    // version of 2015
    private void demonstration2015_1() {
        try {
            Driver driver = new com.mysql.cj.jdbc.Driver(); // very old varaint: com.mysql.fabric.jdbc.FabricMySQLDriver;(); from installed MySQL folder
            DriverManager.registerDriver(driver); // manager have to register db driver
            Connection connection = DriverManager.getConnection(path, login, pass); // get connection with database
            Statement state = connection.createStatement();            
            demonstrationQuery(state);            
            connection.close(); // By closing connection object statement and ResultSet will be closed automatically.            
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
    
    // version of 2015
    private void demonstration2015_2() {
        try { /* Class.forName() приводит к загрузке класса и инициализации его статической части.
            В свою очередь многие JDBC драйвера при статической инициализации регистрируют себя в DriverManager'е.
            Для некоторых драйверов нужно создавать инстанс, так как они инициализируются в конструкторе.
            В этом случае код будет Class.forName("com.mysql.cj.jdbc.Driver").newInstance(); как более надежный вариант. */
            Class.forName("com.mysql.cj.jdbc.Driver"); // old version: com.mysql.jdbc.Driver;           
            Connection connection = DriverManager.getConnection(path + "?user=" + login + "&password=" + pass);
            Statement state = connection.createStatement();            
            demonstrationQuery(state);
            connection.close();
        } catch (SQLException ex) { ex.printStackTrace();            
        } catch (ClassNotFoundException en) { en.printStackTrace(); }
    }

    // version of 2020
    private void demonstration2020() {
        /* Since Java 7, JDBC has ability to use try-with-resources statement to automatically close
        resources of type Connection, ResultSet, and Statement.*/
        try (Connection conn = DriverManager.getConnection(path,login,pass); 
                //Statement - для выполнения SQL-запросов к БД                
                Statement state = conn.createStatement()) {
            demonstrationQuery(state);
        } catch (SQLException ex) { ex.printStackTrace(); }
    }
    
    private void demonstrationQuery(Statement state) throws SQLException {
        // можно использовать, только для SELECT
        ResultSet resultSet = state.executeQuery("select * from book;");
        while (resultSet.next()) {
            String name = resultSet.getString(2);
            System.out.println("Book name : " + name);
        }
    }    
}
