package repository;

import entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("unused")
public class ProductRepository {

    Connection connection;

    public ProductRepository(Connection connection) {
        this.connection = connection;
    }

    public int save(Product product) throws SQLException {
        String save = """
                INSERT INTO product(PRODUCTNAME, CREATEDATE, CATEGORY, BRAND) VALUES (?,?,?,?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(save, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setString(2, product.getCreateDate());
        preparedStatement.setInt(3, product.getCategory().getCategoryId());
        preparedStatement.setInt(4, product.getBrand().getBrandId());
        if (preparedStatement.getGeneratedKeys().next()){
            product.setProductId(preparedStatement.getGeneratedKeys().getInt(1));
        }
        return preparedStatement.executeUpdate();

    }
    public int edit(int id , String productName) throws SQLException {
        String editProduct = """
                UPDATE product SET productname = ? WHERE productid = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(editProduct);
        Product product = new Product();
        preparedStatement.setString(1, productName);
        preparedStatement.setInt(2, id);
        return preparedStatement.executeUpdate();
    }

    public int delete(int id) throws SQLException {
        String delete = """
                DELETE FROM product WHERE productid = ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        Product product = new Product();
        preparedStatement.setInt(1,id);
        return preparedStatement.executeUpdate();
    }
}
