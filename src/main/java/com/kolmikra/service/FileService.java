package com.kolmikra.service;

import com.kolmikra.model.MainPage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


@Service
public class FileService {
    private final String path = new File("").getAbsolutePath() + "\\src\\main\\resources\\files\\UsersData.txt";
    //Resource resource = new ClassPathResource("/files/UsersData.txt");

    public void saveUser(MainPage mainPage) {
        try (FileWriter writer = new FileWriter(path, true)) {
            StringBuilder sb = new StringBuilder();
                    sb.append(mainPage.getName())
                    .append(" ")
                    .append(mainPage.getSecondName())
                    .append(" ")
                    .append(mainPage.getMiddleName())
                    .append(" ")
                    .append(mainPage.getEmail())
                    .append(" ")
                    .append(mainPage.getSalary())
                    .append(" ")
                    .append(mainPage.getJob());
            System.out.println(sb);
            writer.write("\n");
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addUserFromFile(MultipartFile file){
        try(FileWriter writer = new FileWriter(path, true)) {
            writer.write("\n");
            writer.write(new String(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
