package com.atlassian.web.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BrowserProjectPage {
    private ElementsCollection projectList = $$("[class='sc-clBsIJ huNkAi']");
    private SelenideElement projectBoard = $("[class='sc-iGPElx gIKjkS']");

    public BrowserProjectPage(String projectName) {
        projectBoard.waitUntil(visible, 30000);
    }

    public RapidBoardPage openProject(String projectName) {
        projectList.findBy(text(projectName)).waitUntil(visible, 30000).click();
        return new RapidBoardPage(projectName);
    }
}
