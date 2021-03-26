package com.bta.casino.casinodemo.controller;

import com.bta.casino.casinodemo.model.UserAccount;
import com.bta.casino.casinodemo.repository.UserAccountRepository;
import com.bta.casino.casinodemo.service.UserAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @GetMapping("/registration")
    public String getRegistrationView() {
        return "user/registration";
    }

    @PostMapping("/registration")
    public ResponseEntity<UserAccount> registrationUser(
            @ModelAttribute UserAccount userAccount) {
        UserAccount createdUserAccount = userAccountService.registration(userAccount);
        return new ResponseEntity<>(createdUserAccount, HttpStatus.OK);
    }

    @GetMapping("/profile")
    public ModelAndView getAllBetView(){
        final Map<String, Object> model = new HashMap<>();
        model.put("profiles", userAccountRepository.findAllByUsername(getCurrentUserUsername()));

        return new ModelAndView("user/profile", model) ;
    }

    private String getCurrentUserUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            return userDetails.getUsername();
        }
        throw new RuntimeException("Issue with Spring Security Configuration. Principal has wrong type!");
    }
}
