import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {


    static void main() {
        String dbName = "demo";
        String url = "jdbc:postgresql://localhost:5432/" + dbName;
        String user = "postgres";
        String password = System.getenv("DB_PASSWORD");
        String query = "SELECT * FROM student";

        try (
                Connection con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                ResultSet resultSet = stmt.executeQuery(query);

        ) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("sname"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
