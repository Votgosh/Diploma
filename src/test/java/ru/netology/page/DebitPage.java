package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DebitPage {
    private final SelenideElement heading = $$(".heading").find(exactText("Оплата по карте"));
    private final SelenideElement number = $(".input [placeholder='0000 0000 0000 0000']");
    private final SelenideElement month = $("input[placeholder='08']");
    private final SelenideElement year = $("input[placeholder='22']");
    private final SelenideElement holder = $$(".input__top").find(text("Владелец")).parent();
    private final SelenideElement cardHolder = holder.$(".input__control");
    private final SelenideElement cvv = $("input[placeholder='999']");
    private final SelenideElement buttonContinue = $$("button").find(exactText("Продолжить"));
    private final ElementsCollection resultLinks = $$(".input__top");
    private final SelenideElement improperFormat = $(byText("Неверный формат"));
    private final SelenideElement emptyField = $(byText("Поле обязательно для заполнения"));
    private final SelenideElement invalidData = $(byText("Неверно указан срок действия карты"));
    private final SelenideElement expiredData = $(byText("Истёк срок действия карты"));
    private final SelenideElement approvedMessage = $(".notification_status_ok");
    private final SelenideElement declinedMessage = $(".notification_status_error");


    public void debitCardInformation(DataHelper.CardInfo cardInformation) {
        number.setValue(cardInformation.getNumber());
        month.setValue(cardInformation.getMonth());
        year.setValue(cardInformation.getYear());
        cardHolder.setValue(cardInformation.getHolder());
        cvv.setValue(cardInformation.getCvv());
        buttonContinue.click();
    }

    public void improperFormatMessage() {
        improperFormat.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void emptyFieldMessage() {

        emptyField.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void invalidDataMessage() {
        invalidData.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void expiredDataMessage() {
        expiredData.shouldBe(Condition.visible);
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
        var fieldCVV = resultLinks.find(text("CVC/CVV")).parent();
        fieldCVV.shouldHave(text("Неверный формат"));
    }

    public void shouldValueFieldHolder() {
        var fieldHolderCard = resultLinks.find(text("Владелец")).parent();
        fieldHolderCard.shouldHave(text("Поле обязательно для заполнения"));
    }

    public void shouldValidFieldHolder() {
        var fieldCardHolder = resultLinks.find(text("Владелец")).parent();
        fieldCardHolder.shouldHave(text("Неверный формат"));
    }
}