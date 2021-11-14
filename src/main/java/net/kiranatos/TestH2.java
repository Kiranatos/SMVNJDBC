package net.kiranatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestH2 {

    private static final String JDBC_URL = "jdbc:h2:~/test2";
//    private static final String JDBC_URL_MEM = "jdbc:h2:mem:";
    private static final String JDBC_USERNAME = "sa";
    private static final String JDBC_PASSWORD = "";
    private static final String CREATE_TABLE_ACCOUNT = "create table if not exists account("
            + "id serial, "
            + "username VARCHAR (50) UNIQUE NOT NULL, "
            + "password VARCHAR (50) NOT NULL, "
            + "email VARCHAR (355) UNIQUE NOT NULL, "
            + "created_on TIMESTAMP NOT NULL, "
            + "last_login TIMESTAMP, "
            + "primary key (id));";
    private static final String ADD_ACCOUNT = 
            "insert into account (username, password, email, created_on) values"
            + "('username 6', 'password_6', 'email_6', now())";
    private static final String GET_ALL_ACCOUNTS = "select * from account";

    public static void main(String[] args) throws SQLException {        
        DriverManager.registerDriver(new org.h2.Driver());
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
                Statement statement = connection.createStatement()) {
            
            statement.execute(CREATE_TABLE_ACCOUNT);
            statement.execute(ADD_ACCOUNT);

            ResultSet rs = statement.executeQuery(GET_ALL_ACCOUNTS);
            int i = 0;
            while (rs.next()) {
                System.out.printf("%d: %s %s %s %s \n", ++i, rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getObject("created_on"),
                        rs.getTimestamp("last_login"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
