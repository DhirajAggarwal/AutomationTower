package testtower;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {

	WebDriver driver;

	@BeforeClass
	public void setup() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
	}

	@Test
	public void test1_Landing() throws InterruptedException {

		WebElement Landing_Login_link = driver.findElement(By
				.id("com.tower.smartdriver:id/welcome_login"));

		Landing_Login_link.click();
	}

	@Test
	public void test2_Login() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("android:id/action_bar_title")));

		WebElement Login_email_textbox = driver.findElement(By
				.id("com.tower.smartdriver:id/email_field"));

		WebElement Login_password_textbox = driver.findElement(By
				.id("com.tower.smartdriver:id/password_field"));

		Login_email_textbox.sendKeys("Nexus@tower.com");
		Login_password_textbox.sendKeys("Test@1234");
		driver.navigate().back();

		WebElement Login_Submit_button = driver.findElement(By
				.id("com.tower.smartdriver:id/submit_btn"));
		Login_Submit_button.click();
	}

	@Test
	public void test3_NavigateToMenu() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("android:id/alertTitle")));

		WebElement Continue_button = driver.findElement(By
				.id("android:id/button1"));
		Continue_button.click();

		WebElement Navigation_button = driver.findElement(By
				.id("android:id/up"));
		Navigation_button.click();

	}

	@Test
	public void test5_NavigateToHome() throws InterruptedException {

		List<WebElement> Navigation_Menu = driver.findElements(By
				.id("com.tower.smartdriver:id/navigation_item_name"));
		Navigation_Menu.get(5).click();

		WebElement AutoStart_Toggle = driver.findElement(By
				.id("com.tower.smartdriver:id/toggle_button1"));
		AutoStart_Toggle.click();

		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("android:id/message")));

		WebElement AutoStart_Toggle_Success_Dialog = driver.findElement(By
				.id("android:id/button1"));
		AutoStart_Toggle_Success_Dialog.click();

		WebElement Navigation_button = driver.findElement(By
				.id("android:id/up"));
		Navigation_button.click();

		// List<WebElement> Navigation_Menu = driver.findElements(By
		// .id("com.tower.smartdriver:id/navigation_item_name"));
		Navigation_Menu.get(0).click();

		// WebDriverWait wait = new WebDriverWait(driver, 180);
		WebElement Start_buttton = driver.findElement(By
				.id("com.tower.smartdriver:id/start_trip_btn"));
		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("com.tower.smartdriver:id/start_trip_btn")));

		Start_buttton.click();
		

		wait.until(ExpectedConditions.textToBePresentInElement(
				driver.findElement(By
						.id("com.tower.smartdriver:id/log_trip_distance_display")),
				"2.2"));

		WebElement Stop = driver.findElement(By
				.id("com.tower.smartdriver:id/stop_trip_btn_anim"));
		Stop.click();

		wait.until(ExpectedConditions.elementToBeClickable(By
				.id("com.tower.smartdriver:id/distance_driven_label")));
		driver.navigate().back();
	}

	/*
	 * @Test public void test6_NavigateToTripHistory() throws
	 * InterruptedException {
	 * 
	 * //driver.navigate().back(); WebElement Navigation_button =
	 * driver.findElement(By .id("android:id/up")); Navigation_button.click();
	 * 
	 * List<WebElement> Navigation_Menu = driver.findElements(By
	 * .id("com.tower.smartdriver:id/navigation_item_name"));
	 * Navigation_Menu.get(1).click();
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, 90);
	 * wait.until(ExpectedConditions.elementToBeClickable(By
	 * .id("android:id/list")));
	 * 
	 * List<WebElement> Trip_History_Detail = driver.findElements(By
	 * .className("android.widget.LinearLayout"));
	 * Trip_History_Detail.get(4).click(); driver.navigate().back();
	 * driver.navigate().back();
	 * 
	 * }
	 */
	/*
	 * @Test public void test7_NavigateToLeaderBoars() throws
	 * InterruptedException {
	 * 
	 * }
	 * 
	 * @Test public void test8_NavigateToAchievements() throws
	 * InterruptedException {
	 * 
	 * }
	 * 
	 * @Test public void test9_NavigateToAccounts() throws InterruptedException
	 * {
	 * 
	 * }
	 * 
	 * @Test public void test10_NavigateToSettings() throws InterruptedException
	 * {
	 * 
	 * List<WebElement> Navigation_Menu = driver.findElements(By
	 * .id("com.tower.smartdriver:id/navigation_item_name"));
	 * Navigation_Menu.get(5).click();
	 * 
	 * WebElement AutoStart_Toggle = driver.findElement(By
	 * .id("com.tower.smartdriver:id/toggle_button1"));
	 * AutoStart_Toggle.click();
	 * 
	 * WebDriverWait wait = new WebDriverWait(driver, 90);
	 * wait.until(ExpectedConditions.elementToBeClickable(By
	 * .id("android:id/message")));
	 * 
	 * WebElement AutoStart_Toggle_Success_Dialog = driver.findElement(By
	 * .id("android:id/button1")); AutoStart_Toggle_Success_Dialog.click();
	 * 
	 * }
	 * 
	 * @Test public void test11_NavigateToStartAgain() throws
	 * InterruptedException {
	 * 
	 * }
	 * 
	 * @Test public void test12_NavigateToHelp() throws InterruptedException {
	 * 
	 * }
	 * 
	 * @Test public void test13_Logout() throws InterruptedException {
	 * 
	 * }
	 */
	@AfterClass
	public void afterClass() {
	}

}
