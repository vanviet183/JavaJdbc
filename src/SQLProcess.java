import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SQLProcess {
    static Connection connection = SQLServerConnection.getJDBCConnection();
    static Statement statement;

    static {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int insertUser(String id, String username, String password) {
        String sqlInsert = "insert into users values('"+id+"', '"+username+"', '"+password+"')";
        try {
            return statement.executeUpdate(sqlInsert);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int updateUser(String id, String username, String password) {
        String sqlUpdate = "update users set password = '"+password+"', "+" username = '"+username+"' where id = '"+id+"'";
        try {
            return statement.executeUpdate(sqlUpdate);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int deleteUser(String id) {
        String sqlDelete = "delete users where id='"+id+"'";
        try {
            return statement.executeUpdate(sqlDelete);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }


    public static List<User> readAllUser() {
        List<User> users = new ArrayList<>();
        String sqlSelect = "select * from users";
        try {
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()) {
                User user = new User(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
