package com.atlassian.web.page;

import com.atlassian.web.data.UserData;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement header = $("[class='sc-kkGfuU lajGgq']");
    private SelenideElement userNameField = $("#username");
    private SelenideElement loginSubmitButton = $("#login-submit");
    private SelenideElement passwordField = $("#password");
    private SelenideElement registrationAccountButton = $("[class='primary-action']");

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
