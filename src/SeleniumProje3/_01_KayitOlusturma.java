package SeleniumProje3;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class _01_KayitOlusturma extends BaseDriver {
 //   Senaryo 1: Kayıt oluşturma Testi
//➢ Siteye gidin
//➢ Register butonuna tıklayın
//➢ Kişisel bilgileri doldurun ve register butonuna tıklayın
//➢ Başarılı bir şekilde kaydolduğunuzu doğrulayınız

    @Test
    public void KayitOlusturma(){
        driver.get("http://demowebshop.tricentis.com/");
        WebElement register=driver.findElement(By.linkText("Register"));
        Actions aksiyonlar =new Actions(driver);

       aksiyonlar.moveToElement(register).click().build().perform();

       WebElement gender=driver.findElement(By.id("gender-female"));
        aksiyonlar.moveToElement(gender).click().build().perform();

        WebElement firstName=driver.findElement(By.id("FirstName"));
       aksiyonlar.moveToElement(firstName).click().sendKeys("Omer").build().perform();

        WebElement lastName=driver.findElement(By.id("LastName"));
        aksiyonlar.moveToElement(lastName).click().sendKeys("karaduman").build().perform();

        WebElement email=driver.findElement(By.xpath("//*[@id=\"Email\"]"));
        aksiyonlar.moveToElement(email).click().sendKeys("omer33455@gmail.com").build().perform();

        WebElement password=driver.findElement(By.id("Password"));
        aksiyonlar.moveToElement(password).click().sendKeys("123452Omer").build().perform();

        WebElement confirmPassword=driver.findElement(By.cssSelector("label[for='ConfirmPassword']"));
        aksiyonlar.moveToElement(confirmPassword).click().sendKeys("123452Omer").build().perform();

        WebElement ragisterBtn=driver.findElement(By.name("register-button"));
        aksiyonlar.moveToElement(ragisterBtn).click().build().perform();

        WebElement mesage = driver.findElement(By.xpath("//div[@class='result']"));
        Assert.assertTrue("kayit isleminiz gerceklestirilemedi",mesage.getText().contains("Your registration completed"));


        driverKapat();


    }
}
