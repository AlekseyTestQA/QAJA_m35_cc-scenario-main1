package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

//Что такое record 'https://www.baeldung.com/java-record-keyword'

//Имплементация паттерна Page Object Model
public record ChooseAdresPage(WebDriver webDriver) {

    private static final String URL = "https://dodopizza.ru/volgograd/contacts";
    private static final String SEARCH_FIELD_CLASS = "contacts-pizzerias__filter-input";
    private static final String ERROR_MESSAGE_SPAN_CLASS = "contacts-pizzerias__filter-desc";

    public void go() {
        webDriver.get(URL);
    }

    public void searchAdres(String adres) {
        final var searchInput = webDriver.findElement(By.className(SEARCH_FIELD_CLASS));
        searchInput.sendKeys(adres, Keys.ENTER);
    }

    public String getCityNotFoundMessage() {
        return webDriver.findElement(By.className(ERROR_MESSAGE_SPAN_CLASS)).getText();
    }
}
