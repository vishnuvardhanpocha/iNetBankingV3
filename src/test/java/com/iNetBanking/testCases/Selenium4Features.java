package com.iNetBanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class Selenium4Features extends BaseClass{
	
	@Test
	public void featuresTest() throws IOException{
		
		
		WebElement logo = driver.findElement(By.xpath("//img[@alt='Guru99 Demo Sites']"));
		File src_file = logo.getScreenshotAs(OutputType.FILE);
		File dest_file = new File("logo.png");
		
		FileUtils.copyFile(src_file, dest_file);
		
		System.out.println("Height of logo is "+logo.getRect().getHeight());
		System.out.println("Width of logo is "+logo.getRect().getWidth());
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.navigate().to("http://ww3.demouat.com/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to("http://ww3.demouat.com/");
		
		driver.quit();
		
	
	}

}
