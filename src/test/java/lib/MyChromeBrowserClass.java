package lib;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class MyChromeBrowserClass implements WebDriverProvider {

    @Override
    public WebDriver createDriver(DesiredCapabilities capabilities) {
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("user-data-dir=./src/test/profiles/chrome/testProfile/");
        chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("disable-popup-blocking", "true");

        chromeOptions.addArguments("disable-infobars");
        //chromeOptions.addArguments("no-sandbox");
        //chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("--disable-gpu");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        chromeOptions.setExperimentalOption("prefs", prefs);

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        return new ChromeDriver(capabilities);
    }


}