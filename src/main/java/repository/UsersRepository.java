package repository;

import entity.Users;

import java.sql.*;

@SuppressWarnings("unused")

public class UsersRepository {
    private final Connection connection;

    public UsersRepository(Connection connection) {
        this.connection = connection;
    }

    public int singUp(Users users) throws SQLException {
        String singUp = """
                INSERT INTO users(name, username, password, email) VALUES (?,?,?,?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(singUp, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, users.getName());
        preparedStatement.setString(2, users.getUserName());
        preparedStatement.setString(3, users.getPassword());
        preparedStatement.setString(4, users.getEmail());
        if (preparedStatement.getGeneratedKeys().next()){
            users.setUserId(preparedStatement.getGeneratedKeys().getInt(1));
        }
        return preparedStatement.executeUpdate();
    }

    public Users singIn(String usersName) throws SQLException {
        String singIn = """
                SELECT * FROM users WHERE username = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(singIn);
        preparedStatement.setString(1,usersName);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Users(
                    resultSet.getInt("userId"),
                    resultSet.getString("name"),
                    resultSet.getString("userName"),
                    resultSet.getString("email"),
                    resultSet.getString("password")
            );
        } else {
            return null ;
        }
    }
}
