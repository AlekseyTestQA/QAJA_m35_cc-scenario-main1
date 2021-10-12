package ru.sf;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;


/**
 * Варинаты запуска сценариев:
 * Команда 'mvn clean test' в консоли
 * Через UI intellij IDEA
 */
public class StepDefinitions {

    public static final WebDriver webDriver;
    public static final ChooseAdresPage chooseAdresPage;
    public static final AdresMenuPage adresMenuPage;

    //Процесс инициализации необходимых ресурсов
    static {
        System.setProperty("webdriver.chrome.driver", "D:\\IdeaP\\QAJA_m35_cc-scenario-main1\\QAJA_m35_cc-scenario-main\\src\\test\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().maximize();
        chooseAdresPage = new ChooseAdresPage(webDriver);
        adresMenuPage = new AdresMenuPage(webDriver);
    }

    //Реализация шага
    //Текст должен строго соответствоать тексту сценария
    @Given("url of restaurant {string}")
    public void url_of_restaurant(String url) {
        chooseAdresPage.go();
    }
    @Then("chose adres {string}")
    public void chose_adres(String adres) {
        chooseAdresPage.searchAdres(adres);

    }
    @Then("assert that chosen adres is {string}")
    public void assert_that_сhosen_adres_is(String expectedAdres) {
     final var currentActiveAdres = adresMenuPage.getCurrentActiveAdres();
       assertEquals(expectedAdres, currentActiveAdres);
   }

   @Then("assert that user got message {string}")
    public void assert_that_user_got_message(String errorMessage) {
       final var cityNotFoundMessage = chooseAdresPage.getCityNotFoundMessage();
       assertEquals(errorMessage, cityNotFoundMessage);
   }
}
