import entity.*;
import menu.Menu;
import service.*;
import utility.ApplicationContext;

import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws SQLException {

        Menu menu = new Menu();
        menu.mainMenu();

    }
}