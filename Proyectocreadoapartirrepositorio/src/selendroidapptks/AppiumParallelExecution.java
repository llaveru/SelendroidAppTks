/*
clase que extiende de runnable, y por lo tanto puede correr en un hilo
al construirse le pasamos capabilities del movil a probar
y tiene un metodo que realiza ciertas acciones.

*/


package selendroidapptks;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;

public class AppiumParallelExecution implements Runnable {
   
    String port;
    String udid;
    String versionAndroid;
    
    public AppiumParallelExecution(String portNumber, String udid,String versionAndroid) {
        this.port = portNumber;
        this.udid = udid;
        this.versionAndroid= versionAndroid;
    }
   
  //  @AndroidFindBy(id="username")
    //private WebElement casillauser;
   
    //@AndroidFindBy(id="password")
    //private WebElement casillapass;
   
  //  @AndroidFindBy(id="btn")
   // private WebElement botonLogin;
   
    
    AppiumDriver<WebElement> driver;
    DesiredCapabilities capabilities = new DesiredCapabilities();
    
   
    private void openAppAndPerformSomeActions() throws InterruptedException {
        capabilities.setCapability("deviceName", "My Mobile Device");
        capabilities.setCapability("udid", udid);
        capabilities.setCapability("platformVersion", versionAndroid);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.grupotks.auditor");
        capabilities.setCapability("appActivity", ".MainActivity");
       
        if (driver!=null) {
            driver.quit();
            System.out.println("se salio driver");
        }
        
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:" + port + "/wd/hub"), capabilities);
            
            Thread.sleep(4000);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       
        if (versionAndroid.equals("6.0.1")) {
            System.out.println("Se encontro version superior a  6 de android, ");
            Thread.sleep(2000);
            while (driver.findElements(By.xpath("//*[@class='android.widget.Button'][2]")).size()>0) {
    driver.findElement(By.xpath("//*[@class='android.widget.Button'][2]")).click();
}
            //driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
        }
    
//driver.findElement(By.xpath("//android.widget.EditText[@content-desc='my_text_fieldCD']")).sendKeys("Mukesh Selenium Appium");

        if ( driver.findElements(By.id("username")).size()>0) {
            driver.findElement(By.id("username")).clear();
            driver.findElement(By.id("username")).sendKeys("reciclar");
        }
Thread.sleep(1000);
 if (versionAndroid.equals("6.0.1")) {
            System.out.println("Se encontro version superior a  6 de android, ");
            Thread.sleep(10000);
            while (driver.findElements(By.xpath("//*[@class='android.widget.Button'][2]")).size()>0) {
    driver.findElement(By.xpath("//*[@class='android.widget.Button'][2]")).click();
}
            //driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
        }
 
 driver.findElement(By.id("username")).sendKeys("reciclar");
 
// click on registration button  
                                   
//driver.findElement(By.id("io.selendroid.testapp:id/startUserRegistration")).click();
driver.findElement(By.id("password")).sendKeys("12345");

driver.findElement(By.id("btn")).click();

// Wait for 10 second

Thread.sleep(5000);

//pulsa el navigation drawer button superior
driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();

Thread.sleep(1000);

//pulsa la vista de la linterna
driver.findElement(By.xpath("//android.view.View[@content-desc='Linterna']")).click();
Thread.sleep(6000);
   if (versionAndroid.equals("6.0.1")) {
            System.out.println("Se pulsa en boton linterna, ");
            Thread.sleep(5000);
            while (driver.findElements(By.xpath("//*[@class='android.widget.Button'][2]")).size()>0) {
    driver.findElement(By.xpath("//*[@class='android.widget.Button'][2]")).click();
}
          Thread.sleep(5000);  //driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
        }
driver.findElement(By.xpath("//android.view.View[@content-desc='Linterna']")).click();
Thread.sleep(6000);
driver.quit();
    }
   
    public static void main(String args[]) {
        //Runnable r1 = new AppiumParallelExecution("5000", "ah37kjf982a2b2c1a9"); //device id of first mobile device
        //Runnable r2 = new AppiumParallelExecution("4723", "BDE3N1678E001068"); //device id of second mobile device
        Runnable r1 = new AppiumParallelExecution("5000", "TUBBBCB6B0321487","5.1"); //device id of first mobile device
        //Runnable r2 = new AppiumParallelExecution("4723", "dd7efec3","6.0.1"); //device id of second mobile device
        Runnable r2 = new AppiumParallelExecution("4723", "5203445958c5c391","6.0.1"); //device id of second mobile device
       
                //new Thread(r1).start();
       new Thread(r2).start();
    }

    @Override
    public void run() {
        try {
            openAppAndPerformSomeActions();
        } catch (InterruptedException ex) {
            Logger.getLogger(AppiumParallelExecution.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}