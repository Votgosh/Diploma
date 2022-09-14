package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreditPage {
    private final SelenideElement heading = $$(".heading").find(exactText("Кредит по данным карты"));
    private final SelenideElement number = $(".input [placeholder='0000 0000 0000 0000']");
    private final SelenideElement month = $(".input [placeholder='08']");
    private final SelenideElement year = $(".input [placeholder='22']");
    private final SelenideElement holder = $$(".input__top").find(text("Владелец")).parent();
    private final SelenideElement cardHolder = holder.$(".input__control");
    private final SelenideElement cvv = $(".input [placeholder='999']");
    private final SelenideElement proceedButton = $(".form-field button");
    private final SelenideElement approvedMessage = $(".notification_status_ok");
    private final SelenideElement declinedMessage = $(".notification_status_error");
    private final SelenideElement improperFormat = $(byText("Неверный формат"));
    private final SelenideElement empty = $(byText("Поле обязательно для заполнения"));
    private final SelenideElement invalidData = $(byText("Неверно указан срок действия карты"));
    private final SelenideElement expiredData = $(byText("Истёк срок действия карты"));
    private final ElementsCollection resultLinks = $$(".input__top");

    public CreditPage() {
        heading.shouldBe(Condition.visible);
    }

    public void creditCardInformation(DataHelper.CardInfo info) {
        number.setValue(info.getNumber());
        month.setValue(info.getMonth());
        year.setValue(info.getYear());
        cardHolder.setValue(info.getHolder());
        cvv.setValue(info.getCvv());
        proceedButton.click();
    }

    public void approved() {
        approvedMessage.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void declined() {
        declinedMessage.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void shouldValueFieldNumberCard() {
        var fieldNumberCard = resultLinks.find(text("Номер карты")).parent();
        fieldNumberCard.shouldHave(text("Неверный формат"));
    }

    public void shouldValueFieldMonth() {
        var fieldMonth = resultLinks.find(text("Месяц")).parent();
        fieldMonth.shouldHave(text("Неверный формат"));

    }

    public void shouldValueFieldYear() {
        var fieldYear = resultLinks.find(text("Год")).parent();
        fieldYear.shouldHave(text("Неверный формат"));
    }

    public void shouldValueFieldCVV() {
        var fieldCVC = resultLinks.find(text("CVC/CVV")).parent();
        fieldCVC.shouldHave(text("Неверный формат"));
    }

    public void shouldValueFieldHolder() {
        var fieldHolderCard = resultLinks.find(text("Владелец")).parent();
        fieldHolderCard.shouldHave(text("Поле обязательно для заполнения"));
    }

    public void shouldValidFieldHolder() {
        var fieldCardHolder = resultLinks.find(text("Владелец")).parent();
        fieldCardHolder.shouldHave(text("Неверный формат"));
    }

    public void shouldImproperFormatMessage() {
        improperFormat.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void shouldEmptyFieldMessage() {

        empty.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void shouldInvalidDataMessage() {
        invalidData.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void shouldExpiredDataMessage() {
        expiredData.shouldBe(Condition.visible);
    }
}