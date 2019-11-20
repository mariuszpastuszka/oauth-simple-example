package com.example.demooauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
//TODO 3 adnotacja dla włączenia SSO
@EnableOAuth2Sso
@RestController
public class DemoOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoOauthApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Secured hello";
    }

    //TODO 4 przekierowanie z "/" na  "/hello" - użyj ModelAndView
    @GetMapping("/")
    public ModelAndView redirectToHello(ModelMap model) {
        return new ModelAndView("redirect:/hello", model);
    }
}

