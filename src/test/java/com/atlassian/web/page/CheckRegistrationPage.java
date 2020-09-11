package com.atlassian.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CheckRegistrationPage {
    private static final SelenideElement header = $("[class='sc-kkGfuU lajGgq']");

    public CheckRegistrationPage(){
        header.shouldBe(text("Проверьте входящую почту, чтобы завершить регистрацию"));
    }
}
