package com.kolmikra.service;

import com.kolmikra.model.MainPage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


@Service
public class FileService {
    @Value("classpath:/files/UsersData.txt")
    Resource resource;

    public void saveUser(MainPage mainPage) {

        try (FileWriter writer = new FileWriter(resource.getFile(), true)) {
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
        try(FileWriter writer = new FileWriter(resource.getFile(), true)) {
            writer.write("\n");
            writer.write(new String(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
