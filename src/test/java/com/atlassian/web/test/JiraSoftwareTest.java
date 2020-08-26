package com.atlassian.web.test;

import com.atlassian.web.data.UserData;
import com.atlassian.web.page.BrowserProjectPage;
import com.atlassian.web.page.HomePage;
import com.github.javafaker.Faker;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class JiraSoftwareTest {
    String nameProject = "Ростелеком";
    Faker faker = new Faker(new Locale("ru"));
    String summary = faker.lorem().characters(255);
    String description = faker.lorem().characters(500);

    @BeforeEach
    void setup() {
        open("https://www.atlassian.com/ru/software/jira");
    }

    @Test
    void shouldSuccessfulCreateTask() {
        val user = UserData.oldUser();
        val login = new HomePage().login().authorization(user).openJiraSoftware();
        String number = login.createTask(nameProject, "Баг", summary, description);
        val headerTask = new BrowserProjectPage(nameProject).openProject(nameProject).openIssueList(nameProject).checkCreateTask(number);
        assertEquals(summary, headerTask);
    }

    @Test
    void shouldSuccessfulRegistration() {
        val user = UserData.newUser();
        val registration = new HomePage().login().registrationUser().newUser(user);
    }
}
