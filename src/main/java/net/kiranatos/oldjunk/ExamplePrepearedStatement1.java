//package net.kiranatos.oldjunk; //ПРИМЕР УДАЛЕНИЯ И ПЛУЧЕНИЯ ИНФОРМАЦИИ ИЗ БД
//
//import com.mysql.fabric.jdbc.FabricMySQLDriver;
//import java.sql.Connection;
//import java.sql.Driver;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Date;
//
//public class ExamplePrepearedStatement1 {    
//    private static final String HOST = "jdbc:mysql://localhost:3306/userpass";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "root";    
//    private static final String GET_ALL = "SELECT * FROM pairpass";
//    private static final String DELETE = "DELETE FROM pairpass WHERE id=3";
//    
//    public static void main(String[] args) {        
//        Connection connection = null;
//        PreparedStatement preS = null;  //Разница от Statement: данные изначально скомпилированы, что дает прирост в скорости        
//        try {
//            Driver d = new FabricMySQLDriver();
//            DriverManager.registerDriver(d);
//            connection = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
//            
//            //УДАЛЕНИЕ
//            preS = connection.prepareStatement(DELETE);
//            preS.setInt(1, 2);
//            preS.executeUpdate(); //Для создания эффекта
//            
//            //ПОЛУЧЕНИЕ ЭЛЕМЕНТОВ
//            preS = connection.prepareStatement(GET_ALL);
//            
//            ResultSet rS = preS.executeQuery(); //executeQuery - Для получения результата
//                        
//            while ( rS.next() )  {                
//                int id = rS.getInt("id");
//                String title = rS.getString("column2");
//                String desc = rS.getString("column3");
//                float rating = rS.getFloat("column4");
//                boolean boo = rS.getBoolean("column5");
//                Date date = rS.getDate("column6");
//                byte[] loop = rS.getBytes("column7");                
//                System.out.println("id:" + id + " ...");
//            }
//        } catch (SQLException ex) { ex.printStackTrace(); }        
//    }    
//}