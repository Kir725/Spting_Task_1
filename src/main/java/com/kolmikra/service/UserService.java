package com.kolmikra.service;

import com.kolmikra.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@Service
public class UserService {
    @Value("classpath:/files/UsersData.txt")
    Resource resource;

    public Optional<User> findUser(String firstName, String secondName){
        Optional<User> desiredUser = Optional.empty();
        List<User> usersList = new ArrayList<>();

        try {
            List<String> usersStringList = Files.readAllLines(Paths.get(resource.getURI()));
            usersStringList.forEach(str -> {
                usersList.add(new User(str));
            });
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

    public String getUserTime(TimeZone timeZone){
        LocalDateTime today = LocalDateTime.now();
        ZoneId id = ZoneId.of(timeZone.getID());
        ZonedDateTime zonedDateTime = ZonedDateTime.of(today, id);

        return DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm")
                .format(zonedDateTime);
    }
}
