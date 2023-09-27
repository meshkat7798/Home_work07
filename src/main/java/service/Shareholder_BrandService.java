package service;

import entity.Shareholder_Brand;
import repository.Shareholder_BrandRepository;

import java.sql.SQLException;
import java.util.Scanner;
@SuppressWarnings("unused")
public class Shareholder_BrandService {

        private final Shareholder_BrandRepository shareholder_brandRepository;
        Scanner scanner = new Scanner(System.in);

        public Shareholder_BrandService(Shareholder_BrandRepository shareholder_brandRepository) {
            this.shareholder_brandRepository = shareholder_brandRepository;
        }

        public void save(Shareholder_Brand shareholder_brand) throws SQLException {
            int result = shareholder_brandRepository.save( shareholder_brand);
            if (result != 0)
                System.out.println(" SUCCESSFULLY ADDED");
            else
                System.out.println("INVALID DATA");
        }

        public void delete(int shareholderId, int brandId) throws SQLException {
            int result = shareholder_brandRepository.delete( shareholderId,brandId);
            if (result != 0)
                System.out.println("SUCCESSFULLY DELETED");
            else
                System.out.println("FAILED TO DELETE");
        }

        public Shareholder_Brand[] showAll() throws SQLException {
            return shareholder_brandRepository.loadAll();
        }
    }

