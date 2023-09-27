package service;

import entity.Shareholder;
import repository.ShareholderRepository;

import java.sql.SQLException;
import java.util.Scanner;

@SuppressWarnings("unused")

public class ShareholderService {
    private final ShareholderRepository shareholderRepository;
    Scanner scanner = new Scanner(System.in);

    public ShareholderService(ShareholderRepository shareholderRepository) {
        this.shareholderRepository = shareholderRepository;
    }

    public void save(Shareholder shareholder) throws SQLException {
        int result = shareholderRepository.save(shareholder);
        if (result != 0)
            System.out.println("SHAREHOLDER SUCCESSFULLY ADDED");
        else
            System.out.println("INVALID DATA");
    }

    public void edit(int id) throws SQLException {
        System.out.println("PLEASE ENTER YOUR NEW NAME :");
        String shareholderName = scanner.nextLine();
        System.out.println("PLEASE ENTER YOUR NEW PHONE NUMBER :");
        String phoneNumber = scanner.nextLine();
        System.out.println("PLEASE ENTER YOUR NEW NATIONAL CODE :");
        String nationalCode = scanner.nextLine();
        int result = shareholderRepository.edit(id, shareholderName, phoneNumber, nationalCode);
        if (result != 0) {
            System.out.println("SUCCESSFULLY UPDATED");
        } else
            System.out.println("FAILED TO EDIT");
    }

    public void delete(int id) throws SQLException {
        int result = shareholderRepository.delete(id);
        if (result != 0)
            System.out.println("SUCCESSFULLY DELETED");
        else
            System.out.println("FAILED TO DELETE");
    }
}
