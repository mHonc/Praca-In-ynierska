package com.FitnessPlanApp.e2e;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(SerenityRunner.class)
public class LoginTest {

	@Managed
	WebDriver driver;

	@Test
	public void UserIsAbleToLogin(){
		driver.get("http://localhost:8080/");
		driver.findElement(By.xpath("//*[@id='inputEmailAddress']")).sendKeys("admin@sport.pl");
		driver.findElement(By.xpath("//*[@id='inputPassword']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@value='Zaloguj']")).click();
		driver.getCurrentUrl().contains("home");
	}

}
