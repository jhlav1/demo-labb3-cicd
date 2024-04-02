package com.example.demolabb3cicd;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoLabb3CicdApplicationTests {

	WebDriver driver;

	@BeforeEach
	void setup(){
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		driver = new ChromeDriver(options);
		driver.get("https://www.iths.se");
		driver.manage().window().maximize();

	}

	@Test
	void checkWebsiteTitle() {

		assertEquals("IT-Högskolan – Här startar din IT-karriär!", driver.getTitle(), "The title does not match");
	}
	@Test
	void checkHeading(){

		WebElement heading = driver.findElement(By.tagName("h1"));
		String headingText = heading.getText();
		Assertions.assertEquals("Här startar din IT-karriär!", headingText);

	}
	@Test
	void checkText(){
		WebElement mutedText = driver.findElement(By.xpath("//*[text()='Här startar din IT-karriär!']"));
		String mutedTextContent= mutedText.getText();
		Assertions.assertEquals("Här startar din IT-karriär!", mutedTextContent);
	}

	@Test
	void getNumberOfButtons(){
		List<WebElement> webElement = driver.findElements(By.className("btn--dark"));
		int numberOfElements = webElement.size();
		Assertions.assertEquals(5, numberOfElements);
	}

	@Test
	void checkVisibilityOfElement() {
		Dimension newSize = new Dimension(600, 900);
		driver.manage().window().setSize(newSize);
	}

	@Test
	void checkVisibilityOfElementToggleMenuMobilSize(){
		Dimension newSize = new Dimension(600, 900);
		driver.manage().window().setSize(newSize);
		WebElement menuButton = driver.findElement(By.id("mobile-toggle"));
		Boolean menuButtonIsDisplayed = menuButton.isDisplayed();

		Assertions.assertTrue(menuButtonIsDisplayed);

	}



	@AfterEach
	void teardown(){
		driver.quit();
	}



}
