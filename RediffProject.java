package basic;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class RediffProject {
	ChromeDriver driver;
	@Before
	public void url()
	{
		driver =new ChromeDriver();
		driver.get("https://m.rediff.com/");
	}
	@Test
	public void Rediff() throws IOException, InterruptedException
	{
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
			
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File("E:\\Rediffss.png") );
		WebElement logo=driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/a/img"));
		if(logo.isDisplayed())
		{
			System.out.println("Logo Displayed");
		}
		else
		{
			System.out.println("Logo not Displayed");
		}
		
		
		driver.findElement(By.xpath("//*[@id=\"signin_info\"]/a[1]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/form/div[1]/div/input")).sendKeys("adarsh123");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("ada");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/div[2]/form/button")).click();
		driver.navigate().back();
		driver.navigate().back();
		
		
		driver.findElement(By.xpath("//*[@id=\"signin_info\"]/a[2]")).click();
		
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[2]/input")).sendKeys("Adarsh");
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[3]/div/input")).sendKeys("adrshka");
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[4]/input")).click();
		Thread.sleep(2000); 
		WebElement msg=driver.findElement(By.xpath("//*[@id=\"check_availability\"]/div/span"));
		String  rslt=msg.getText();
		System.out.println("Message :"+ rslt);
		if (rslt.contains("Yippie! The ID you've chosen is available.")) {
            System.out.println("ID Available");
        } else {
            System.out.println("ID Not Available");
        }
		
		driver.findElement(By.xpath("//*[@id=\"newpasswd\"]")).sendKeys("Adarsh@1234");
		driver.findElement(By.xpath("//input[@id='newpasswd1']")).sendKeys("Adarsh@1234");

		WebElement day=driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[8]/select[1]"));
		Select DropDay=new Select(day);
		DropDay.selectByValue("11");
		List<WebElement> li=DropDay.getOptions();
		System.out.println(li.size());
		
		WebElement month=driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[8]/select[2]"));
	    Select DropMonth=new Select(month);
	    DropMonth.selectByIndex(2);
	    List<WebElement> li1=DropMonth.getOptions();
	    System.out.println(li1.size());
	    
	    WebElement year=driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[8]/select[3]"));
	    Select DropYear=new Select(year);
	    DropYear.selectByVisibleText("2004");
	    List<WebElement> li2=DropYear.getOptions();
	    System.out.println(li2.size());
	    
		WebElement dob=driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[8]"));
		File Dobss=dob.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(Dobss,new File("./Screenshot//daob.png"));

		WebElement gender=driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[9]/div/label[1]/input"));
		WebElement gender1=driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[9]/div/label[2]/input"));
		if(gender1.isSelected()||gender.isSelected())
		{
			System.out.println("gender selected");
		}
		else
		{
			System.out.println("Gender not Selected");
		}
		 WebElement live=driver.findElement(By.xpath("//*[@id=\"country\"]"));
		    Select cuntry=new Select(live);
		    cuntry.selectByValue("99");
		 WebElement ci=driver.findElement(By.xpath("//*[@id=\"div_city\"]/div/select"));
		    Select city=new Select(ci);
		    city.selectByVisibleText("Cochin");
		    driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[15]/div/input")).click();
		    
		boolean c =driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[15]/div/input")).isSelected();		
		if(c)
		{
			System.out.println("Checkbox selected");
		}
		else
		{
			System.out.println("Checkbox not Selected");
		}
        driver.findElement(By.xpath("//*[@id=\"mobno\"]")).sendKeys("23221548489");	
        WebElement ac=driver.findElement(By.xpath("/html/body/div[2]/div[2]/form/div/div[20]/input"));
        String txt=ac.getText();
        System.out.println(txt);
        
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/p/a[1]")).click();
        js.executeScript("window.scrollBy(0,1000)");
        WebElement element = driver.findElement(By.xpath("/html/body/h2[5]/a"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);

        Thread.sleep(2000);
        
	}
	@After
	public void close()
	{
		driver.close();
	}
}

