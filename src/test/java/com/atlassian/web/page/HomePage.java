package com.atlassian.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    private static final SelenideElement loginButton = $("#gray_link");

    public LoginPage login() {
        loginButton.click();
        return new LoginPage();
    }
}
