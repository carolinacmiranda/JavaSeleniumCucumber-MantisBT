package com.example.stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.example.pages.LoginPage;
import io.cucumber.java.en.Given;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage();

    @Given("that I am logged in")
public void that_I_am_logged_in() {
    Properties props = new Properties();
    try {
        FileInputStream input = new FileInputStream("config.properties");
        props.load(input);
    } catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException("Failed to load configuration file.");
    }

    String username = props.getProperty("app.username");
    String password = props.getProperty("app.password");

    if (username == null || password == null) {
        throw new RuntimeException("Username or password is not set in the configuration file");
    }

    loginPage.login(username, password);
    loginPage.checkTitleAfterLogin();
    }
}
