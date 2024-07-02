import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class YandexMusicTest extends TestBase {


    @DisplayName("Проверка ссылки в блоке навигации в категории {0}")
    @CsvFileSource(resources = "/testData/urlYandexData.csv")
    @ParameterizedTest()
    @Tag("№7896")
    void CheckUrlTest(String navKidsItem, String link) {
        open("https://music.yandex.ru/home");
        $(".pay-promo-close-btn.js-close").click();
        $$(".nav-kids a").find(text(navKidsItem)).click();
        webdriver().shouldHave(url(link));
    }


}
