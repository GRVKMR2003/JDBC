package DB;
import java.sql.*;

public class JDBCTesting {

    public void createDB(){
        
    }
    public static void createTable() {


        // try{

        //     String url = "jdbc:mysql://localhost:3306/college"; 
        //     String uname = "root";
        //     String pass = "Grv788943%";
        //     String query = "create table grv (id int primary key, name varchar(50) , age int not null)";
        //     Class.forName("com.mysql.cj.jdbc.Driver");
        //     Connection con = DriverManager.getConnection(url, uname, pass);
        //     Statement st = con.createStatement();
            
        //     st.execute(query);
        //     System.out.println("Table created succesfully");
            
            
        //     st.close();
        //     con.close();
        // }catch(Exception e){
        //     e.printStackTrace();
        // }


    }

    public static void createdata(){

        
        try{

            String url = "jdbc:mysql://localhost:3306/college"; 
            String uname = "root";
            String pass = "Grv788943%";
            String query = "INSERT into grv Values(1,'shiv', 20)";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, uname, pass);
            Statement st = con.createStatement();
            
            st.execute(query);
            System.out.println("Data inserted succesfully");
            
            
            st.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void read(){


        
        try{

            String url = "jdbc:mysql://localhost:3306/college"; 
            String uname = "root";
            String pass = "Grv788943%";
            String query = "Select * from grv";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, uname, pass);
            Statement st = con.createStatement();
            
             ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.println("id = " + rs.getInt(1) );
                System.out.println("name = " + rs.getString(2) );
                System.out.println("age = " + rs.getInt(3) );
            }
            System.out.println("u can read  the table");
            
            
            st.close();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void update(){
        try {
            String url = "jdbc:mysql://localhost:3306/college";
            String uname = "root";
            String pass = "Grv788943%";
            String query = "UPDATE grv SET id = ? WHERE name = ? AND age = ?";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, uname, pass);

            // Use PreparedStatement to set parameters dynamically
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, 2); // Set id to 2
            ps.setString(2, "ram"); // Set name to "ram"
            ps.setInt(3, 21); // Set age to 21

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data updated successfully");
            } else {
                System.out.println("No data updated");
            }

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
