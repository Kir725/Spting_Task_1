package com.kolmikra.controller;

import javax.validation.Valid;

import com.kolmikra.model.EmailPage;
import com.kolmikra.model.MainPage;
import com.kolmikra.model.UserSearchPage;
import com.kolmikra.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class MainPageController {

    @Autowired
    FileService fileService;

    @GetMapping("/")
    public String showForm(MainPage mainPage) {
        return "main_page";
    }

    @PostMapping("/")
    public String saveUser(@Valid MainPage mainPage, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "main_page";
        }
        fileService.saveUser(mainPage);
        return "userSavedResult";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");

            return "redirect:/";
        }

        fileService.addUserFromFile(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded '" + file.getOriginalFilename() + "'");
        return "redirect:/";
    }

    @RequestMapping("/emailPage")
    public String emailRedirect (EmailPage emailPage){
        return "emailPage";
    }

    @RequestMapping("/userSearch")
    public String userSearchRedirect (UserSearchPage userSearchPage){
        return "userSearch";
    }

}