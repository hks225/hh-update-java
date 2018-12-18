package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage extends BasePage {

    private final By loginForm = By.cssSelector("[class=Bloko-Tabs-Body]");
    private SelenideElement loginInput = $("label.login-input input.bloko-input[name='username']");
    private SelenideElement passwordInput = $("label.login-input input.bloko-input[name='password']");
    private SelenideElement loginBtn = $("input[value='Войти']");

    @Step
    public MainPage login(String login, String password) {
        loginInput.setValue(login);
        passwordInput.setValue(password);
        loginBtn.click();
        loginBtn.should(Condition.disappear);
        return new MainPage();
    }
}
