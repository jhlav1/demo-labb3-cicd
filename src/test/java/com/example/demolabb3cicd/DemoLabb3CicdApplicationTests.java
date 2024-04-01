package com.example.demolabb3cicd;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoLabb3CicdApplicationTests {

	WebDriver driver;

	@BeforeEach
	void setup(){
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
	}

	@Test
	void checkWebsiteTitle() {
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options); */
		driver.get("https://www.iths.se");
		assertEquals("IT-Högskolan – Här startar din IT-karriär!", driver.getTitle(), "The title does not match");
	}
	@Test
	void checkHeading(){

		driver.get("https://www.iths.se");
		WebElement heading = driver.findElement(By.tagName("h1"));
		String headingText = heading.getText();
		Assertions.assertEquals("Här startar din IT-karriär!", headingText);

	}

	@AfterEach
	void teardown(){
		driver.quit();
	}



}
