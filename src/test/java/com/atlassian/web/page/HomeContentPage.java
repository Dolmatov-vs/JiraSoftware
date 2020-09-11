package com.atlassian.web.page;

import com.atlassian.web.data.UserData;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.*;

public class HomeContentPage {
    private static final SelenideElement jiraSoftware = $("[class='sc-bxivhb gwPQeF']");

    public HomeContentPage(UserData.UserInfo user) {
        jiraSoftware.waitUntil(visible, 30000).shouldBe(text(user.getLastName()));
    }

    public JiraSoftwarePage openJiraSoftware() {
        jiraSoftware.click();
        return new JiraSoftwarePage();
    }
}
