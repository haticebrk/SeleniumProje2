package SeleniumProjee.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;

     static  // dedigimizde yazmaya bile gerek kalmadan ilk seferde yazilmis gibi gozukuyor staik bolgun ozelligi ilk kod icin gecerli
     {
         KalanOncekileriKapat();
         Logger logger = Logger.getLogger("");// butun loglara ulastimm .
         logger.setLevel(Level.SEVERE);  //Sadece errorlari goster
         System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");//chromo loglarini rundan sildik
         // ilk adimda calisan kod kisim
         System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().window().maximize();// ekrani max yapiyor
         driver.manage().deleteAllCookies(); // sitenin senin bilgisayirinda yaptigi ayarlar siliniyor .sayfa baslangic ayarlarina donuyor

         Duration dr = Duration.ofSeconds(30);//sadece tum sayfanihn kodlarinin bilgisayartiniza inmesi suresiyleilgili
         driver.manage().timeouts().pageLoadTimeout(dr); // bu eklenmezse seleniuym sayfa yuklenene kadar (sonsuza) bekler.
         //30 sn suresince sayfanin yuklenmesini bekler yuklenmezse hata verireger sayfa 2sn yukleme yaparsa 30 sn beklemez


         driver.manage().timeouts().implicitlyWait(dr);// butun webelementlerin element bazinda elemente ozel islem yapilmadamn once
         //hazir hale gelmesi verilen muhlet yani sure

         wait=new WebDriverWait(driver, Duration.ofSeconds(10));
     }
    public static void KalanOncekileriKapat() {
         try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {

        }
    }

    public static void driverKapat(){

       MyFunc.Bekle(5);
       driver.quit();
    }
}
