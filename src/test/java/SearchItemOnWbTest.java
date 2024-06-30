import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class SearchItemOnWbTest extends TestBase {

    @ValueSource(strings = {
            "163571936",
            "175440928"
    })
    @ParameterizedTest(name = "После нажатия на кнопку 'В избраное' должно появится модальное окно")
    void checkModalWindowWithSizesIfNoGoods(String articleNumber) {
        open("https://www.wildberries.ru/");
        $("#searchInput").click();
        $("#searchInput").setValue(articleNumber).pressEnter();
        $(".product-params__table").shouldHave(text(articleNumber));
        $(".order__for-fixed", 1).shouldHave(text("В избранное")).click();
        $(".popup__header").shouldHave(text("Выберите размер"));
    }


}
