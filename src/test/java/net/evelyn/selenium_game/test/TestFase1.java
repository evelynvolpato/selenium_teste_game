package net.evelyn.selenium_game.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;

public class TestFase1 {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://vanilton.net/selenium/game/");
        WebElement botaoX = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='modalInitial']//button[@class='close']")));
        botaoX.click();
    }

    @Test
    public void loginValido() throws InterruptedException {
        driver.findElement(By.id("nome")).sendKeys("caboquinho");
        driver.findElement(By.xpath("//input[@id='senha']")).sendKeys("0123456789");
        driver.findElement(By.name("entrar")).click();
        wait.withTimeout(15, TimeUnit.SECONDS);
        String msgRetorno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg_login"))).getText();
        Assert.assertEquals("Login efetuado com sucesso!", msgRetorno);
        WebElement radio1 = driver.findElement(By.xpath("//label[@for=\"radio5\"]"));
        radio1.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@onclick=\"checkAnswer()\"]")).click();
    }

    @Test
    public void loginInvalido(){
        driver.findElement(By.id("nome")).sendKeys("julieta");
        driver.findElement(By.xpath("//input[@id='senha']")).sendKeys("0123456789");
        driver.findElement(By.name("entrar")).click();
        wait.withTimeout(15, TimeUnit.SECONDS);
        String msgRetorno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg_login"))).getText();
        Assert.assertEquals("Login incorreto!", msgRetorno);
    }

    @Test
    public void Quizz01() throws InterruptedException {
        driver.findElement(By.id("nome")).sendKeys("caboquinho");
        driver.findElement(By.xpath("//input[@id='senha']")).sendKeys("0123456789");
        driver.findElement(By.name("entrar")).click();
        wait.withTimeout(15, TimeUnit.SECONDS);
        String msgRetorno = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg_login"))).getText();
        Assert.assertEquals("Login efetuado com sucesso!", msgRetorno);
        WebElement radio1 = driver.findElement(By.xpath("//label[@for=\"radio5\"]"));
        radio1.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@onclick=\"checkAnswer()\"]")).click();
        WebElement radio2 = driver.findElement(By.xpath("//label[@for=\"radio4\"]"));
        radio2.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@onclick=\"checkAnswer()\"]")).click();
        WebElement radio3 = driver.findElement(By.xpath("//label[@for=\"radio2\"]"));
        radio3.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@onclick=\"checkAnswer()\"]")).click();
        WebElement radio4 = driver.findElement(By.xpath("//label[@for=\"radio2\"]"));
        radio4.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@onclick=\"checkAnswer()\"]")).click();
    }


    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

}

//label[@for="radio4"]