package SeleniumProje3;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _05_OrderTest extends BaseDriver {
 /*   Senaryo 5: Order Test
➢ Siteye gidin
➢ Login olun
➢ FEATURED PRODUCTS in altında “14.1-inch Laptop” adli ürüne tıklatınız
➢ Ad To Cart butonuna tıklatınız ve urunun başarılı bir şekilde eklendiğini doğrulayın
➢ Sopping cart butonuna tıklatıp sepetinize gidin ve urunun orda görüldüğünü doğrulayın
➢ Agree check box tıklatıp Sartları Kabul edin
➢ Checkout butonuna tıklatın
➢ Açılan sayfada tüm bilgileri doldurun ve confirm order butonuna tıklatın
➢ “Your order has been successfully processed!” mesajının görüldüğünü doğrulayın */
    @Test
    public void OrderTest(){
        driver.get("http://demowebshop.tricentis.com/");
        WebElement login=driver.findElement(By.linkText("Log in"));
        Actions aksiyonlar =new Actions(driver);

        aksiyonlar.moveToElement(login).click().build().perform();
        WebElement email=driver.findElement(By.cssSelector("input[autofocus='autofocus']"));
        aksiyonlar.moveToElement(email).click().sendKeys("omer33455@gmail.com").build().perform();

        WebElement password=driver.findElement(By.xpath("//*[@id=\"Password\"]"));
        aksiyonlar.moveToElement(password).click().sendKeys("123452Omer").build().perform();

        WebElement loginBtn=driver.findElement(By.cssSelector("input[type='submit'][value='Log in']"));

        new Actions(driver).moveToElement(loginBtn).click().build().perform();

        WebElement laptop=driver.findElement(By.linkText("14.1-inch Laptop"));
        aksiyonlar.moveToElement(laptop).click().build().perform();


         WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-to-cart-button-31\"]")));


        WebElement addToCard=driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-31\"]"));
        aksiyonlar.moveToElement(addToCard).click().build().perform();

        WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(30));
       wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));


        WebElement addToCartvalidation=driver.findElement(By.className("content"));
        Assert.assertTrue("urununuz eklenemedi",addToCartvalidation.getText().contains("The product has been added to your "));


        WebElement shoppingCart=driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        new Actions(driver).moveToElement(shoppingCart).click().build().perform();

        WebElement laptopValidation=driver.findElement(By.linkText("14.1-inch Laptop"));
        Assert.assertTrue(laptopValidation.getText().contains("14.1-inch Laptop"));

       WebElement checbox=driver.findElement(By.xpath("//input[@id='termsofservice']"));
        aksiyonlar.moveToElement(checbox).click().build().perform();

        WebElement checkout=driver.findElement(By.xpath("//button[@id='checkout']"));
        aksiyonlar.moveToElement(checkout).click().build().perform();


        //1Billing Address
        WebElement company = driver.findElement(By.cssSelector("input[id='BillingNewAddress_Company']"));
       new Actions(driver).moveToElement(company).click().sendKeys("Tecno Study").build().perform();


        WebElement country = driver.findElement(By.cssSelector("select[id='BillingNewAddress_CountryId']"));
        new Select(country).selectByIndex(77);

        WebElement city = driver.findElement(By.cssSelector("input[id='BillingNewAddress_City']"));
        aksiyonlar.moveToElement(city).click().sendKeys("Sanliurfa").build().perform();

        WebElement adress = driver.findElement(By.cssSelector("input[id='BillingNewAddress_Address1']"));
        new  Actions(driver).moveToElement(adress).click().sendKeys("yenisehir mash. karanfil sok").build().perform();



        WebElement zipCode = driver.findElement(By.cssSelector("input[id='BillingNewAddress_ZipPostalCode']"));
        aksiyonlar.moveToElement(zipCode).click().sendKeys("36700").build().perform();

        WebElement phoneNumber = driver.findElement(By.xpath("//*[@name='BillingNewAddress.PhoneNumber']"));
        aksiyonlar.moveToElement(phoneNumber).click().sendKeys("+905446784567").build().perform();

        WebElement continuee = driver.findElement(By.cssSelector("input[onclick='Billing.save()']"));
        aksiyonlar.moveToElement(continuee).click().build().perform();


        WebElement click = driver.findElement(By.xpath("//*[@id='PickUpInStore']"));
        aksiyonlar.moveToElement(click).click().build().perform();


        WebElement cnt = driver.findElement(By.xpath("//*[@onclick='Shipping.save()']"));
        aksiyonlar.moveToElement(cnt).click().build().perform();


        WebElement paymentCont=driver.findElement(By.xpath("//*[@onclick='PaymentMethod.save()']"));

         wait.until(ExpectedConditions.elementToBeClickable(paymentCont));

        Action action=aksiyonlar.moveToElement(paymentCont).click().build();
        action.perform();


        WebElement paymentInformation=driver.findElement(By.cssSelector("input[class='button-1 payment-info-next-step-button']"));

        wait.until(ExpectedConditions.elementToBeClickable(paymentInformation));
        aksiyonlar.moveToElement(paymentInformation).click().build().perform();


        WebElement confirmOrder=driver.findElement(By.xpath("//*[@onclick='ConfirmOrder.save()']"));

        wait.until(ExpectedConditions.elementToBeClickable(confirmOrder));

        aksiyonlar.moveToElement(confirmOrder).click().build().perform();

        WebElement mesageTitle=driver.findElement(By.cssSelector("div[class='title']"));
        Assert.assertTrue("mesaj eslesmedi",mesageTitle.getText().contains("Your order has been successfully processed!"));








    }

}
