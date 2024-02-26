package com.entrata.test;

import org.springframework.boot.web.server.WebServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;

public class EntrataTest {
	
	private WebServer driver;

    @Before
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLoginPage() {
        // Test navigating to the login page
        driver.get("https://www.entrata.com/");
        WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(), 'Log In')]"));
        loginButton.click();
        assertEquals("https://www.entrata.com/login", driver.getCurrentUrl());
    }

    @Test
    public void testContactPage() {
        // Test navigating to the contact page
        driver.get("https://www.entrata.com/");
        WebElement contactLink = driver.findElement(By.xpath("//a[contains(text(), 'Contact Us')]"));
        contactLink.click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(), 'Contact Us')]")).isDisplayed());
    }

    // Add more test methods as needed

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    
}
