package com.kolmikra.service;

import com.kolmikra.entity.User;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final String path = new File("").getAbsolutePath() + "\\src\\main\\resources\\files\\UsersData.txt";

    public Optional<User> findUser(String firstName, String secondName){
        Optional<User> desiredUser = Optional.empty();
        List<User> usersList = new ArrayList<>();

        try {
            List<String> usersStringList = Files.readAllLines(Paths.get(path));
            for(String userString: usersStringList){
                String [] userData = userString.split(" ");
                usersList.add(new User(userData[0],
                                        userData[1],
                                        userData[2],
                                        userData[3],
                     Double.parseDouble(userData[4]),
                                        userData[5]
                ));
            }
            for(User user : usersList){
                if(firstName.equals(user.getName()) && secondName.equals(user.getSecondName())){
                    desiredUser = Optional.of(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return desiredUser;
    }
}
