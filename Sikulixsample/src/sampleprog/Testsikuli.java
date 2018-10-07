package sampleprog;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Button;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class Testsikuli {

	public static void main(String[] args) throws Exception
	{
		//Launch You-tube site (SWD)
		System.setProperty("Webdriver.chrome.driver","F:\\batch239\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.youtube.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//Search for a video
		driver.findElement(By.name("search_query")).sendKeys("Abdul Kalam Speeches");
		driver.findElement(By.xpath("(//*[@aria-label='Search'])[3]")).click();
		WebDriverWait w =new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id='result-count'])")));
		
		//Open the Link to play video (SWD)
		
		driver.findElement(By.xpath("//*[contains(text(),'Abdul Kalam in European Parliament')]")).click();
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(@class,'ytp-player-content ytp-iv-player-content')]")));
			Thread.sleep(5000);
		//Skip add if exists (Sikulix)
		Screen s=new Screen();
		if(s.exists("Skipadd.png")!=null)
		{
			s.click("Skipadd.png");
		}
	
		//Move mouse pointer on to any location on video
		Location l=new Location(200,500);
		s.wheel(l,Button.LEFT,0);
		s.mouseMove("Pause.png");
		s.click("Pause.png");
		Thread.sleep(5000);
		s.mouseMove("Volume.png");
		Thread.sleep(5000);
		Match e=s.find("Bubble.png");
		int x=e.getX();
		int y=e.getY();
		Location dl1=new Location(x-20,y);
		s.dragDrop("Bubble.png",dl1);
		Thread.sleep(5000);
		Location dl2=new Location(x+20,y);
		s.dragDrop("Bubble.png",dl2);
		Thread.sleep(5000);
		driver.close();				
		

	}

}
