package com.atlassian.web.page;

import com.atlassian.web.data.UserData;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private static final SelenideElement header = $("[class='sc-kkGfuU lajGgq']");
    private static final SelenideElement userNameField = $("#username");
    private static final SelenideElement loginSubmitButton = $("#login-submit");
    private static final SelenideElement passwordField = $("#password");
    private static final SelenideElement registrationAccountButton = $("[class='primary-action']");

    public LoginPage() {
        header.shouldBe(visible, text("Войдите в свой аккаунт"));
    }

    public HomeContentPage authorization(UserData.UserInfo user) {
        userNameField.setValue(user.getEmail());
        loginSubmitButton.click();
        passwordField.setValue(user.getPassword());
        loginSubmitButton.click();
        return new HomeContentPage(user);
    }

    public RegistrationPage registrationUser() {
        registrationAccountButton.click();
        return new RegistrationPage();
    }

}
