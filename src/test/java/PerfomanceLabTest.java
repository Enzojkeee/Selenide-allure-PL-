import com.codeborne.selenide.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class PerfomanceLabTest extends BaseTest {


    /**
     * Открыть Google, ввести в поле поиска performance lab и найти в ссылках сайт компании
     * На сайте performance lab (https://www.performance-lab.ru/) найти вкладку Услуги и продукты
     * -> Тестирование сайта (перейти), проверить что кнопка "Узнать цены" раскрашена синим цветом
     */
    @Test
    public void checkButtonColorIsBlue() {
        GooglePage googlePage = new GooglePage();
        googlePage.openGoogle(getValue("googleURL"));
        googlePage.Search(getValue("plSearchValue"));
        googlePage.clickResult("Перфоманс Лаб - Услуги по тестированию");
        PerfomanceLabPage perfomanceLabPage = new PerfomanceLabPage();
        MainMenu mainMenu = new MainMenu();
        mainMenu.goToWebsiteTestingPage();
        step("Проверяем что кнопка узнать цену синяя.",()->
        {
            Assertions.assertEquals("rgba(79, 173, 255, 1)", WebTestingPage.getPricesButtonColor());
        } );


    }

    /**
     * На сайте performance lab (https://www.performance-lab.ru/) найти вкладку Услуги и продукты ->
     * Автоматизация тестирования (перейти),отмотать страницу до "Примеры выполненных проектов",
     * нажать на картинку под темой и проверить, что открылась форма для заполнения контактов.
     */


    @Test
    public void checkExamplesOfProjectsForm() {
        PerfomanceLabPage perfomanceLabPage = new PerfomanceLabPage();
        perfomanceLabPage.openPerfomanceLabPage();
        MainMenu mainMenu = new MainMenu();
        mainMenu.goToAutoTestingPage();
        AutoTestingPage autoTestingPage = new AutoTestingPage();
        autoTestingPage.scrollToExampleImage();
        autoTestingPage.clickToExampleImage();
        autoTestingPage.switchUseToIframe();
        step("Проверяем, что открылась и доступна форма для заполнения контактов", ()->{
            $x("//div[@class='hbspt-form']").shouldBe(Condition.editable);
        });


    }


}
/**
 * Добавляем эелемент, который отвечает за количество входов, в паблик сторедж - один из вариантов обхода баннера
 * При входе на главную страницу появляется баннер:
 * Возможность пропустить баннер роботом и клавишей ESC
 * Robot r = new Robot();
 * r.keyPress(KeyEvent.VK_ESCAPE);
 * r.keyRelease(KeyEvent.VK_ESCAPE);
 * Move element и hover не работают, при наведении display:false, поэтому по ссылке переход осуществлен JS
 */
//        Selenide.localStorage().setItem("grPopupsServiceKey", "{\"events\":[{\"aid\":\"b08aa1fe-55f8-42f3-a3b8-4d8b223562b6\"," +
//                "\"grid\":\"b08aa1fe-55f8-42f3-a3b8-4d8b223562b6\",\"uuid\":\"0c3976a5-31ef-4085-8eff-2eaa9fece51c\"," +
//                "\"externalUid\":null,\"time\":1169,\"url\":\"https://www.performance-lab.ru/\",\"eventType\":\"popup\"," +
//                "\"occurredOn\":\"Sat, 18 Jun 2022 13:39:31 GMT\",\"popupId\":\"89cef0cc-388d-4cb3-9313-8d8edd2a3e7d\"," +
//                "\"popupEvent\":\"show\"},{\"aid\":\"b08aa1fe-55f8-42f3-a3b8-4d8b223562b6\",\"grid\":\"b08aa1fe-55f8-42f3-a3b8-4d8b223562b6\"," +
//                "\"uuid\":\"0c3976a5-31ef-4085-8eff-2eaa9fece51c\",\"externalUid\":null,\"time\":5847,\"url\":\"https://www.performance-lab.ru/\"," +
//                "\"eventType\":\"popup\",\"occurredOn\":\"Sat, 18 Jun 2022 13:41:19 GMT\",\"popupId\":\"89cef0cc-388d-4cb3-9313-8d8edd2a3e7d\"," +
//                "\"popupEvent\":\"show\"},{\"aid\":\"b08aa1fe-55f8-42f3-a3b8-4d8b223562b6\",\"grid\":\"b08aa1fe-55f8-42f3-a3b8-4d8b223562b6\"," +
//                "\"uuid\":\"0c3976a5-31ef-4085-8eff-2eaa9fece51c\",\"externalUid\":null,\"time\":1466,\"url\":\"https://www.performance-lab.ru/\"," +
//                "\"eventType\":\"popup\",\"occurredOn\":\"Sat, 18 Jun 2022 13:42:34 GMT\",\"popupId\":\"89cef0cc-388d-4cb3-9313-8d8edd2a3e7d\"," +
//                "\"popupEvent\":\"show\"},{\"aid\":\"b08aa1fe-55f8-42f3-a3b8-4d8b223562b6\",\"grid\":\"b08aa1fe-55f8-42f3-a3b8-4d8b223562b6\"," +
//                "\"uuid\":\"0c3976a5-31ef-4085-8eff-2eaa9fece51c\",\"externalUid\":null,\"time\":5884,\"url\":\"https://www.performance-lab.ru/\"," +
//                "\"eventType\":\"popup\",\"occurredOn\":\"Sat, 18 Jun 2022 13:43:06 GMT\",\"popupId\":\"89cef0cc-388d-4cb3-9313-8d8edd2a3e7d\"," +
//                "\"popupEvent\":\"show\"},{\"aid\":\"b08aa1fe-55f8-42f3-a3b8-4d8b223562b6\",\"grid\":\"b08aa1fe-55f8-42f3-a3b8-4d8b223562b6\"," +
//                "\"uuid\":\"0c3976a5-31ef-4085-8eff-2eaa9fece51c\",\"externalUid\":null,\"time\":5452,\"url\":\"https://www.performance-lab.ru/\"," +
//                "\"eventType\":\"popup\",\"occurredOn\":\"Sat, 18 Jun 2022 13:43:41 GMT\",\"popupId\":\"89cef0cc-388d-4cb3-9313-8d8edd2a3e7d\"," +
//                "\"popupEvent\":\"show\"}]}");
//        Selenide.refresh();
//


/** При входе на главную страницу появляется баннер:
 * Возможность пропустить баннер роботом и клавишей ESC
 *         Robot r = new Robot();
 *         r.keyPress(KeyEvent.VK_ESCAPE);
 *         r.keyRelease(KeyEvent.VK_ESCAPE);
 *  Move element и hover не работают, при наведении display:false, поэтому по ссылке переход осуществлен JS
 */

