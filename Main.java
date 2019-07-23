import java.sql.*;

public class Main {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/deposito";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "1234";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   /*try {
	   Class.forName(JDBC_DRIVER);
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      System.out.println("Connection success");
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      stmt.executeUpdate("delete from registrodecompras where quantidade = 40");
	      stmt.close();
	      conn.close();
	      return;
   } catch (Exception e) {} */
   try{
      Class.forName(JDBC_DRIVER);
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      System.out.println("Connection success");
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql_select, sql_insert, sql_update;
      //sql_insert = "INSERT INTO registrodecompras VALUES ('cristalina', 40, '25/07/2019')";
      sql_select = "SELECT quantidade FROM registrodecompras WHERE mercadoria = 'cristalina' AND datadecompra = '23/07/2019'";
      //stmt.executeUpdate(sql_insert);
      //String select = "SELECT quantidade FROM mercadoria WHERE nome = 'cristalina'";
//      ResultSet rs = stmt.executeQuery(select);
//      int quantidade = 0;
//      while(rs.next()) {
//    	  quantidade = rs.getInt(1);
//      }
      //sql_update = "UPDATE mercadoria SET quantidade ="+ (quantidade + 40) +", entrada = '25/07/2019' where nome = 'cristalina'";
      //stmt.executeUpdate(sql_update);
      ResultSet rs = stmt.executeQuery(sql_select);
      int total = 0;
      while(rs.next()){
    	  total = total + rs.getInt(1);
      }
      System.out.println("Total de aguas compradas no dia: "+ total);
      
      stmt.close();
      conn.close();
   } catch (ClassNotFoundException e) {
	   System.out.println("Class not found");
   } catch (SQLException e) {
       e.printStackTrace();
   }
   
      /*
      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT C_ID, C_BALANCE, C_FIRST, C_LAST FROM customer LIMIT 10";
      ResultSet rs = stmt.executeQuery(sql);

      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         int id  = rs.getInt("C_ID");
         int age = rs.getInt("C_BALANCE"); 
         String first = rs.getString("C_FIRST");
         String last = rs.getString("C_LAST");

         //Display values
         System.out.print("ID: " + id);
         System.out.print(", Balance: " + age);
         System.out.print(", First: " + first);
         System.out.println(", Last: " + last);
      }
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
   */
}//end main
}//end FirstExample