package com.atlassian.web.page;

import com.atlassian.web.data.UserData;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    private static final SelenideElement header = $("[class='sc-kkGfuU lajGgq']");
    private static final SelenideElement emailField = $("#email");
    private static final SelenideElement displayNameField = $("#displayName");
    private static final SelenideElement passwordField = $("#password");
    private static final SelenideElement registrationButton = $("#signup-submit");

    public RegistrationPage() {
        header.shouldBe(visible, text("Регистрация аккаунта"));
    }

    public CheckRegistrationPage newUser(UserData.UserInfo user) {
        emailField.setValue(user.getEmail());
        displayNameField.setValue(user.getLastName() + " " + user.getFirstName());
        passwordField.setValue(user.getPassword());
        registrationButton.click();
        return new CheckRegistrationPage();
    }
}
