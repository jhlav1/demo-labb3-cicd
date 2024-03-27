package com.example.demolabb3cicd;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoLabb3CicdApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void checkWebsiteTitle() {
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.iths.se");
		assertEquals("IT-Högskolan – Här startar din IT-karriär!", driver.getTitle(), "The title does not match");
	}

}
