package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MyResumePage {

    private SelenideElement updateResumeButton = $("div[data-qa='resume '] div.resumelist__update-info span.bloko-icon-dynamic");
    private SelenideElement updateDateLabel = $("div[data-qa='resume '] div.resumelist__update-info span");

    @Step
    public MyResumePage updateResume() {
        updateResumeButton.click();
        //updateResumeButton.shouldBe(Condition.disabled);
        Selenide.sleep(1000);
        return this;
    }

    public String getUpdateDate() {
        return updateDateLabel.getText();
    }

}
