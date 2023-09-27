package utility;


import applicationConnection.JdbcConnection;
import repository.*;
import service.*;

import java.sql.Connection;
@SuppressWarnings("unused")
public class ApplicationContext {
    private static final Connection CONNECTION;
    private static final BrandRepository BRAND_REPOSITORY;
    private static final CategoryRepository CATEGORY_REPOSITORY;
    private static final ProductRepository PRODUCT_REPOSITORY;
    private static final ShareholderRepository SHAREHOLDER_REPOSITORY;
    private static final UsersRepository USERS_REPOSITORY;
    private static final Shareholder_BrandRepository SHAREHOLDER_BRAND_REPOSITORY;
    private static final BrandService BRAND_SERVICE;
    private static final CategoryService CATEGORY_SERVICE;
    private static final ProductService PRODUCT_SERVICE;
    private static final ShareholderService SHAREHOLDER_SERVICE;
    private static final UsersService USERS_SERVICE;
    private static final Shareholder_BrandService SHAREHOLDER_BRAND_SERVICE;


    static {
        CONNECTION = JdbcConnection.getConnection();
        BRAND_REPOSITORY = new BrandRepository(CONNECTION);
        CATEGORY_REPOSITORY = new CategoryRepository(CONNECTION);
        PRODUCT_REPOSITORY = new ProductRepository(CONNECTION);
        SHAREHOLDER_REPOSITORY = new ShareholderRepository(CONNECTION);
        USERS_REPOSITORY = new UsersRepository(CONNECTION);
        SHAREHOLDER_BRAND_REPOSITORY = new Shareholder_BrandRepository(CONNECTION);
        BRAND_SERVICE = new BrandService(BRAND_REPOSITORY);
        CATEGORY_SERVICE = new CategoryService(CATEGORY_REPOSITORY);
        PRODUCT_SERVICE = new ProductService(PRODUCT_REPOSITORY);
        SHAREHOLDER_SERVICE = new ShareholderService(SHAREHOLDER_REPOSITORY);
        USERS_SERVICE = new UsersService(USERS_REPOSITORY);
        SHAREHOLDER_BRAND_SERVICE = new Shareholder_BrandService(SHAREHOLDER_BRAND_REPOSITORY);
    }

    public static BrandService getBrandService(){
        return BRAND_SERVICE;
    }

    public static CategoryService getCategoryService(){
        return CATEGORY_SERVICE;
    }

    public static ProductService getProductService(){
        return PRODUCT_SERVICE ;
    }

    public static ShareholderService getShareholderService(){
        return SHAREHOLDER_SERVICE;
    }

    public  static UsersService getUsersService(){
        return USERS_SERVICE;
    }

    public static Shareholder_BrandService getShareholderBrandService(){
        return SHAREHOLDER_BRAND_SERVICE;
    }
}