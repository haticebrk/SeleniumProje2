package Seleniumproje;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Proje4 extends BaseDriver {

    @Test
    public void Test1(){

        driver.navigate().to("https://www.akakce.com/");

        System.out.println(driver.getTitle());

        WebElement hesapAc= driver.findElement(By.linkText("Hesap Aç"));
        hesapAc.click();
        MyFunc.Bekle(1);

        WebElement isim=driver.findElement(By.id("rnufn"));
        isim.sendKeys("ali");
        MyFunc.Bekle(1);

        WebElement soyisim=driver.findElement(By.id("rnufs"));
        soyisim.sendKeys("yilmaz");
        MyFunc.Bekle(1);

        WebElement email=driver.findElement(By.id("rnufe1"));
        email.sendKeys("aliy12@hotmail.com");
        MyFunc.Bekle(1);

        WebElement emailDogrulama=driver.findElement(By.id("rnufe2"));
        emailDogrulama.sendKeys("aliy12@hotmail.com");
        MyFunc.Bekle(1);

        WebElement sifre=driver.findElement(By.id("rnufp1"));
        sifre.sendKeys("12xPswer");
        MyFunc.Bekle(1);

        WebElement sifreTekrar=driver.findElement(By.id("rnufp2"));
        sifreTekrar.sendKeys("12xPswer");
        MyFunc.Bekle(1);

        WebElement cinsiyet=driver.findElement(By.id("rngm"));
        cinsiyet.click();
        MyFunc.Bekle(1);

        WebElement selectMenu1=driver.findElement(By.name("locpr"));
        Select il=new Select(selectMenu1);
        il.selectByValue("74");
        MyFunc.Bekle(1);

        WebElement selectMenu2=driver.findElement(By.cssSelector("label[for='locds']+select"));
        Select ilce=new Select(selectMenu2);
        ilce.selectByVisibleText("Ulus");

        WebElement selectMenu3=driver.findElement(By.xpath("//span[@class='frm_v8 inl_v8']/select"));
        Select gun=new Select(selectMenu3);
        gun.selectByIndex(15);

        WebElement selectMenu4=driver.findElement(By.id("bm"));
        Select ay=new Select(selectMenu4);
        ay.selectByValue("5");

        WebElement selectMenu5=driver.findElement(By.xpath("//select[@class='t' and @name='by']"));
        Select yil=new Select(selectMenu5);
        yil.selectByValue("1990");

        WebElement sozlesme=driver.findElement(By.id("rnufpca"));
        sozlesme.click();
        MyFunc.Bekle(1);

        WebElement hesapAcimi=driver.findElement(By.xpath("//*[@value='Hesap aç' and @class='s' and @type='submit']"));
        hesapAcimi.click();
        MyFunc.Bekle(1);

//        WebElement giris=driver.findElement(By.linkText("Giriş Yap"));
//        giris.click();
//        MyFunc.Bekle(1);
//
//        WebElement email=driver.findElement(By.id("life"));
//        email.sendKeys("aliy@hotmail.com");
//        MyFunc.Bekle(1);
//
//        WebElement sifre=driver.findElement(By.id("lifp"));
//        sifre.sendKeys("12xPswer");
//        MyFunc.Bekle(1);
//
//        WebElement grs=driver.findElement(By.id("lfb"));
//        grs.click();
//        MyFunc.Bekle(1);

        WebElement hesapDogrulama=driver.findElement(By.linkText("Ali"));
        Assert.assertTrue("boyle bir hesap yoktur",hesapDogrulama.getText().contains("Ali"));
        hesapDogrulama.click();

        WebElement siparis=driver.findElement(By.linkText("Siparişlerim"));
        siparis.click();
        MyFunc.Bekle(1);

        WebElement siparisDogrulama=driver.findElement(By.xpath("//div[text()='Kayıtlı siparişiniz bulunmuyor.']"));
        Assert.assertTrue("Siparisiniz bulunmaktadir",siparisDogrulama.getText().contains("Kayıtlı siparişiniz bulunmuyor."));

        driver.navigate().back();

        WebElement mesaj=driver.findElement(By.linkText("Mesajlarım"));
        mesaj.click();
        MyFunc.Bekle(1);

        WebElement mesajDogrulama=driver.findElement(By.xpath("//p[text()='Listelenecek mesaj bulunamadı.']"));
        Assert.assertTrue("Mesajiniz bulunmaktadir",mesajDogrulama.getText().contains("Listelenecek mesaj bulunamadı."));

        WebElement anasayfa=driver.findElement(By.linkText("Akakce.com"));
        anasayfa.click();
        MyFunc.Bekle(1);

        WebElement profileGit=driver.findElement(By.linkText("Ali"));
        profileGit.click();

        WebElement hesapSil=driver.findElement(By.xpath("//*[@href='/akakcem/kullanici-bilgilerim/uyelik-iptali/']"));
        hesapSil.click();
        MyFunc.Bekle(1);

        WebElement hesapSilmesifre=driver.findElement(By.xpath("//*[@class='t' and @type='password']"));
        hesapSilmesifre.sendKeys("12xPswer");
        MyFunc.Bekle(1);

        WebElement hesapSilOnay=driver.findElement(By.xpath("//*[@id='u' and @type='submit']"));
        hesapSilOnay.click();
        MyFunc.Bekle(1);





    }
}
