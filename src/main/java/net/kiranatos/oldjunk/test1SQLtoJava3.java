package net.kiranatos.oldjunk;
/*
import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.Connection;
import java.sql.Driver; //import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test1SQLtoJava3 {
    final static String path = "jdbc:mysql://localhost:3306/phonebook";
    final static String login = "root";
    final static String pass = "root";
    
    public static void main(String[] args) {        
        try {
            Driver d = new FabricMySQLDriver();            
            DriverManager.registerDriver(d);
        } catch (SQLException ex) { ex.printStackTrace(); }        
        
        try (Connection conn = DriverManager.getConnection(path,login,pass); 
                Statement state = conn.createStatement();   //Statement - для выполнения SQL-запросов к БД                
                ) {
            //можно использовать INSERT, SELECT
            state.execute("insert into contacts (ФИО, phone, company) values('Milana', '0676667788', 'Simens'");
        
            //можно использовать INSERT, UPDATE, DELETE. Получать данные (SELECT) этим методом - нельзя!
            int a = state.executeUpdate("update contacts set ФИО='Лорана', company='Toshiba' where id=3;");            
            System.out.println("Количество изменённых записей: " + a);
            
            //можно использовать, только для SELECT
            ResultSet set = state.executeQuery("SELECT * FROM phonebook.contacts;");
            
            //пакетная обработка:
            state.addBatch("insert into contacts (ФИО, phone) values('Йос', '063-802-09-62');");
            state.addBatch("insert into contacts (ФИО, phone) values('Рендер', '093-678-72-43');");
            state.addBatch("insert into contacts (ФИО, phone) values('Даниелла Дана', '093-22-888-49');");
            state.addBatch("insert into contacts (ФИО, phone) values('Джунко', '093-570-22-07');");
            state.addBatch("insert into contacts (ФИО, phone) values('Химара', '093-895-55-33');");
            state.executeBatch(); //Производит все изменения описанные в addBatch-ах            
            state.clearBatch(); //вытирает старые запросы и теперь сюда можно поместить новые запросы
            
            //Возможные действия с классом Statement
            boolean st_mode = state.isClosed(), conn_mode = conn.isClosed();
            state.getConnection();
            state.close();
            System.out.println("Соединение с базой: " + conn.isClosed()); //false
        } catch (SQLException ex) { ex.printStackTrace(); }
    }    
}
*/