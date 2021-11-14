package net.kiranatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestMySQL {
    private final static String path = "jdbc:mysql://localhost:3306/library";
    private final static String login = "root";
    private final static String pass = "Acquaintance6022";
    
    public static void main(String[] args) throws FileNotFoundException {
        try (Connection connection = DriverManager.getConnection(path,login,pass);                 
                Statement state = connection.createStatement()) {
            executeScript(connection, new FileInputStream("rfiles/dbcreate.sql"));
        } catch (SQLException ex) { ex.printStackTrace(); }
        
        
        
    }
    
    private static void executeScript(Connection conn, InputStream in) throws SQLException {
        Scanner s = new Scanner(in, "UTF-8");
        s.useDelimiter("/\\*[\\s\\S]*?\\*/|--[^\\r\\n]*|;");
        try (Statement st = conn.createStatement()) {
            while (s.hasNext()) {
                String line = s.next().trim();
                if (!line.isEmpty()) {
                    st.execute(line);
                }
            }
        }
    }
}
