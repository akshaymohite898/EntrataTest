# EntrataTest
# Selenium Tests for entrata.com

This repository contains Selenium tests written in Java using JUnit framework to explore and validate the functionality of entrata.com.

## Setup

1. Clone this repository to your local machine.
2. Ensure you have Java and Maven installed.
3. Download the appropriate WebDriver executable (e.g., ChromeDriver) and update the path in the test code.
4. Run `mvn verify` command in the project directory to execute the tests.

## Test Cases

### 1. HomePageNavigationTest

- Purpose: This test verifies the navigation to the home page of entrata.com.
- Steps:
  1. Open the browser.
  2. Navigate to the home page.
- Assertions:
  - Validate the page title.

  @Test
    public void testLoginPage() {
        // Test navigating to the login page
        driver.get("https://www.entrata.com/");
        WebElement loginButton = driver.findElement(By.xpath("//a[contains(text(), 'Log In')]"));
        loginButton.click();
        assertEquals("https://www.entrata.com/login", driver.getCurrentUrl());

### 2. DynamicContentTest

- Purpose: This test verifies the presence and correctness of dynamic content on a specific page of entrata.com.
- Steps:
  1. Open the browser.
  2. Navigate to a page with dynamic content.
  3. Wait for the dynamic content to load.
- Assertions:
  - Validate the presence and correctness of dynamic content.

@Test
    public void testContactPage() {
        // Test navigating to the contact page
        driver.get("https://www.entrata.com/");
        WebElement contactLink = driver.findElement(By.xpath("//a[contains(text(), 'Contact Us')]"));
        contactLink.click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(), 'Contact Us')]")).isDisplayed());
    }


### 3. FormInteraction

- Purpose: This test verifies interaction with a form on entrata.com.
- Steps:
  1. Open the browser.
  2. Navigate to a page with a form.
  3. Enter data into form fields.
- Assertions:
  - Validate that form fields accept input.

@Test
    public void testFormInteraction() {
        // Test interacting with forms
        driver.get("https://www.entrata.com/");
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("test@example.com");
        assertEquals("https://www.entrata.com/forms", emailInput.getAttribute("value"));}

## Dependencies

- Selenium WebDriver
- JUnit

##   pom.xml file

<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.entrata</groupId>
  <artifactId>test</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>jar</packaging>

  <name>test</name>
  <url>http://www.example.com</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>

  <dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.141.59</version>
    </dependency>
    <dependency>
    	<groupId>entrata</groupId>
    	<artifactId>.com</artifactId>
    	<version>0.0.1-SNAPSHOT</version>
    </dependency>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.141.59</version>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>3.0.0-M5</version>
      </plugin>
    </plugins>
  </build>
</project>


##  Full Code 

private WebDriver driver;

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
    public void testNavigation() {
        // Test navigating to different pages
        driver.get("https://www.entrata.com/");
        WebElement solutionsLink = driver.findElement(By.xpath("//a[text()='Solutions']"));
        solutionsLink.click();
        assertEquals("https://www.entrata.com/solutions", driver.getCurrentUrl());
    }

    @Test
    public void testFormInteraction() {
        // Test interacting with forms
        driver.get("https://www.entrata.com/");
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("test@example.com");
        assertEquals("https://www.entrata.com/forms", emailInput.getAttribute("value"));
    }

    @Test
    public void testContactPage() {
        // Test navigating to the contact page
        driver.get("https://www.entrata.com/");
        WebElement contactLink = driver.findElement(By.xpath("//a[contains(text(), 'Contact Us')]"));
        contactLink.click();
        assertTrue(driver.findElement(By.xpath("//h1[contains(text(), 'Contact Us')]")).isDisplayed());
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
