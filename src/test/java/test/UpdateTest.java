package test;

import lib.BaseTestClass;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.MyResumePage;

public class UpdateTest extends BaseTestClass {

	@Test
	@Parameters({"login", "password"})
	public void updateTest(String login, String password){
		LoginPage loginPage = new LoginPage();
		MainPage mainPage = loginPage.login(login, password);
		MyResumePage myResumePage = mainPage.openMyResumes();
		String oldUpdateDate = myResumePage.getUpdateDate();
		myResumePage.updateResume();
		String newUpdateDate = myResumePage.getUpdateDate();
		Assert.assertNotEquals(oldUpdateDate, newUpdateDate, "Даты обновления до и после должны отличаться");
	}
}
