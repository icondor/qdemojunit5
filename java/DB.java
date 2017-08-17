import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DB {



    final static String URL = "jdbc:postgresql://localhost:5432/mydb";
    final static String USERNAME = "userdb";
    final static String PASSWORD = "password1";

    public List getTaskList(int userid) {

        System.out.println("getting tasks from db");

        try {

            Class.forName("org.postgresql.Driver");

            // 3. obtain a connection
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // 4. create a query statement
            Statement st = conn.createStatement();

            String query = "SELECT * FROM tasklistionel order by taskname asc";
            // 5. execute a query
            ResultSet rs = st.executeQuery(query);

            // 6. iterate the result set and print the values
            while (rs.next()) {
                System.out.println("many tasks here");
                int id = rs.getInt("id");
                String name = rs.getString("taskname");
                boolean isdone = rs.getBoolean("isdone");



                // 7. close the objects

            }

            System.out.println("getting tasks from db, closing everything");
            rs.close();
            st.close();
            conn.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println("miau");

        DB d = new DB();
        d.getTaskList(1);
    }
}
