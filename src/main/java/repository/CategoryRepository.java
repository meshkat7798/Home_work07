package repository;
import entity.Category;

import java.sql.*;

@SuppressWarnings("unused")
public class CategoryRepository {
    Connection connection;

    public CategoryRepository(Connection connection) {
        this.connection = connection;
    }

    public int save(Category category) throws SQLException {
        String save = """
                INSERT INTO category(categoryname, categorydescription) VALUES (?,?)
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(save, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, category.getCategoryName());
        preparedStatement.setString(2, category.getCategoryDescription());
        if (preparedStatement.getGeneratedKeys().next()){
            category.setCategoryId(preparedStatement.getGeneratedKeys().getInt(1));
        }
        return preparedStatement.executeUpdate();
    }


    public int edit(int id , String categoryName, String categoryDescription) throws SQLException {
        String edit =  """
                UPDATE category SET categoryName = ? , categoryDescription = ? WHERE categoryId= ?
                """;
        PreparedStatement preparedStatement = connection.prepareStatement(edit);
        Category category = new Category();
        preparedStatement.setString(1, categoryName);
        preparedStatement.setString(2, categoryDescription);
        preparedStatement.setInt(3, id);
        return preparedStatement.executeUpdate();
    }

    public int delete(int id) throws SQLException {
        String delete = """
                DELETE FROM category WHERE categoryid =?
                """;
        Category category = new Category();
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1,id);
        return preparedStatement.executeUpdate();
    }
    public Category load(int id) throws SQLException {
        String sql = "SELECT * FROM category WHERE categoryId=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Category category = new Category();
        if (resultSet.next()){
            category.setCategoryId(resultSet.getInt(1));
            category.setCategoryName(resultSet.getString(2));
            category.setCategoryDescription(resultSet.getString(3));
        }
        return category;
    }

    public Category[] loadAll() throws SQLException {
        String sql = "SELECT * FROM category";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.last();
        Category[] categories = new Category[resultSet.getRow()];
        resultSet.beforeFirst();
        int counter = 0;
        while (resultSet.next()) {
            categories[counter] = new Category(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            );
            counter++;
        }
        return categories;
    }
}
