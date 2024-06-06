import java.sql.*;

public class JDBCTesting {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to MySQL database
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Execute some testing queries
            executeTestingQueries(connection);

            // Close connection
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Failed to connect to the database!");
            e.printStackTrace();
        }
    }

    private static void executeTestingQueries(Connection connection) throws SQLException {
        // Sample testing queries
        String query1 = "SELECT * FROM users";
        String query2 = "INSERT INTO users (username, password) VALUES ('test_user', 'test_password')";

        // Execute query 1 (SELECT)
        System.out.println("Executing query: " + query1);
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query1)) {
            while (resultSet.next()) {
                // Process each row of the result set
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("User ID: " + id + ", Username: " + username + ", Password: " + password);
            }
        }

        // Execute query 2 (INSERT)
        System.out.println("Executing query: " + query2);
        try (Statement statement = connection.createStatement()) {
            int rowsAffected = statement.executeUpdate(query2);
            System.out.println("Rows affected: " + rowsAffected);
        }
    }
}
