package ua.mainacademy;

import org.openqa.selenium.WebDriver;
import ua.mainacademy.service.AmazonItemHandleService;
import ua.mainacademy.service.AmazonSearchService;
import ua.mainacademy.service.WebDriverService;

public class Apprunner {

    public static void main(String[] args) {
        WebDriver webDriver = WebDriverService.getWebDriver("https://www.amazon.com");
        webDriver = AmazonSearchService.getSearchResultPage(webDriver, "hp omen 15");
        while (!AmazonSearchService.isItemPresent("B08835NTQZ", webDriver)) {
            webDriver = AmazonSearchService.goToNextPage(webDriver);
        }
        webDriver = AmazonSearchService.getItemPage("B08835NTQZ", webDriver);
        webDriver = AmazonItemHandleService.addItemToCart(webDriver);
        webDriver.quit();
    }

}
