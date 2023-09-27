package service;

import entity.Category;
import repository.CategoryRepository;

import java.sql.SQLException;
import java.util.Scanner;

@SuppressWarnings("unused")

public class CategoryService {
    private final CategoryRepository categoryRepository;
    Scanner scanner = new Scanner(System.in);

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void save(Category category) throws SQLException {
        int result = categoryRepository.save(category);
        if (result != 0)
            System.out.println("CATEGORY SUCCESSFULLY ADDED");
        else
            System.out.println("INVALID DATA");
    }

    public void edit(int id) throws SQLException {
        System.out.println("PLEASE ENTER YOUR NEW CATEGORY NAME :");
        String categoryName = scanner.nextLine();
        System.out.println("PLEASE ENTER YOUR NEW CATEGORY DESCRIPTION :");
        String categoryDescription = scanner.nextLine();
        int result = categoryRepository.edit(id, categoryName, categoryDescription);
        if (result != 0) {
            System.out.println("SUCCESSFULLY UPDATED");
        } else
            System.out.println("FAILED TO EDIT");
    }

    public void delete(int id) throws SQLException {
        int result = categoryRepository.delete(id);
        if (result != 0)
            System.out.println("SUCCESSFULLY DELETED");
        else
            System.out.println("FAILED TO DELETE");
    }
    public Category select(int id) throws SQLException {
        return  categoryRepository.load(id);
    }
    public Category[] showAll() throws SQLException {
        return categoryRepository.loadAll();
    }
}
