package repository;

import entity.Shareholder_Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Shareholder_BrandRepository {
        Connection connection;

        public Shareholder_BrandRepository(Connection connection) {
            this.connection = connection;
        }

        public int save( Shareholder_Brand shareholder_brand ) throws SQLException {
            String save = """
                INSERT INTO shareholder_brand(shareholderId, brandId) VALUES (?,?)
                """;
            PreparedStatement preparedStatement = connection.prepareStatement(save);
            preparedStatement.setInt(1, shareholder_brand.getShareholderId());
            preparedStatement.setInt(2, shareholder_brand.getBrandId());
            return preparedStatement.executeUpdate();
        }

        public int delete( int shareholderId, int brandId ) throws SQLException {
            String delete = """
                DELETE FROM shareholder_brand WHERE shareholderId =? AND brandId = ?
                """;
            Shareholder_Brand shareholder_brand = new Shareholder_Brand();
            PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1,shareholderId);
            preparedStatement.setInt(2,brandId);
            return preparedStatement.executeUpdate();
        }

        public Shareholder_Brand[] loadAll() throws SQLException {
            String sql = "SELECT * FROM shareholder_brand";
            PreparedStatement preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.last();
            Shareholder_Brand[] shareholder_brands = new Shareholder_Brand[resultSet.getRow()];
            resultSet.beforeFirst();
            int counter = 0;
            while (resultSet.next()) {
                shareholder_brands[counter] = new Shareholder_Brand(
                        resultSet.getInt(1),
                        resultSet.getInt(2)
                );
                counter++;
            }
            return shareholder_brands;
        }
    }

