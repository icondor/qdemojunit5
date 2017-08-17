import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {



    final static String URL = "jdbc:postgresql://localhost:5432/mydb";
    final static String USERNAME = "userdb";
    final static String PASSWORD = "password1";

    public boolean getTaskList(int idUser) {

        boolean foundAtLeastOne=false;

        try {

            Class.forName("org.postgresql.Driver");

            // 3. obtain a connection
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);



            String query = "SELECT * FROM tasklistionel where fkiduser = ? order by taskname asc";

            // 4. create a query statement
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,idUser);


            // 5. execute a query
            ResultSet rs = st.executeQuery();

            // 6. iterate the result set and print the values
            while (rs.next()) {
                System.out.println("many tasks here");
                int id = rs.getInt("id");
                String name = rs.getString("taskname");
                boolean isdone = rs.getBoolean("isdone");



                foundAtLeastOne=true;

            }

            System.out.println("getting tasks from db, closing everything");
            rs.close();
            st.close();
            conn.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return foundAtLeastOne;
    }

}
