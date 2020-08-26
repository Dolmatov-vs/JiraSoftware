package com.atlassian.web.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class IssueListPage {

    private SelenideElement projectNameHeader = $("[class='css-1xaaz5m']");
    private SelenideElement filters = $("[class='css-jz5571']");
    private ElementsCollection numberTaskList = $$("[class='sc-cEvuZC imPFTR']");
    private SelenideElement taskHeader = $("[data-test-id='issue.views.issue-base.foundation.summary.heading']");

    public IssueListPage(String projectName) {
        projectNameHeader.waitUntil(visible, 30000).shouldBe(text(projectName));
        filters.shouldBe(text("Фильтры"));
    }

    public String checkCreateTask(String numberTask) {
        numberTaskList.findBy(text(numberTask)).waitUntil(visible, 30000).click();
        String taskHeaderValue = taskHeader.getText();
        return taskHeaderValue;

    }

}
