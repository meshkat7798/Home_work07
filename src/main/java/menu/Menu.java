package menu;

import entity.*;
import service.*;
import utility.ApplicationContext;
import utility.Validation;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
    private final Scanner input = new Scanner(System.in);
    private final UsersService userService = ApplicationContext.getUsersService();
    BrandService brandService = ApplicationContext.getBrandService();
    CategoryService categoryService = ApplicationContext.getCategoryService();
    ShareholderService shareholderService = ApplicationContext.getShareholderService();
    ProductService productService = ApplicationContext.getProductService();
    Shareholder_BrandService shareholder_brandService = ApplicationContext.getShareholderBrandService();

    public Menu() {
    }

    public void mainMenu() throws SQLException {
        System.out.println("***WELCOME***");
        System.out.println("1- SIGN IN");
        System.out.println("2- SIGN UP");
        System.out.println("3- EXIT");
        System.out.println("INSERT A NUMBER:");
        int select = input.nextInt();
        switch (select) {
            case 1 -> enter();
            case 2 -> register();
            case 3 -> System.out.println("EXIT");
            default-> System.out.println("INVALID INPUT !");
        }
    }


    //   ENTER CASE IN MAIN MENO
    public void enter() throws SQLException {
        System.out.println("Enter your username:");
        String username = input.next();
        input.nextLine();
        System.out.println("Enter your password:");
        String password = input.next();
        Users user = userService.login(username);
        if (user == null && !user.getPassword().equals(password))
            System.out.println(" INCORRECT USERNAME OR PASSWORD !!");
        else {
            boolean isTrue = true;
            while (isTrue) {
                System.out.println("=====================================");
                System.out.println("1- Brands");
                System.out.println("2-Categories");
                System.out.println("3-Products");
                System.out.println("4-Shareholders");
                System.out.println("5-Shareholder & Brands");
                System.out.println("6- Exit");
                int number = input.nextInt();
                input.nextLine();
                switch (number) {
                    case 1 -> brandMenu();
                    case 2 -> categoryMenu();
                    case 3 -> productMenu();
                    case 4 -> shareholderMenu();
                    case 5 -> shareholder_brandMenu();
                    case 6 -> isTrue = false;
                    default-> System.out.println("INVALID INPUT !!");
                }
            }
        }

    }

    public void register() throws SQLException {
        System.out.println("Enter your name:");
        String name = input.next();
        input.nextLine();
        System.out.println("Enter your username:");
        String username = input.next();
        input.nextLine();
        System.out.println("Enter your Email:");
        String email = null;
        boolean validemail = true;
        while (validemail) {
            email = input.next();
            if (Validation.isValidEmail(email))
                validemail = false;
            else
                System.out.println("PLEASE ENTER A VALID EMAIL");
        }
        System.out.println("Enter your password:");
        String password = null;
        boolean validPassword = true;
        while (validPassword) {
            password = input.next();
            if (Validation.isValidPassword(password))
                validPassword = false;
            else
                System.out.println("PLEASE ENTER A VALID PASSWORD");
        }

        Users user = new Users(name, username, email, password);
        userService.register(user);
    }



    public void brandMenu() throws SQLException {
        System.out.println("=====================================");
        System.out.println("1- Add Brand");
        System.out.println("2-Edit  Brand");
        System.out.println("3-Delete Brand");
        System.out.println("Please choose the operation:");
        int number = input.nextInt();
        input.nextLine();
        if (number == 1) {
            System.out.println("Please Enter Brand Name:");
            String name = input.next();
            System.out.println("Please Enter Brand Website");
            String website = null;
            boolean validWeb = true;
            while (validWeb) {
                website = input.next();
                if (Validation.isValidWebsite(website))
                    validWeb = false;
                else
                    System.out.println("PLEASE ENTER A VALID WEBSITE");
            }
            System.out.println("Please Enter Brand Description");
            String description = input.next();
            input.nextLine();
            Brand brand = new Brand(name, website, description);
            brandService.save(brand);
        } else if (number == 2) {
            System.out.println("Please Enter Brand ID:");
            int id = input.nextInt();
//            check
            input.nextLine();
            brandService.edit(id);
        } else if (number == 3) {
            System.out.println("Please Enter Brand ID:");
            int id = input.nextInt();
            input.nextLine();
            brandService.delete(id);
        } else {
            System.out.println("INVALID INPUT!!");
        }
    }

    public void categoryMenu() throws SQLException {
        System.out.println("=====================================");
        System.out.println("1-Add Category");
        System.out.println("2-Edit  Category");
        System.out.println("3-Delete Category");
        System.out.println("Please choose the operation:");
        int number = input.nextInt();
        input.nextLine();
        if (number == 1) {
            System.out.println("Please Enter Category Name:");
            String name = input.next();
            input.nextLine();
            System.out.println("Please Enter Category Description");
            String description = input.next();
            input.nextLine();
            Category category = new Category(name, description);
            categoryService.save(category);
        } else if (number == 2) {
            System.out.println("Please Enter Category ID:");
            int id = input.nextInt();
            input.nextLine();
            categoryService.edit(id);
        } else if (number == 3) {
            System.out.println("Please Enter Category ID:");
            int id = input.nextInt();
            input.nextLine();
            categoryService.delete(id);
        } else {
            System.out.println("INVALID INPUT!!");
        }
    }

    public void productMenu() throws SQLException {
        System.out.println("=====================================");
        System.out.println("1- Add Product");
        System.out.println("2-Edit  Product");
        System.out.println("3-Delete Product");
        System.out.println("Please choose the operation:");
        int number = input.nextInt();
        input.nextLine();
        if (number == 1) {
            Brand[] brands = brandService.showAll();
            if (brands.length == 0) {
                System.out.println("You have to Add a Brand First!!");
            } else {
                for (int i = 0; i < brands.length; i++) {
                    System.out.println(brands[i]);
                }
                System.out.println("Please choose a Brand By id:");
                int brandId = input.nextInt();
                input.nextLine();
                Brand brand = brandService.select(brandId);

                Category[] categories = categoryService.showAll();
                if (categories.length == 0) {
                    System.out.println("You have to Add a Category First!!");
                } else {
                    for (int i = 0; i < categories.length; i++) {
                        System.out.println(categories[i]);
                    }
                    System.out.println("Please choose a Category By id:");
                    int categoryId = input.nextInt();
                    input.nextLine();
                    Category category = categoryService.select(categoryId);

                    System.out.println("Please enter your Product Name:");
                    String name = input.next();
                    input.nextLine();
                    System.out.println("Please enter create date:");
                    String date = input.next();
                    input.nextLine();
                    Product product = new Product(name, date, category, brand);
                    productService.save(product);
                }
            }
        } else if (number == 2) {
            System.out.println("Please Enter Product ID:");
            int id = input.nextInt();
            input.nextLine();
            productService.edit(id);
        } else if (number == 3) {
            System.out.println("Please Enter Product ID:");
            int id = input.nextInt();
            input.nextLine();
            productService.delete(id);
        } else {
            System.out.println("INVALID INPUT!!");
        }
    }

    public void shareholderMenu() throws SQLException {
        System.out.println("=====================================");
        System.out.println("1- Add Shareholder");
        System.out.println("2-Edit  Shareholder");
        System.out.println("3-Delete Shareholder");
        System.out.println("Please choose the operation:");
        int number = input.nextInt();
        input.nextLine();
        if (number == 1) {
            System.out.println("Please Enter Shareholder Name:");
            String name = input.next();
            input.nextLine();
            System.out.println("Please Enter Shareholder Phone Number");
            String phone = null;
            boolean validPhone = true;
            while (validPhone) {
                phone = input.next();
                if (Validation.isValidPhoneNumber(phone))
                    validPhone = false;
                else
                    System.out.println("please Enter a valid Phone Number");
            }
            System.out.println("Please Enter Shareholder  Nationality Code:");
            String nationalCode = null;
            boolean validNational = true;
            while (validNational) {
                nationalCode = input.next();
                if (Validation.isValidNationalityCode(nationalCode))
                    validNational = false;
                else
                    System.out.println("please Enter a valid Nationality Code ");
            }
            Shareholder shareholder = new Shareholder(name, phone, nationalCode);
            shareholderService.save(shareholder);

        } else if (number == 2) {
            System.out.println("Please Enter Shareholder ID:");
            int id = input.nextInt();
            input.nextLine();
            shareholderService.edit(id);
        } else if (number == 3) {
            System.out.println("Please Enter Shareholder ID:");
            int id = input.nextInt();
            input.nextLine();
            shareholderService.delete(id);
        } else {
            System.out.println("INVALID INPUT!!");
        }
    }
    public void shareholder_brandMenu() throws SQLException{
        System.out.println("=====================================");
        System.out.println("1- Add New Relation");
        System.out.println("2- Delete  A Relation");
        System.out.println("3- Show All Relations ");
        System.out.println("Please choose the operation:");
        int number = input.nextInt();
        input.nextLine();
        if (number == 1) {
            System.out.println("Please Enter Shareholder Id:");
            int shareholderId = input.nextInt();
            input.nextLine();
            System.out.println("Please Enter Brand Id: ");
            int brandId = input.nextInt();
            input.nextLine();
            Shareholder_Brand shareholder_brand = new Shareholder_Brand(shareholderId,brandId);
            shareholder_brandService.save(shareholder_brand);
        }
        else if (number == 2) {
            System.out.println("Please Enter Shareholder ID:");
            int shareholderId = input.nextInt();
            input.nextLine();
            System.out.println("Please Enter Brand Id: ");
            int brandId = input.nextInt();
            input.nextLine();
            shareholder_brandService.delete(shareholderId,brandId);
        }else if (number == 3) {
            Shareholder_Brand[] shareholder_brands = shareholder_brandService.showAll();
            for (int i = 0; i < shareholder_brands.length; i++) {
                System.out.println(shareholder_brands[i]);
            }
        }

    }}