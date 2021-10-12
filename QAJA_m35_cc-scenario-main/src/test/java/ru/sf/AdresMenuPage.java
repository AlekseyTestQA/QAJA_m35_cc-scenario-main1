package ru.sf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public record AdresMenuPage(WebDriver webDriver) {

    private final static String ACTIVE_ADRES_SPAN_XPATH = "//span[@class='contacts-pizzerias__item contacts-pizzerias__item_address']";

    public String getCurrentActiveAdres() {
        return webDriver.findElement(By.xpath(ACTIVE_ADRES_SPAN_XPATH)).getText();
    }
}
