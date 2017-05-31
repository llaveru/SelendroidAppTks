/*
codigo especifico para movil con 6.0.1
*/

package selendroidapptks;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;

import java.net.MalformedURLException;

import java.net.URL;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;

import org.openqa.selenium.remote.CapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;



public class pruebaensamsung {

                             
// create global variable

private static AndroidDriver driver;

public static void main(String[] args) throws MalformedURLException, InterruptedException 
{


 // Create object of DesiredCapabilities class                             

DesiredCapabilities capabilities = new DesiredCapabilities();



// Optional

capabilities.setCapability(CapabilityType.BROWSER_NAME, "");


// Specify the device name (any name)

capabilities.setCapability("deviceName", "Telefono Samsung");


// Platform version

//capabilities.setCapability("platformVersion", "4.4.2");
capabilities.setCapability("platformVersion", "6.0.1");

// platform name

capabilities.setCapability("platformName", "Android");


// specify the application package that we copied from appium  , o uiautomator en tools de androidsdk             

capabilities.setCapability("appPackage", "com.grupotks.auditor");


// specify the application activity that we copied from appium                   

capabilities.setCapability("appActivity", ".MainActivity");

 
// Start android driver I used 4727 port by default it will be 4723

driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);



// Specify the implicit wait of 5 second

driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);



// Enter the text in textbox

//driver.findElement(By.xpath("//android.widget.EditText[@content-desc='my_text_fieldCD']")).sendKeys("Mukesh Selenium Appium");
driver.findElement(By.id("username")).sendKeys("reciclar");

// click on registration button  
                                   
//driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration")).click();
driver.findElement(By.id("password")).sendKeys("12345");

driver.findElement(By.id("btn")).click();

// Wait for 10 second

Thread.sleep(10000);



// close the application
 driver.quit();



                }



}
