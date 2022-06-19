package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class AutoTestingPage {
    private static final SelenideElement EXAMPLE_OF_PROJECT_IMAGE =
            Selenide.$x("//img[contains(@class, 'wp-image-1544')]");

    public static void scrollToExampleImage(){
        EXAMPLE_OF_PROJECT_IMAGE.scrollIntoView(true);
    }

    public static void clickToExampleImage(){
        EXAMPLE_OF_PROJECT_IMAGE.click();
    }

    public static void switchUseToIframe(){
        Selenide.switchTo().frame("hubspot-Modal-Iframe");
        Selenide.switchTo().frame("hs-form-iframe-0");
    }

    public static void firstNameCheck(){
        Selenide.$x("//input[@id='firstname-ae52b19d-a506-4b2a-87c5-e1dea1fd0559']").setValue("[eq");

    }

}
