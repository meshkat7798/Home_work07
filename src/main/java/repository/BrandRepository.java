package repository;
import entity.Brand;

import java.sql.*;

@SuppressWarnings("unused")
public class BrandRepository {
    Connection connection;

    public BrandRepository(Connection connection) {
        this.connection = connection;
    }

    public int save(Brand brand) throws SQLException {
        String save = """
                INSERT INTO brand(BRANDNAME, BRANDWEBSITE, BRANDDESCRIPTION) VALUES (?,?,?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(save, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, brand.getBrandName());
        preparedStatement.setString(2, brand.getBrandWebsite());
        preparedStatement.setString(3, brand.getBrandDescription());
        if (preparedStatement.getGeneratedKeys().next()){
            brand.setBrandId(preparedStatement.getGeneratedKeys().getInt(1));
        }
        return preparedStatement.executeUpdate();
    }

    public int edit(int id , String brandName , String brandWebsite , String brandDescription) throws SQLException {
        String edit = """
                UPDATE brand SET brandname= ? , brandwebsite= ? , branddescription =? WHERE brandId = ?
                """;
        Brand brand = new Brand();
        PreparedStatement preparedStatement =connection.prepareStatement(edit);
        preparedStatement.setString(1, brandName);
        preparedStatement.setString(2, brandWebsite);
        preparedStatement.setString(3, brandDescription);
        preparedStatement.setInt(4, id);
        return preparedStatement.executeUpdate();
    }

    public int delete(int id) throws SQLException {
        String delete = """
                DELETE FROM brand WHERE brandid =?
                """;
        Brand brand = new Brand();
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1 ,id);
        return preparedStatement.executeUpdate();
    }
    public Brand load(int id) throws SQLException {
        String sql = "SELECT * FROM brand WHERE brandId=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Brand brand = new Brand();
        if (resultSet.next()){
            brand.setBrandId(resultSet.getInt(1));
            brand.setBrandName(resultSet.getString(2));
            brand.setBrandWebsite(resultSet.getString(3));
            brand.setBrandDescription(resultSet.getString(4));
        }
        return brand;
    }
    public Brand load(String name) throws SQLException {
        String sql = "SELECT * FROM brand WHERE brandName=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        Brand brand = new Brand();
        if (resultSet.next()){
            brand.setBrandId(resultSet.getInt(1));
            brand.setBrandName(resultSet.getString(2));
            brand.setBrandWebsite(resultSet.getString(3));
            brand.setBrandDescription(resultSet.getString(4));
        }
        return brand;
    }

    public Brand[] loadAll() throws SQLException {
        String sql = "SELECT * FROM brand";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.last();
        Brand[] brands = new Brand[resultSet.getRow()];
        resultSet.beforeFirst();
        int counter = 0;
        while (resultSet.next()) {
            brands[counter] = new Brand(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            );
            counter++;
        }
        return brands;
    }
}
