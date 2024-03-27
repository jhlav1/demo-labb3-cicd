package com.example.demolabb3cicd;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoLabb3CicdApplicationTests {

	WebDriver driver;

	@Test
	void checkWebsiteTitle() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.get("https://www.iths.se");
		assertEquals("IT-Högskolan – Här startar din IT-karriär!", driver.getTitle(), "The title does not match");
	}

}
