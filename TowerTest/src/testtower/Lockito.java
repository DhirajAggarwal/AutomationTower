package testtower;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Lockito {
	WebDriver driver;

	@BeforeClass
	public void setup() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		
		/*capabilities.setCapability("Platform Version", "4.4");
		capabilities.setCapability("deviceName", "0cbbdc0a032f9efa");
		capabilities.setCapability("Platform Name", "Android");
		capabilities.setCapability("Automation Name", "Appium");
		capabilities.setCapability("appium-version", "1.4.0.0");*/

		capabilities.setCapability("Package", "fr.dvilleneuve.lockito");
		// This package name of your app (you can get it from apk info app)
		//capabilities.setCapability("appActivity",
		//		"com/example/hello/MainActivity.java");
		
		
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
	}

	/*@Test
	public void test_1x  {
		

	}*/

	@AfterClass
	public void afterClass() {
	}

}
