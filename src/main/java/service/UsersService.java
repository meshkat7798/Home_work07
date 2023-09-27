package service;

import entity.Users;
import repository.UsersRepository;

import java.sql.SQLException;
@SuppressWarnings("unused")

public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }


    public void register(Users user) throws SQLException {
        int result = usersRepository.singUp(user);
        if(result != 0)
            System.out.println(user.getName() + " IS SUCCESSFULLY REGISTERED");
        else
            System.out.println("INVALID DATA");
    }


    public Users login(String username) throws SQLException {
        return usersRepository.singIn(username);
    }
}
