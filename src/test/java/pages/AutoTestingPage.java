package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;


public class AutoTestingPage {

    private SelenideElement EXAMPLE_OF_PROJECT_IMAGE =
            Selenide.$x("//img[contains(@class, 'wp-image-1544')]");

    @Step("Scroll to Examples of projects image")
    public void scrollToExampleImage() {
        EXAMPLE_OF_PROJECT_IMAGE.scrollIntoView(true);
    }
    @Step("Click on Example of projects image")
    public void clickToExampleImage() {
        EXAMPLE_OF_PROJECT_IMAGE.click();
    }

    @Step("Switch control to contact frame")
    public void switchUseToIframe() {
        Selenide.switchTo().frame("hubspot-Modal-Iframe");
        Selenide.switchTo().frame("hs-form-iframe-0");
    }


}
