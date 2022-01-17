import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class RunMain {
    public static void main(String[] args) throws SQLException {
//        Connection
//        DriverManager
//        Statement
//        PreparedStatement
//        ResultSet

//        Connection connection = SQLServerConnection.getJDBCConnection();
//        Statement statement = connection.createStatement();

        // 1. read data
//        String sqlSelect = "select * from users";
//        ResultSet resultSet = statement.executeQuery(sqlSelect);
//        while (resultSet.next()) {
//            String username = resultSet.getString("username");
//            System.out.println(username);

        List<User> users = SQLProcess.readAllUser();
        users.forEach(System.out::println);

        // 2. insert data
//        SQLProcess.insertUser("5", "vietdz183", "viet123");

        // 3. update data
//        SQLProcess.updateUser("3", "vietvit1803", "123789");
//
//        // 4. delete data
//        SQLProcess.deleteUser("5");


        Connection connection1 = SQLServerConnection.getJDBCConnection();
        String sqlSelect = "select * from users where id = ? and username = ?";
        PreparedStatement preparedStatement = connection1.prepareStatement(sqlSelect);
        preparedStatement.setString(1, "3");
        preparedStatement.setString(2, "vietvit1803");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2));
        }
    }
}
