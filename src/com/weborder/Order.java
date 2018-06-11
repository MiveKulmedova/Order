package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"/Users/mivekulmedova/Documents/selenium dependencies/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		Thread.sleep(1000);

		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		Thread.sleep(1000);
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();
		Thread.sleep(1000);

		double randNumber = Math.random();
		int num = (int) (randNumber * 100);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtQuantity\"]"))
				.sendKeys(Integer.toString(num));
		Thread.sleep(1000);

		String randomMiddle = randomString(7);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtName\"]"))
				.sendKeys("John " + randomMiddle + " Smith");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox2\"]")).sendKeys("123 Any st");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox3\"]")).sendKeys("Any city");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox4\"]")).sendKeys("WA");
		Thread.sleep(1000);
		
		
		
		double randNum=Math.random();
		int num1=(int)(randNum*50000);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox5\"]")).sendKeys(Integer.toString(num1));
		Thread.sleep(1000);
		
		int r2=(int)(Math.random()*(3-0))+0;
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList_"+r2+"\"]")).click();
		Thread.sleep(1000);
		
		
		String type="";
		int len=0;
		
		if(r2==0)
			{type="visa"; len=15;}
		else if(r2==1)
			{type="master"; len=15;}
		else if(r2==2)
			{type="americanExpress"; len=14;} 
		String cardnumber=randomCreditCard(len,type);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]")).sendKeys(cardnumber);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox1\"]")).sendKeys("11/22");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]")).click();
		Thread.sleep(1000);
		System.out.println("New order has been successfully added.");
	}

	public static String randomString(int len) {
		char[] ch = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };

		char[] c = new char[len];
		Random random = new Random();
		for (int i = 0; i < len; i++) {
			c[i] = ch[random.nextInt(ch.length)];
		}
		return new String(c);
	}
	public static String randomCreditCard(int len,String type) {
		StringBuilder std=new StringBuilder();
		int rdigit;
	   for (int i = 0; i < len; i++) {
		   rdigit = (int) (Math.random() * (9 - 0)) + 0;
		   std.append(rdigit);
		
	}
	   return std.toString();
}

}
