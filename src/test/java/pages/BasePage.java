package pages;

import com.codeborne.selenide.Condition;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

abstract class BasePage {

    protected final static Logger LOGGER = Logger.getLogger(BasePage.class);

    BasePage(){
    }

    protected void assertDisplayed(By... args) {
        for(By locator: args){
            $(locator).shouldBe(Condition.appear);
        }
        LOGGER.info("The " + getPageName() + " successfully loaded");
    }

    String getPageName(){
        return this.getClass().getSimpleName();
    }
}
