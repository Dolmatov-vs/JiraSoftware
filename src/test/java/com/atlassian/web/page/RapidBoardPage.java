package com.atlassian.web.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class RapidBoardPage {

    private ElementsCollection navigationList = $$("[class='css-1olrtn']");
    private SelenideElement projectNameHeader = $("[class='css-1xaaz5m']");

    public RapidBoardPage(String projectName) {
        projectNameHeader.waitUntil(visible, 30000).shouldBe(text(projectName));
    }

    public IssueListPage openIssueList(String projectName) {
        navigationList.findBy(text("Задачи")).waitUntil(visible, 30000).click();
        return new IssueListPage(projectName);
    }

}
