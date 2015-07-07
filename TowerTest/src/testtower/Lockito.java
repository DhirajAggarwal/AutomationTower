package testtower;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Lockito {

	AndroidDriver driver;

	@BeforeClass
	public void setup() throws MalformedURLException {

		DesiredCapabilities capabilities1 = new DesiredCapabilities();
		/*
		 * capabilities .setCapability( "app",
		 * "C:\\Users\\dhiraj01\\Downloads\\apk-downloader\\fr.dvilleneuve.lockito-2005004.apk"
		 * );
		 */
		capabilities1.setCapability("appPackage", "fr.dvilleneuve.lockito");
		capabilities1.setCapability("appActivity", ".ui.SplashscreenActivity_");
		capabilities1.setCapability("deviceName", "0cbbdc0a032f9efa");
		capabilities1.setCapability("platformName", "Android");
		capabilities1.setCapability("appWaitActivity",
				".ui.ItinerariesActivity_");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities1);

		List<WebElement> Trip_Selection = driver.findElements(By
				.className("android.widget.RelativeLayout"));
		Trip_Selection.get(2).click();

		WebElement Play_Trip = driver.findElement(By
				.id("fr.dvilleneuve.lockito:id/menuPlay"));
		Play_Trip.click();
		driver.quit();
		
			
	}

	@AfterClass
	public void afterClass() {
	}

}
