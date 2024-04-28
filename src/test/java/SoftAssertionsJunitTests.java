import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SoftAssertionsJunitTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080"; // Разрешение браузера
        Configuration.pageLoadStrategy = "eager"; // Параметры загрузки страницы
    }
    @AfterEach
    void afterEach(){
        closeWebDriver();
    }

    @Test
    void softAssertionsShouldBeJuinit(){
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".markdown-body").find(byText("Soft assertions")).shouldBe(visible).click();
        $$("div.markdown-heading").findBy(text("JUnit5")).sibling(0)
                .shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));


    }

}
