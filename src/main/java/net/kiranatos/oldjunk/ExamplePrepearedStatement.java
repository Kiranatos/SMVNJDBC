//package net.kiranatos.oldjunk; //ПРИМЕР ВСТАВКИ В БД
//
//import com.mysql.fabric.jdbc.FabricMySQLDriver;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.sql.Connection;
//import java.sql.Driver;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Calendar;
//import java.util.Date;  //import java.sql.Date;
//
//public class ExamplePrepearedStatement {    
//    private static final String HOST = "jdbc:mysql://localhost:3306/userpass";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "root";    
//    //вместо ?,?,?,?,?,?,? будут подставлятся значения ниже в методах .setТИП
//    private static final String INSERT_NEW = "INSERT INTO pairpass VALUES(?,?,?,?,?,?,?)";    
//    
//    public static void main(String[] args) {        
//        Connection connection = null;
//        PreparedStatement preS = null;  //Разница от Statement: данные изначально скомпилированы, что дает прирост в скорости        
//        try {
//            Driver d = new FabricMySQLDriver();
//            DriverManager.registerDriver(d);
//            connection = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
//            preS = connection.prepareStatement(INSERT_NEW); //отличие от Statement - вставляется и создается SQL-запрос
//            
//            //эти методы подставляют значения вместо ?,?,?,?,?,?,? описанных выше
//            //первый аргумент либо номер позиции (знак ?), либо название колонки в которую вставляем
//            preS.setInt(1, 2);
//            preS.setString(2, "Inserted texte");
//            preS.setString(3, "Inserted texte");
//            preS.setFloat(4, 0.2f);
//            preS.setBoolean(5, true);
//            preS.setDate(6, (java.sql.Date)new Date(Calendar.getInstance().getTimeInMillis()));
//            preS.setBlob(7, new FileInputStream("file.png")); //эта ячейка в БД является картинкой            
//            preS.execute(); // метод execute выполняет все запросы, описнные выше.
//            
//        } catch (SQLException | FileNotFoundException ex) { ex.printStackTrace(); }
//    }    
//}
