package lib;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Listeners(lib.Listener.class)
public class BaseTestClass {

	protected final static Logger LOG = Logger.getLogger(BaseTestClass.class.getSimpleName());
	protected static Properties properties = new Properties();

	@Parameters({ "startUrl" })
	@BeforeClass
	public static void openUrl(String startUrl){
		configureDriver();
		open(startUrl);
	}

	public static void configureDriver(){
		ChromeDriverManager.getInstance().setup();

		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

		System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tT %4$s %5$s%6$s%n");
		System.setProperty("selenide.browser", "Chrome");

		Configuration.screenshots = false;
		Configuration.reportsFolder = "target/artifacts";

		if(isUnix()){
			configUnix();
		} else if (isWindows()){
			configWindows();
		}
	}

	protected static void configWindows(){
		Configuration.browser = "lib.MyChromeBrowserClass";
		getWebDriver().manage().window().maximize();
	}

	protected static void configUnix(){
		Configuration.browser = "lib.MyChromeBrowserClass";
		getWebDriver().manage().window().setSize(new Dimension(1920, 1080));
	}

	protected static boolean isWindows() {
		String os = System.getProperty("os.name").toLowerCase();
		// windows
		return (os.contains("win"));
	}

	protected static boolean isUnix() {
		String os = System.getProperty("os.name").toLowerCase();
		// linux or unix
		return (os.contains("nix") || os.contains("nux"));
	}

}
