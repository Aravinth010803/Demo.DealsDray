package org.md;

import java.time.Duration;
import java.util.Date;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class TestNGtest {
	 WebDriver driver;
	@BeforeClass
	private void BeforeClass() {
		driver =new ChromeDriver();
		driver.get("https://demo.dealsdray.com/");
		driver.manage().window().maximize();

	}
	@BeforeMethod
	private void Beforemethod() {
		Date d= new Date();
		System.out.println(d);
	}
	
	@Test
	private void Test11() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
		driver.findElement(By.xpath("//button[text()='Add Bulk Orders']")).click();
		WebElement uploadfile=driver.findElement(By.xpath("//input[@class='MuiOutlinedInput-input MuiInputBase-input MuiInputBase-inputSizeSmall css-1imb3v5']"));
	    uploadfile.sendKeys("C:\\Users\\ELCOT\\Desktop\\demo-data.xlsx");
	    driver.findElement(By.xpath("//button[text()='Import']")).click();
	    driver.findElement(By.xpath("//button[text()='Validate Data']")).click();
	    
	    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());	    
        driver.switchTo().alert().accept();
        WebElement scroll = driver.findElement(By.xpath("//input[@value='171-0771026-4255557']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", scroll);

	}
	
	@AfterMethod
	private void AfterMethod() {
		Date d= new Date();
		System.out.println(d);

	}
	@AfterClass
	private void AfterClass() {
	   //  driver.quit();

	}

}
