package testNGCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.support.ui.Select;

public class tng1 {
	WebDriver driver;
	JavascriptExecutor js;
	
	@BeforeClass
	public void start() {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumIDE\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://computer-database.herokuapp.com/computers");
		js=(JavascriptExecutor)driver;

	}

	//part 1
	@Test
	public void main() {
		String script1="return document.querySelector(\"h1.fill a\").innerText;";
		String text_top=(String) js.executeScript(script1);

		if(text_top.equals("Play Sample application - Computer DataBase")){
			System.out.println("Text Matched");
		}
	}

	//part 2
	
	@Test
	public void main2() {
		String script2="document.getElementById(\"add\").click();";
		js.executeScript(script2);

		String script3="document.getElementById(\"name\").value='Dell Windows10';";
		js.executeScript(script3);
		String script4="document.getElementById(\"introduced\").value='2019-06-01';";
		js.executeScript(script4);
		String script5="document.getElementById(\"discontinued\").value='2020-06-01';";
		js.executeScript(script5);
		Select s=new Select(driver.findElement(By.xpath("//select[@id='company']")));
		s.selectByVisibleText("RCA");

		String script6="document.querySelector(\"input[value='Create this computer']\").click();";
		js.executeScript(script6);
		
		// Verifying the created computer exist
		String script7="document.getElementById(\"searchbox\").value='Dell Windows10';";
		js.executeScript(script7);
		
		String script8="document.getElementById(\"searchsubmit\").click();";
		js.executeScript(script8);

		String script9="return document.querySelector(\"tbody tr td\").innerText;";
		String computerName=(String) js.executeScript(script9);
		
		if(computerName.equals("Dell Windows10")){
			System.out.println("New Device added successfully");
		}
		js.executeScript("window.history.back()");
	}

	//part 3
	
	@Test
	public void main3() {
		String script10="document.getElementById(\"searchbox\").value='Amigo 500';";
		js.executeScript(script10);
		
		String script11="document.getElementById(\"searchsubmit\").click();";
		js.executeScript(script11);

		String script12="return document.querySelector(\"tbody tr td:nth-child(2)\").innerText;";
		String Date=(String) js.executeScript(script12);

		if(Date.equals("01 Jan 1987")){
			System.out.println("Date Matched");
		}
		js.executeScript("window.history.back()");
	}
	

	//part 4

	@Test
	public void main4() {

		boolean verify=false;
		verify=driver.findElement(By.id("searchbox")).isDisplayed();
		if(verify){
			String script13="document.getElementById(\"searchbox\").value='Computer Apple I';";
			js.executeScript(script13);
		
			String script14="document.getElementById(\"searchsubmit\").click();";
			js.executeScript(script14);

			String script15="document.querySelector(\"tbody tr td\").click();";
			js.executeScript(script15);

			String script16="document.querySelector(\"input[value='Delete this computer']\").click();";
			js.executeScript(script16);
		}
		else{
			System.out.println("Not Present");
		}
	}


	@AfterClass
	public void close() {
		driver.close();
	}
	
}
