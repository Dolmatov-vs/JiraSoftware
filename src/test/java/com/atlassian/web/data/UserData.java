package com.atlassian.web.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class UserData {
    private UserData() {
    }

    @Value
    public static class UserInfo {
        private String email;
        private String password;
        private String firstName;
        private String lastName;
    }

    public static UserInfo oldUser() {
        return new UserInfo("Dolmatov-vs@Yandex.ru", "Qwerty13091988", "Vitalii", "Dolmatov");
    }

    public static UserInfo newUser() {
        return new UserInfo(getEmail(), getPassword(), getFirstName(), getLastName());
    }

    public static String getEmail() {
        Faker faker = new Faker(new Locale("en"));
        return faker.internet().emailAddress();
    }

    public static String getPassword() {
        Faker faker = new Faker(new Locale("en"));
        return faker.internet().password(6, 10);
    }

    public static String getFirstName() {
        Faker faker = new Faker(new Locale("en"));
        return faker.name().firstName();
    }

    public static String getLastName() {
        Faker faker = new Faker(new Locale("en"));
        return faker.name().lastName();
    }
}
