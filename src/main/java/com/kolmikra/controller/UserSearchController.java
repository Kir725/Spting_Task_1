package com.kolmikra.controller;

import com.kolmikra.entity.User;
import com.kolmikra.model.UserSearchPage;
import com.kolmikra.service.UserService;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;
import java.util.TimeZone;

@Controller
public class UserSearchController {
    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public String userSearch() {
        return "userSearch";
    }

    @PostMapping("/search")
    public String userSearch(@Valid UserSearchPage userSearchPage, BindingResult result, HttpServletRequest request,
                             TimeZone timezone, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()){
            return "userSearch";
        }
        Optional<User> desiredUser = userService.findUser(
                userSearchPage.getName(), userSearchPage.getSecondName());
        if (!desiredUser.isPresent()) {
            redirectAttributes.addFlashAttribute("errMessage", "User not found!");

            return "redirect:/userSearch";
        }
        Browser browser = UserAgent.parseUserAgentString(request.getHeader("User-Agent")).getBrowser();
        redirectAttributes.addFlashAttribute("successMessage", desiredUser.get().toString());
        redirectAttributes.addFlashAttribute("browser", browser);
        redirectAttributes.addFlashAttribute("userTime", userService.getUserTime(timezone));
        return "redirect:/userSearch";
    }
}
