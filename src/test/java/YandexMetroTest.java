import data.Language;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class YandexMetroTest extends TestBase {


    @EnumSource(Language.class)
    @ParameterizedTest
    @DisplayName("Проверка смены языка заголовка")
    void displayCorrectText(Language chooseLanguage) {
        open("https://yandex.com/support2/metro/en/");
        $(".g-popover__handler button", 1).click();
        $$(".g-popup_open button").find(text(chooseLanguage.name())).click();
        $(".dc-doc-page__content h1").shouldHave(text(chooseLanguage.headerText));
    }

}
