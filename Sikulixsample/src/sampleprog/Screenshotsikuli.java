package sampleprog;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;

public class Screenshotsikuli {

	public static void main(String[] args) throws Exception
	{
		//Launch You-tube site (SWD)
			System.setProperty("Webdriver.chrome.driver","F:\\batch239\\chromedriver.exe");
			ChromeDriver driver=new ChromeDriver();
			driver.get("https://www.google.co.in");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		//Take full screen shot of a screen
			
			File f1=new File("F://batch239/fullscreen.png");
			Screen s= new Screen();
			ScreenImage sil=s.capture();
			BufferedImage bil=sil.getImage();
			ImageIO.write(bil,"png",f1);
			
		//Take selected area as Screens shot of a screen
			File f2=new File("F://batch239/selectedscreen.png");
			Region r=new Region(500,500,200,200);
			ScreenImage si2=s.capture(r);
			BufferedImage bi2=si2.getImage();
			ImageIO.write(bi2,"png",f2);
		//close site
			driver.close();
			
			
	}

}
