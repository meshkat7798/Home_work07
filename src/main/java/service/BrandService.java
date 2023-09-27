package service;

import entity.Brand;
import repository.BrandRepository;

import java.sql.SQLException;
import java.util.Scanner;

@SuppressWarnings("unused")
public class BrandService {
    private  final BrandRepository brandRepository;
    Scanner scanner = new Scanner(System.in);

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public void save(Brand brand) throws SQLException {
        int result = brandRepository.save(brand);
        if (result != 0)
            System.out.println("BRAND SUCCESSFULLY ADDED");
        else
            System.out.println("INVALID DATA");
    }

    public void edit(int id) throws SQLException {
        System.out.println("PLEASE ENTER YOUR NEW BRAND NAME :");
        String brandName = scanner.nextLine();
        System.out.println("PLEASE ENTER YOUR NEW BRAND WEBSITE :");
        String brandWebsite = scanner.nextLine();
        System.out.println("PLEASE ENTER YOUR NEW BRAND DESCRIPTION :");
        String brandDescription = scanner.nextLine();
        int result = brandRepository.edit(id, brandName, brandWebsite, brandDescription);
        if (result != 0) {
            System.out.println("SUCCESSFULLY UPDATED");
        } else
            System.out.println("FAILED TO EDIT");
    }

    public void delete(int id) throws SQLException {
        int result = brandRepository.delete(id);
        if (result != 0)
            System.out.println("SUCCESSFULLY DELETED");
        else
            System.out.println("FAILED TO DELETE");
    }
    public  Brand select(int id) throws SQLException {
        return  brandRepository.load(id);
    }
    public  Brand select(String name ) throws SQLException {
        return  brandRepository.load(name);
    }

    public Brand[] showAll() throws SQLException {
     return    brandRepository.loadAll();

    }
}