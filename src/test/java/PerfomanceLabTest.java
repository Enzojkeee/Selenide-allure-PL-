import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.GooglePage;
import pages.GoogleResultPage;
import pages.PerfomanceLabPage;

import java.awt.*;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class PerfomanceLabTest extends BaseTest {

    private static final String GOOGLE_URL = "https://www.google.com/";


    /**
     *  Открыть Google, ввести в поле поиска performance lab и найти в ссылках сайт компании
     *  На сайте performance lab (https://www.performance-lab.ru/) найти вкладку Услуги и продукты
     *  -> Тестирование сайта (перейти), проверить что кнопка "Узнать цены" раскрашена синим цветом
     */
    @Test
    public void checkButtonColorIsBlue() throws InterruptedException, AWTException {
        GooglePage googlePage = new GooglePage(GOOGLE_URL);
        googlePage.searchPerfomanceLabPage();
        GoogleResultPage googleResultPage = new GoogleResultPage();
        googleResultPage.goToPerfomancePage();
        PerfomanceLabPage perfomanceLabPage = new PerfomanceLabPage();
//        Selenide.switchTo().frame(0).close();
        Thread.sleep(8000);
        Robot robot = new Robot();
        robot.mouseMove(10,10);
        robot.mousePress(1);
        $x("//div[@class='usr-req-button']").click();

//        perfomanceLabPage.closePopupWindow();
//        perfomanceLabPage.closeFrame();
    }

    @Test
    public void test()  {
        open("https://vk.com");


    }


}
