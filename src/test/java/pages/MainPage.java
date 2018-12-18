package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

public class MainPage extends BasePage {

    private SelenideElement resumeMenu = $("div[data-qa='mainmenu_resumes']");
    private SelenideElement myResume = $(byText("Мои резюме"));

    @Step
    public MyResumePage openMyResumes() {
        resumeMenu.hover();
        myResume.click();
        myResume.should(Condition.disappear);
        return new MyResumePage();
    }

}
