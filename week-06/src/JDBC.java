import java.sql.*;

public class JDBC {


    static void main() throws Exception {
        String dbName = "demo";
        String url = "jdbc:postgresql://localhost:5432/" + dbName;
        String user = "postgres";
        String password = System.getenv("DB_PASSWORD");
        int sid = 1;
        String sname = "Samir";
        int smark = 30;
        String selectAllQuery = "SELECT * FROM student";
        String insertRow = "INSERT INTO student VALUES(" +
                sid +
                ",'" +
                sname +
                "'," +
                smark +
                ")";

        String preparedQuery = "INSERT INTO student VALUES(?, ?, ?)";
        String deleteRow = "DELETE * FROM student WHERE  id > 1";
        String UpdateRow = "UPDATE student SET sname = 'Samir' WHERE sid = 2";

        try (
                Connection con = DriverManager.getConnection(url, user, password);
                Statement stmt = con.createStatement();
                PreparedStatement preparedStmt = con.prepareStatement(preparedQuery);

        ) {

//          Statement
//          stmt.executeUpdate(insertRow);

//          PreparedStatement
            preparedStmt.setInt(1, sid);
            preparedStmt.setString(2, sname);
            preparedStmt.setInt(3, sid);
            preparedStmt.executeUpdate();

            try (ResultSet resultSet = stmt.executeQuery(selectAllQuery)) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("sid");
                    String name = resultSet.getString("sname");
                    int mark = resultSet.getInt("smark");

                    System.out.printf("id: %d - name: %s - mark: %d%n", id, name, mark);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
