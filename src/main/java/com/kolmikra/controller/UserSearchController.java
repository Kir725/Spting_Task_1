package com.kolmikra.controller;

import com.kolmikra.entity.User;
import com.kolmikra.model.UserSearchPage;
import com.kolmikra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class UserSearchController {
    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public String userSearch() {
        return "userSearch";
    }

    @PostMapping("/search")
    public String userSearch(@Valid UserSearchPage userSearchPage, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()){
            return "userSearch";
        }
        Optional<User> desiredUser = userService.findUser(
                userSearchPage.getName(), userSearchPage.getSecondName());
        if (!desiredUser.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "User not found!");

            return "redirect:/userSearch";
        }
        redirectAttributes.addFlashAttribute("message","Search Result: \n" + desiredUser.get().toString());

        return "redirect:/userSearch";
    }
}
