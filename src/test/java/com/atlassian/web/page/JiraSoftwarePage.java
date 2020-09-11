package com.atlassian.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.chord;

public class JiraSoftwarePage {

    String selectAll = chord(Keys.CONTROL, "a");
    Keys del = Keys.DELETE;

    private static final SelenideElement mainActionsPanel = $("[data-testid='atlassian-navigation--primary-actions']");
    private static final SelenideElement createTaskButton = $("#createGlobalItem");

    private static final SelenideElement projectField = $("#project-field");
    private static final SelenideElement issueTypeField = $("#issuetype-field");
    private static final SelenideElement summaryField = $("#summary");
    private static final SelenideElement descriptionField = $("#description");
    private static final SelenideElement createButton = $("#create-issue-submit");
    private static final SelenideElement numberTask = $("[class='issue-created-key issue-link']");

    public JiraSoftwarePage() {
        mainActionsPanel.waitUntil(Condition.visible, 30000);
    }

    public String createTask(String projectName, String issueType, String summary, String description) {
        createTaskButton.click();
        projectField.sendKeys(selectAll, del);
        projectField.setValue(projectName).sendKeys(Keys.ENTER);
        issueTypeField.sendKeys(selectAll, del);
        issueTypeField.setValue(issueType).sendKeys(Keys.ENTER);
        summaryField.setValue(summary);
        descriptionField.setValue(description);
        createButton.click();
        String taskNumber = numberTask.getAttribute("href");
        String[] array = taskNumber.split("/");
        return array[array.length - 1];
    }

}
