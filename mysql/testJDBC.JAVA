import java.sql.*;

public class TestJDBC {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test"; // Database URL
        String user = "rahul";                           // DB user
        String password = "1415";                        // DB password

        try {
            // 1. Connect to MariaDB
            Connection con = DriverManager.getConnection(url, user, password);

            // 2. Query the student table
            String query = "SELECT * FROM student";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // 3. Loop through results
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println(id + " " + name + " " + age);
            }

            // 4. Close connection
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
