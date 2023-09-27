package repository;

import entity.Shareholder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("unused")
public class ShareholderRepository {

    Connection connection ;

    public ShareholderRepository(Connection connection) {
        this.connection = connection;
    }

    public int save(Shareholder shareholder) throws SQLException {
        String save ="""
                INSERT INTO shareholder(SHAREHOLDERNAME, PHONENUMBER, NATIONALITYCODE) VALUES (?,?,?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(save, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, shareholder.getShareholderName());
        preparedStatement.setString(2, shareholder.getPhoneNumber());
        preparedStatement.setString(3, shareholder.getNationalityCode());
        if (preparedStatement.getGeneratedKeys().next()){
            shareholder.setShareholderId(preparedStatement.getGeneratedKeys().getInt(1));
        }
        return preparedStatement.executeUpdate();
    }

    public int edit(int id , String shareholderName,String phoneNumber,String nationalityCode) throws SQLException {
        String edit ="""
                UPDATE shareholder SET shareholdername = ? ,phonenumber = ? , nationalitycode = ? WHERE shareholderid = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        Shareholder shareholder = new Shareholder();
        preparedStatement.setString(1,shareholderName);
        preparedStatement.setString(2, phoneNumber);
        preparedStatement.setString(3,nationalityCode);
        preparedStatement.setLong(4,id);
        return preparedStatement.executeUpdate();
    }

    public int delete(int id) throws SQLException {
        String delete ="""
                DELETE FROM shareholder WHERE shareholderid = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        Shareholder shareholder = new Shareholder();
        preparedStatement.setInt(1,id);
        return preparedStatement.executeUpdate();
    }
}
