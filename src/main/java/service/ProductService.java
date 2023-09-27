package service;

import entity.Product;
import repository.ProductRepository;

import java.sql.SQLException;
import java.util.Scanner;

@SuppressWarnings("unused")
public class ProductService {
    private final ProductRepository productRepository;
    Scanner scanner = new Scanner(System.in);

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(Product product) throws SQLException {
        int result = productRepository.save(product);
        if (result != 0)
            System.out.println("PRODUCT SUCCESSFULLY ADDED");
        else
            System.out.println("INVALID DATA");
    }

    public void edit(int id) throws SQLException {
        System.out.println("PLEASE ENTER YOUR NEW PRODUCT NAME :");
        String productName = scanner.nextLine();
        int result = productRepository.edit(id, productName);
        if (result != 0) {
            System.out.println("SUCCESSFULLY UPDATED");
        } else
            System.out.println("FAILED TO EDIT");
    }

    public void delete(int id) throws SQLException {
        int result = productRepository.delete(id);
        if (result != 0)
            System.out.println("SUCCESSFULLY DELETED");
        else
            System.out.println("FAILED TO DELETE");
    }
}
